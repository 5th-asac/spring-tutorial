package com.example.demo.controller.dto;

import com.example.demo.repository.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private final Integer id;
    private final String name;
    private final Integer age;
    private final String job;
    private final String specialty;

    public static UserResponseDto of(User entity) {
        return new UserResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getJob(),
                entity.getSpecialty()
        );
    }
}
