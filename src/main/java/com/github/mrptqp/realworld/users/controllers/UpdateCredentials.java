package com.github.mrptqp.realworld.users.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@JsonRootName("user")
@NoArgsConstructor
public class UpdateCredentials {
    @Email(message = "should be an email")
    private String email;
    private String password;
    private String username;
    private String bio;
    private String image;
}
