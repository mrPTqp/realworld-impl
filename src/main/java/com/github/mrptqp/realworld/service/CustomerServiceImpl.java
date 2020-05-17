package com.github.mrptqp.realworld.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrptqp.realworld.entities.User;
import com.github.mrptqp.realworld.exceptions.UserAlreadyExistException;
import com.github.mrptqp.realworld.exceptions.UserNotFoundException;
import com.github.mrptqp.realworld.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;

@Service("customerService")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    //    private final PasswordEncoder encoder;
    private final ObjectMapper objectMapper;

    @Override
    public User saveUser(User user) {
        customerRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });

        customerRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new UserAlreadyExistException("User already exists! Choose a different name.");
                });

        customerRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your id"));
    }

    @Override
    public User login(String email, String password) {
        String existPassword = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"))
                .getPassword();

        if (existPassword.equals(password)) {
            return customerRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"));
        } else {
            throw new RuntimeException("Wrong password, please try again");
        }
    }

    private Function<User, String> getActualToken() {
        return user -> {
            String existingToken = user.getToken();

            if (existingToken != null) {
                LocalDateTime expireDate = user.getExpireDate();

                if (expireDate.isAfter(LocalDateTime.now())) {
                    return existingToken;
                }
            }

            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setExpireDate(LocalDateTime.now().plusHours(24));
            customerRepository.save(user);

            return token;
        };
    }

}
