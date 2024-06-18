package com.example.demo.controller.user.dto;

import com.example.demo.service.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;

    public static UserResponseDto of(User user, Boolean isShowAge) {
        return new UserResponseDto(
                user.getName(),
                isShowAge ? user.getAge() : null
        );
    }
}
