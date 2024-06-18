package com.example.demo.controller.user.dto;

import com.example.demo.service.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDetailResponseDto {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;
    private String job;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

