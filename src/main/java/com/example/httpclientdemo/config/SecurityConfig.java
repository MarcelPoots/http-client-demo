package com.example.httpclientdemo.config;


import com.example.httpclientdemo.filter.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String API_TOKEN = "/api/token/**";
    private JwtTokenFilter jwtTokenFilter;

    public SecurityConfig (JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    @Order(1)
    SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/api/customer/**")
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain tokenSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher(API_TOKEN))
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers(AntPathRequestMatcher.antMatcher(API_TOKEN)).permitAll();
                })
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher(API_TOKEN)))
                .headers(headers -> headers.frameOptions().disable()) //NOSONAR
                .build();
    }

    @Bean
    @Order(3)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/").permitAll();
                            auth.requestMatchers("/error").permitAll();
                            auth.anyRequest().authenticated();
                        }
                )
                .formLogin(withDefaults())
                .build();
    }


}