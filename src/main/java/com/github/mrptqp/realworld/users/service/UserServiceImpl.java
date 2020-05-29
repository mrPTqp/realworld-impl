package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld._exceptions.BadRequestException;
import com.github.mrptqp.realworld._exceptions.UnauthorizedException;
import com.github.mrptqp.realworld._exceptions.UserAlreadyExistException;
import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld._security.JwtUtil;
import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
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
        userRepository
                .findByEmail(registerCredentials.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different email.");
                });

        userRepository
                .findByUsername(registerCredentials.getUsername())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });

        User user = new User();
        user.setEmail(registerCredentials.getEmail());
        user.setUsername(registerCredentials.getUsername());
        user.setPassword(encoder.encode(registerCredentials.getPassword()));

        userRepository.save(user);

        UserDto userDto = new UserDto(
                user.getEmail(),
                user.getUsername(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
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
        String existPassword = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login"))
                .getPassword();

        if (encoder.matches(password, existPassword)) {
            User user = userRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException(
                            "User not found. Please check your login and password"
                    ));

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

}
