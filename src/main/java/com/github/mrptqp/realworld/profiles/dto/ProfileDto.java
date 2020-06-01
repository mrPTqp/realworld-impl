package com.github.mrptqp.realworld.profiles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ProfileDto {
    @JsonProperty("username")
    private String username;

    @JsonProperty("bio")
    private Optional<String> bio;

    @JsonProperty("image")
    private Optional<String> image;

    @JsonProperty("following")
    private boolean following;
}
