package com.github.mrptqp.realworld.profiles.controllers;

import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.profiles.dto.ProfileDtoWrapper;
import com.github.mrptqp.realworld.profiles.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/profiles/{username}")
    public ProfileDtoWrapper getProfile(
            @AuthenticationPrincipal ConduitUserDetails currentUserDetails,
            @PathVariable("username") String username) {
        return profileService.getProfile(currentUserDetails, username);
    }

    @PostMapping("/profiles/{username}/follow")
    public ProfileDtoWrapper follow(
            @AuthenticationPrincipal ConduitUserDetails currentUserDetails,
            @PathVariable("username") String username) {
        return profileService.follow(currentUserDetails, username);
    }

    @DeleteMapping("/profiles/{username}/follow")
    public ProfileDtoWrapper unfollow(
            @AuthenticationPrincipal ConduitUserDetails currentUserDetails,
            @PathVariable("username") String username) {
        return profileService.unfollow(currentUserDetails, username);
    }
}
