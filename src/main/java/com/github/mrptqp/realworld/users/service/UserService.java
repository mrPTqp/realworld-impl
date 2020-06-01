package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld._security.ConduitUserDetails;
import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.controllers.UpdateCredentials;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;

public interface UserService {

    UserDtoWrapper saveUser(RegisterCredentials registerCredentials);

    UserDtoWrapper getCurrentUser(String email);

    UserDtoWrapper login(String email, String password);

    UserDtoWrapper updateUser(ConduitUserDetails userDetails, UpdateCredentials updateCredentials);
}
