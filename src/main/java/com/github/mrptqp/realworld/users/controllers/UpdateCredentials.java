package com.github.mrptqp.realworld.users.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
