package com.github.mrptqp.realworld.profiles.controllers;

import com.github.mrptqp.realworld.profiles.dto.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    @GetMapping("/profiles/{username}")
    public Profile getProfile(@PathVariable("username") String username) {
        Profile mock = new Profile();
        mock.setUsername("MOCK");
        mock.setBio("MOCK");
        mock.setImage("MOCK");

        return mock;
    }

    @PostMapping("/profiles/{username}/follow")
    public Profile follow(@PathVariable("username") String username) {
        Profile mock = new Profile();
        mock.setUsername("MOCK");
        mock.setBio("MOCK");
        mock.setImage("MOCK");

        return mock;
    }

    @DeleteMapping("/profiles/{username}/follow")
    public Profile unfollow(@PathVariable("username") String username) {
        Profile mock = new Profile();
        mock.setUsername("MOCK");
        mock.setBio("MOCK");
        mock.setImage("MOCK");

        return mock;
    }
}
