package com.example.demo.controller;

import com.example.demo.controller.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("")
    public ResponseEntity<UserResponseDto> retrieve() {
        return ResponseEntity.ok(
                new UserResponseDto(1, "Aaron", 10, "Web Application Developer", "Backend")
        );
    }
}
