package com.example.demo.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {
    private final Integer id;
    private final String name;
    private final Integer age;
    private final String job;
    private final String specialty;
}
