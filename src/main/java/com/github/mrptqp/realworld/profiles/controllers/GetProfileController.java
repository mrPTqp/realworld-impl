package com.github.mrptqp.realworld.profiles.controllers;

import com.github.mrptqp.realworld.profiles.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetProfileController {

    @GetMapping("/profiles/{username}")
    public Profile getProfile(@PathVariable("username") String username) {
        Profile mock = new Profile();
        mock.setUsername("MOCK");
        mock.setBio("MOCK");
        mock.setImage("MOCK");

        return mock;
    }
}
