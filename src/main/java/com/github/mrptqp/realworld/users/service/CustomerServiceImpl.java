package com.github.mrptqp.realworld.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrptqp.realworld._exceptions.UserAlreadyExistException;
import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDto;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("customerService")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    //    private final PasswordEncoder encoder;
    private final ObjectMapper objectMapper;

    @Override
    public UserDto saveUser(RegisterCredentials registerCredentials) {
        customerRepository.findByEmail(registerCredentials.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });

        customerRepository.findByUsername(registerCredentials.getUsername())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });

        User user = new User();
        user.setEmail(registerCredentials.getEmail());
        user.setUsername(registerCredentials.getUsername());
        user.setPassword(registerCredentials.getPassword());

        customerRepository.save(user);

        return new UserDto(
                user.getEmail(),
                user.getUsername(),
                null,
                null,
                null,
                user.getPassword()
        );
    }

    @Override
    public UserDto findById(Long id) {
        User user = customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your id"));

        return new UserDto(
                user.getEmail(),
                user.getUsername(),
                user.getToken(),
                user.getBio(),
                user.getImage(),
                user.getPassword()
        );
    }

    @Override
    public UserDto login(String email, String password) {
        String existPassword = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"))
                .getPassword();

        if (existPassword.equals(password)) {
            User user = customerRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"));

            return new UserDto(
                    user.getEmail(),
                    user.getUsername(),
                    user.getToken(),
                    user.getBio(),
                    user.getImage(),
                    user.getPassword()
            );
        } else {
            throw new RuntimeException("Wrong password, please try again");
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
//            customerRepository.save(user);
//
//            return token;
//        };
//    }

}
