package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.model.TokenInfo;
import com.example.httpclientdemo.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class TokenController {


    JwtTokenUtil jwtTokenUtil;

    public TokenController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping(value = "/{username}")
    public TokenInfo token(@PathVariable String username) {

        return new TokenInfo( jwtTokenUtil.generateToken(username));
    }

}
