package com.example.demo.service.user;

import com.example.demo.controller.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponseDto retrieve(int id) {
        if (id == 1) {
            return new UserResponseDto(1, "Aaron", 10, "Web Application Developer", "Backend");
        } else {
            throw new RuntimeException("존재하지 않는 리소스입니다 - id : " + id);
        }
    }
}
