package com.example.httpclientdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {
    private String id;
    private String name;
    private String gender;
    private int age;
}
