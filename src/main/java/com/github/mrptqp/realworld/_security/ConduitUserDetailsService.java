package com.github.mrptqp.realworld._security;

import com.github.mrptqp.realworld.users.entities.User;
import com.github.mrptqp.realworld.users.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConduitUserDetailsService implements UserDetailsService {
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional
                .ofNullable(username)
                .map(String::valueOf)
                .flatMap(customerRepository::findByEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with email=" + username));

        return new ConduitUserDetails(user);
    }
}
