package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return new Customer(id,"Smith", "M", 25);
    }
}
