package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDto;
import com.github.mrptqp.realworld.users.entities.User;

public interface CustomerService {

    UserDto saveUser(RegisterCredentials registerCredentials);

    User findById(Long id);

    UserDto login(String email, String password);
}
