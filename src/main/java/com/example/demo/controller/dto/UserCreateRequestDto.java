package com.example.demo.controller.dto;

import com.example.demo.repository.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // = @NoArgConstructor + @Setter
public class UserCreateRequestDto {
    private String name;
    private Integer age;

    public User toEntity() {
        return User.create(this.name, this.age);
    }
}
