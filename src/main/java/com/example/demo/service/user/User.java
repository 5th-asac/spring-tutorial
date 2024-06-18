package com.example.demo.service.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private Integer age;
    private String job;
    private String specialty;
}