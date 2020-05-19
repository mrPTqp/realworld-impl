package com.github.mrptqp.realworld.users.controllers;

import com.github.mrptqp.realworld.users.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCurrentUserController {

    @GetMapping("/user")
    public User getCurrentUser() {
        User mock = new User();
        mock.setUsername("MOCK");
        mock.setEmail("MOCK");
        return mock;
    }
}
