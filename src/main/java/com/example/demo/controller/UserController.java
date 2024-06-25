package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.common.CustomException;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
            return BaseResponse.of(true, 200, null, response);
        } catch (CustomException e) {
            HttpStatus status = e.getType().getStatus();
            String message = e.getType().getMessage();
            log.warn(e.getMessage());
            e.printStackTrace();
            return BaseResponse.of(false, status.value(), message, null);
        } catch (Exception e) {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error(e.getMessage());
            e.printStackTrace();
            return BaseResponse.of(false, status.value(), status.getReasonPhrase(), null);
        }
    }
}
