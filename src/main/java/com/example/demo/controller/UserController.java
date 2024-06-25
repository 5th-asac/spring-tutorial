package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.common.CustomException;
import com.example.demo.common.ExceptionType;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public BaseResponse<UserResponseDto> retrieve(@PathVariable Integer id) {
        try {
            UserResponseDto response = userService.retrieve(id);
            return BaseResponse.success(response);
        } catch (CustomException e) {
            log.warn(e.getMessage());
            e.printStackTrace();
            return BaseResponse.failure(e.getType());
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return BaseResponse.failure(ExceptionType.INTERNAL_SERVER_ERROR);
        }
    }
}
