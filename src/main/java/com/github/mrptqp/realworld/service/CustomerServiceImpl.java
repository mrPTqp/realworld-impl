package com.github.mrptqp.realworld.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrptqp.realworld.entities.User;
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
    public String login(String email, String password) {
        String savedPassword = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"))
                .getPassword();

//        if (!encoder.matches(password, savedPassword)) {
//            throw new UnauthorizedException("Password is incorrect, try again.");
//        }

        return customerRepository.login(email, savedPassword).map(getActualToken())
                .orElseThrow(() -> new UserNotFoundException("User not found. Please check your login and password"));
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
