package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld._exceptions.UnauthorizedException;
import com.github.mrptqp.realworld._exceptions.UserAlreadyExistException;
import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDto;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
//    private final ObjectMapper objectMapper;

    @Override
    public UserDtoWrapper saveUser(RegisterCredentials registerCredentials) {
        userRepository
                .findByEmail(registerCredentials.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
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
                null,
                null,
                null
        );

        return new UserDtoWrapper(userDto);
    }

    @Override
    public UserDtoWrapper findById(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your id"));

        UserDto userDto = new UserDto(
                user.getEmail(),
                user.getUsername(),
                null,
                null,
                null
        );

        return new UserDtoWrapper(userDto);
    }

    @Override
    public UserDtoWrapper login(String email, String password) {
        String existPassword = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"))
                .getPassword();

        if (encoder.matches(password, existPassword)) {
            User user = userRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException(
                            "User not found. Please check your login and password"
                    ));

            UserDto userDto = new UserDto(
                    user.getEmail(),
                    user.getUsername(),
                    null,
                    null,
                    null
            );

            return new UserDtoWrapper(userDto);
        } else {
            throw new UnauthorizedException("Password is incorrect, try again.");
        }
    }

//    private Function<User, String> getActualToken() {
//        return user -> {
//            String existingToken = user.getToken();
//
//            if (existingToken != null) {
//                LocalDateTime expireDate = user.getExpireDate();
//
//                if (expireDate.isAfter(LocalDateTime.now())) {
//                    return existingToken;
//                }
//            }
//
//            String token = UUID.randomUUID().toString();
//            user.setToken(token);
//            user.setExpireDate(LocalDateTime.now().plusHours(24));
//            userRepository.save(user);
//
//            return token;
//        };
//    }

}
