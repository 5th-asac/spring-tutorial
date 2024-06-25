package com.example.demo.service.user;

import com.example.demo.controller.dto.UserCreateRequestDto;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.controller.dto.UserUpdateRequestDto;
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
        User created = userRepository.createUser(request);
        return UserResponseDto.of(created);
    }

    public UserResponseDto update(int id, UserUpdateRequestDto request) {
        User created = userRepository.updateUser(id, request);
        return UserResponseDto.of(created);
    }

    public int delete(int id) {
        int deletedUserId = userRepository.deleteUser(id);
        return deletedUserId;
    }
}
