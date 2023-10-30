package com.example.httpclientdemo.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {

    private final UserDetailsService userDetailsService;
    public UserRepo (UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    public UserDetails findUser(String username){
        return userDetailsService.loadUserByUsername(username);
    }
}
