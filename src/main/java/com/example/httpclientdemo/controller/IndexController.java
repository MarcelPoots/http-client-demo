package com.example.httpclientdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
    public InfoObject index(){

        return new InfoObject("Demo server v1.0");
    }

    @Data
    @AllArgsConstructor
    class InfoObject {
        private String info;
    }
}
