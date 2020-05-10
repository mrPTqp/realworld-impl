package com.github.mrptqp.realworld.service;

import com.github.mrptqp.realworld.entities.User;

public interface CustomerService {

    User saveUser(User user);

    User findById(Long id);

    String login(String email, String password);
}
