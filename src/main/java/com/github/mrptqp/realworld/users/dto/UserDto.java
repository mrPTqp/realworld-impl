package com.github.mrptqp.realworld.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class UserDto {
    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("token")
    private Optional<String> token;

    @JsonProperty("bio")
    private Optional<String> bio;

    @JsonProperty("image")
    private Optional<String> image;

}
