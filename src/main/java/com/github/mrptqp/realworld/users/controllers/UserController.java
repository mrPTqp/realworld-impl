package com.github.mrptqp.realworld.users.controllers;

import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;
import com.github.mrptqp.realworld.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserDtoWrapper addUser(@RequestBody RegisterCredentials registerCredentials) {
        return userService.saveUser(registerCredentials);
    }

    @PostMapping("/users/login")
    public UserDtoWrapper login(@RequestBody LoginCredentials loginCredentials) {
        return userService.login(loginCredentials.getEmail(), loginCredentials.getPassword());
    }

    @GetMapping("/user")
    public UserDtoWrapper getCurrentUser(@AuthenticationPrincipal ConduitUserDetails user) {
        return userService.getCurrentUser(user.getEmail());
    }

    @PutMapping("/user")
    public UserDtoWrapper updateUser(
            @AuthenticationPrincipal ConduitUserDetails userDetails,
            @RequestBody UpdateCredentials updateCredentials
    ) {
        return userService.updateUser(userDetails, updateCredentials);
    }
}