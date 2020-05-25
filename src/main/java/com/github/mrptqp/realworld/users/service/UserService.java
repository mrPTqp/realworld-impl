package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;

public interface UserService {

    UserDtoWrapper saveUser(RegisterCredentials registerCredentials);

    UserDtoWrapper getCurrentUser(String email);

    UserDtoWrapper login(String email, String password);
}
