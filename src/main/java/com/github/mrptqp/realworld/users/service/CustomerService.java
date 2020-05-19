package com.github.mrptqp.realworld.users.service;

import com.github.mrptqp.realworld.users.entities.User;

public interface CustomerService {

    User saveUser(User user);

    User findById(Long id);

    User login(String email, String password);
}
