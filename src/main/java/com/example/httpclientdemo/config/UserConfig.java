package com.example.httpclientdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
    @Bean
    UserDetailsService userDetailsService() {
        var user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
