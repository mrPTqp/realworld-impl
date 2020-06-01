package com.github.mrptqp.realworld.profiles.service;

import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.profiles.dto.ProfileDto;
import com.github.mrptqp.realworld.profiles.dto.ProfileDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("profileService")
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepository userRepository;

    @Override
    public ProfileDtoWrapper getProfile(ConduitUserDetails currentUserDetails, String username) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));

        if (currentUserDetails != null) {
            User currentUser = userRepository
                    .findByUsername(currentUserDetails.getUsername())
                    .orElseThrow(() -> new UserNotFoundException(
                            "User not found. Please check your login and password"
                    ));

            boolean isFollow;
            isFollow = user.getSubscribers().contains(currentUser);

            ProfileDto profileDto = new ProfileDto(
                    user.getUsername(),
                    Optional.ofNullable(user.getBio()),
                    Optional.ofNullable(user.getImage()),
                    isFollow
            );

            return new ProfileDtoWrapper(profileDto);
        } else {
            ProfileDto profileDto = new ProfileDto(
                    user.getUsername(),
                    Optional.ofNullable(user.getBio()),
                    Optional.ofNullable(user.getImage()),
                    false
            );

            return new ProfileDtoWrapper(profileDto);
        }
    }

    @Override
    public ProfileDtoWrapper follow(ConduitUserDetails currentUserDetails, String username) {
        User currentUser = userRepository
                .findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));

        user.getSubscribers().add(currentUser);
        userRepository.save(user);

        ProfileDto profileDto = new ProfileDto(
                user.getUsername(),
                Optional.ofNullable(user.getBio()),
                Optional.ofNullable(user.getImage()),
                true
        );

        return new ProfileDtoWrapper(profileDto);
    }

    @Override
    public ProfileDtoWrapper unfollow(ConduitUserDetails currentUserDetails, String username) {
        User currentUser = userRepository
                .findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));

        user.getSubscribers().remove(currentUser);
        userRepository.save(user);

        ProfileDto profileDto = new ProfileDto(
                user.getUsername(),
                Optional.ofNullable(user.getBio()),
                Optional.ofNullable(user.getImage()),
                false
        );

        return new ProfileDtoWrapper(profileDto);
    }

}
