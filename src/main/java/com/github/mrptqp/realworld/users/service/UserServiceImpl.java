package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld._exceptions.BadRequestException;
import com.github.mrptqp.realworld._exceptions.UnauthorizedException;
import com.github.mrptqp.realworld._exceptions.UserAlreadyExistException;
import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld._security.JwtUtil;
import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.controllers.UpdateCredentials;
import com.github.mrptqp.realworld.users.dto.UserDto;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtTokenUtil;
    private final PasswordEncoder encoder;

    @Override
    public UserDtoWrapper saveUser(RegisterCredentials registerCredentials) {
        checkEmail(registerCredentials.getEmail());
        checkUsername(registerCredentials.getUsername());

        User user = new User();
        user.setEmail(registerCredentials.getEmail());
        user.setUsername(registerCredentials.getUsername());
        user.setPassword(encoder.encode(registerCredentials.getPassword()));

        userRepository.save(user);

        UserDto userDto = new UserDto(
                user.getEmail(),
                user.getUsername(),
                Optional.ofNullable(user.getToken()),
                Optional.ofNullable(user.getBio()),
                Optional.ofNullable(user.getImage())
        );

        return new UserDtoWrapper(userDto);
    }

    @Override
    public UserDtoWrapper getCurrentUser(String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Invalid token"));

        UserDto userDto = new UserDto(
                user.getEmail(),
                user.getUsername(),
                Optional.ofNullable(user.getToken()),
                Optional.ofNullable(user.getBio()),
                Optional.ofNullable(user.getImage())
        );

        return new UserDtoWrapper(userDto);
    }

    @Override
    public UserDtoWrapper login(String email, String password) {
        String existPassword = getPasswordFromRepository(email);

        if (encoder.matches(password, existPassword)) {
            User user = getUserFromRepository(email);

            userRepository
                    .login(email, existPassword)
                    .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"));

            user.setToken(jwtTokenUtil.generateToken(email));
            userRepository.save(user);

            UserDto userDto = new UserDto(
                    user.getEmail(),
                    user.getUsername(),
                    Optional.ofNullable(user.getToken()),
                    Optional.ofNullable(user.getBio()),
                    Optional.ofNullable(user.getImage())
            );

            return new UserDtoWrapper(userDto);
        } else {
            throw new UnauthorizedException("Password is incorrect, try again.");
        }
    }

    @Override
    public UserDtoWrapper updateUser(ConduitUserDetails userDetails, UpdateCredentials updateCredentials) {
        User user = getUserFromRepository(userDetails.getUsername());
        setUpdatedParameters(updateCredentials, user);
        userRepository.save(user);

        UserDto userDto = new UserDto(
                user.getEmail(),
                user.getUsername(),
                Optional.ofNullable(user.getToken()),
                Optional.ofNullable(user.getBio()),
                Optional.ofNullable(user.getImage())
        );

        return new UserDtoWrapper(userDto);
    }

    private void checkEmail(String email) {
        userRepository
                .findByEmail(email)
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different email.");
                });
    }

    private void checkUsername(String username) {
        userRepository
                .findByUsername(username)
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });
    }

    private void setUpdatedParameters(UpdateCredentials updateCredentials, User user) {
        String updatedEmail = updateCredentials.getEmail();

        if (!"".equals(updatedEmail)) {
            checkEmail(updatedEmail);
            user.setEmail(updatedEmail);
        }

        String updatedUsername = updateCredentials.getUsername();

        if (!"".equals(updatedUsername)) {
            checkUsername(updatedUsername);
            user.setUsername(updatedUsername);
        }

        if (!"".equals(updateCredentials.getPassword())) {
            user.setPassword(encoder.encode(updateCredentials.getPassword()));
        }

        if (!"".equals(updateCredentials.getBio())) {
            user.setBio(updateCredentials.getBio());
        }

        if (!"".equals(updateCredentials.getImage())) {
            user.setImage(updateCredentials.getImage());
        }

        user.setToken(jwtTokenUtil.generateToken(updatedEmail));
    }

    private User getUserFromRepository(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login"
                ));
    }

    private String getPasswordFromRepository(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login"))
                .getPassword();
    }
}
