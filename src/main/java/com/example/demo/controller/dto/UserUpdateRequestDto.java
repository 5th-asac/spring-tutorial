package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // = @NoArgConstructor + @Setter
public class UserUpdateRequestDto {
    private String job;
    private String specialty;
}