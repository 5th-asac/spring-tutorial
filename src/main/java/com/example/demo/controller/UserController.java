package com.example.demo.controller;

import com.example.demo.common.CustomException;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponseDto> retrieve(@PathVariable Integer id) {
        try {
            UserResponseDto response = userService.retrieve(id);
            return ResponseEntity.ok(response);
        } catch (CustomException e) {
            if (e.getType().equals("INVALID_REQUEST")) {
                log.warn(e.getMessage());
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            } else if (e.getType().equals("NOT_EXIST")) {
                log.warn(e.getMessage());
                e.printStackTrace();
                return ResponseEntity.notFound().build();
            } else {
                log.error(e.getMessage());
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}
