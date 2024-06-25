package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public BaseResponse<UserResponseDto> retrieve(@PathVariable Integer id) {
        UserResponseDto response = userService.retrieve(id);
        return BaseResponse.success(response);
    }
}
