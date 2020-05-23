package com.github.mrptqp.realworld.users.controllers;

import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/login")
    public UserDtoWrapper login(@RequestBody LoginCredentials loginCredentials) {
        return userService.login(loginCredentials.getEmail(), loginCredentials.getPassword());
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
        return userService.saveUser(registerCredentials);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody UpdateCredentials updateCredentials) {
        User mock = new User();
        mock.setUsername("MOCK");
        mock.setEmail("MOCK");
        return mock;
    }
}