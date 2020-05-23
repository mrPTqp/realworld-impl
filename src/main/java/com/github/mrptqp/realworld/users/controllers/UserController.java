package com.github.mrptqp.realworld.users.controllers;

import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerService customerService;

    @PostMapping("/users/login")
    public UserDtoWrapper login(@RequestBody LoginCredentials loginCredentials) {
        return customerService.login(loginCredentials.getEmail(), loginCredentials.getPassword());
    }

    @GetMapping("/user")
    public User getCurrentUser() {
        User mock = new User();
        mock.setUsername("MOCK");
        mock.setEmail("MOCK");
        return mock;
    }

    @PostMapping("/users")
    public UserDtoWrapper addUser(@RequestBody RegisterCredentials registerCredentials) {
        return customerService.saveUser(registerCredentials);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody UpdateCredentials updateCredentials) {
        User mock = new User();
        mock.setUsername("MOCK");
        mock.setEmail("MOCK");
        return mock;
    }
}