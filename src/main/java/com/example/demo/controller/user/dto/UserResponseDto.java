package com.example.demo.controller.user.dto;

import com.example.demo.service.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private String name;
    private Integer age;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(
                user.getName(),
                user.getAge()
        );
    }
}
