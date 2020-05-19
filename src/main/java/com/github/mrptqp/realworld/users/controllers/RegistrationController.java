package com.github.mrptqp.realworld.users.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.service.CustomerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final CustomerService customerService;

    @PostMapping("/users")
    public User addUser(@RequestBody RegisterCredentials registerCredentials) {
        User user = new User();
        user.setUsername(registerCredentials.getUsername());
        user.setEmail(registerCredentials.getEmail());
        user.setPassword(registerCredentials.getPassword());

        return customerService.saveUser(user);
    }
}

@Getter
@JsonRootName("user")
@NoArgsConstructor
class RegisterCredentials {
    @NotBlank(message = "can't be empty")
    private String username;
    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    private String email;
    @NotBlank(message = "can't be empty")
    private String password;
}