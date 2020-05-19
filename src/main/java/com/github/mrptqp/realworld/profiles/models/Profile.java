package com.github.mrptqp.realworld.profiles.models;

import lombok.Data;

@Data
public class Profile {
    private Long id;

    private String username;

    private String bio;

    private String image;

    private boolean following;
}
