package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld.users.controllers.RegisterCredentials;
import com.github.mrptqp.realworld.users.dto.UserDto;

public interface CustomerService {

    UserDto saveUser(RegisterCredentials registerCredentials);

    UserDto findById(Long id);

    UserDto login(String email, String password);
}
