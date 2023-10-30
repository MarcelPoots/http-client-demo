package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.model.ServerInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping(value = "/", produces = { "application/json" })
    public ServerInfo index(){

        return new ServerInfo("v1.0","Demo server v1.0");
    }


}
