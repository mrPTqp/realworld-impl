package com.github.mrptqp.realworld.profiles.service;

import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.profiles.dto.ProfileDtoWrapper;

public interface ProfileService {

    ProfileDtoWrapper getProfile(ConduitUserDetails currentUserDetails, String username);

    ProfileDtoWrapper follow(ConduitUserDetails currentUserDetails, String username);

    ProfileDtoWrapper unfollow(ConduitUserDetails currentUserDetails, String username);
}
