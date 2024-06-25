package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // = @NoArgConstructor + @Setter
public class UserCreateRequestDto {
    private String name;
    private Integer age;
}
