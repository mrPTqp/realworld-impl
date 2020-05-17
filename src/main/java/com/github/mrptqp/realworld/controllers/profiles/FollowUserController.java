package com.github.mrptqp.realworld.controllers.profiles;

import com.github.mrptqp.realworld.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FollowUserController {

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
