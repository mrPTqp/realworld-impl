package com.github.mrptqp.realworld.controllers.auth;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.mrptqp.realworld.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
public class UpdateUserController {

    @PutMapping("/user")
    public User updateUser(@RequestBody UpdateCredentials updateCredentials) {
        User mock = new User();
        mock.setUsername("MOCK");
        mock.setEmail("MOCK");
        return mock;
    }
}

@Getter
@JsonRootName("user")
@NoArgsConstructor
class UpdateCredentials {
    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    private String email;
    private String username;
    private String password;
    private String bio;
    private String image;
}
