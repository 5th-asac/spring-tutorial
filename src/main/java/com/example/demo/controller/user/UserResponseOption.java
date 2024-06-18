package com.example.demo.controller.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseOption {
    @NotNull
    private Boolean isShowAge;
    @NotNull
    private Boolean isShowSpecialty;
}
