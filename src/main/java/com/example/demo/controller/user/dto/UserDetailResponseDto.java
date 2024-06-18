package com.example.demo.controller.user.dto;

import com.example.demo.service.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDetailResponseDto {
    private String name;
    private Integer age;
    private String job;
    private String specialty;

    public static UserDetailResponseDto of(User user, Boolean isShowAge, Boolean isShowSpecialty) {
        return new UserDetailResponseDto(
                user.getName(),
                isShowAge ? user.getAge() : null,
                user.getJob(),
                isShowSpecialty ? user.getSpecialty() : null
        );
    }
}

