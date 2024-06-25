package com.example.demo.service.user;

import com.example.demo.controller.dto.UserCreateRequestDto;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.repository.user.UserJdbcTemplateDao;
import com.example.demo.repository.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJdbcTemplateDao userRepository;

    public UserResponseDto retrieve(int id) {
        User retrieved = userRepository.getUser(id);
        return UserResponseDto.of(retrieved);
    }

    public UserResponseDto create(UserCreateRequestDto request) {
        UserResponseDto created = new UserResponseDto(1, request.getName(), request.getAge(), "Unemployed", "Empty");
        return created;
    }
}
