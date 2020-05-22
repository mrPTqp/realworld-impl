package com.github.mrptqp.realworld.profiles.dto;

import lombok.Data;

@Data
public class Profile {
    private Long id;

    private String username;

    private String bio;

    private String image;

    private boolean following;
}
