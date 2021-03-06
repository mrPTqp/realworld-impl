package com.github.mrptqp.realworld.profiles.service;

import com.github.mrptqp.realworld._exceptions.UserNotFoundException;
import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.profiles.dto.ProfileDto;
import com.github.mrptqp.realworld.profiles.dto.ProfileDtoWrapper;
import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("profileService")
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepository userRepository;

    @Override
    public ProfileDtoWrapper getProfile(ConduitUserDetails currentUserDetails, String username) {
        User user = getUser(username);

        if (currentUserDetails != null) {
            User currentUser = getUser(currentUserDetails.getUsername());

            ProfileDto profileDto = new ProfileDto(
                    user.getUsername(),
                    Optional.ofNullable(user.getBio()),
                    Optional.ofNullable(user.getImage()),
                    user.getSubscribers().contains(currentUser)
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

    private User getUser(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found. Please check your login and password"
                ));
    }

    @Override
    @Transactional
    public ProfileDtoWrapper follow(ConduitUserDetails currentUserDetails, String username) {
        User currentUser = getUser(currentUserDetails.getUsername());
        User user = getUser(username);

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
    @Transactional
    public ProfileDtoWrapper unfollow(ConduitUserDetails currentUserDetails, String username) {
        User currentUser = getUser(currentUserDetails.getUsername());
        User user = getUser(username);

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
