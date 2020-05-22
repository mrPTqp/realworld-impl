package com.github.mrptqp.realworld.users.controllers;

import com.github.mrptqp.realworld.users.dto.UserDto;
import com.github.mrptqp.realworld.users.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final CustomerService customerService;

    @PostMapping("/users/login")
    public UserDto login(@RequestBody LoginCredentials loginCredentials) {
        return customerService.login(loginCredentials.getEmail(), loginCredentials.getPassword());
    }
}