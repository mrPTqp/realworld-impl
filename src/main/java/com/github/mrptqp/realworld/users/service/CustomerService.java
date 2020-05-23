package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDtoWrapper;

public interface CustomerService {

    UserDtoWrapper saveUser(RegisterCredentials registerCredentials);

    UserDtoWrapper findById(Long id);

    UserDtoWrapper login(String email, String password);
}
