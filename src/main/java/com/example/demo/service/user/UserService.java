package com.example.demo.service.user;

import com.example.demo.common.CustomException;
import com.example.demo.common.ExceptionType;
import com.example.demo.controller.dto.UserCreateRequestDto;
import com.example.demo.controller.dto.UserResponseDto;
import com.example.demo.controller.dto.UserUpdateRequestDto;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.repository.user.UserRepositorySupport;
import com.example.demo.repository.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRepositorySupport userRepositorySupport;

    public List<UserResponseDto> retrieve(String name) {
        List<User> retrieved = userRepositorySupport.findByName(name);
        if (CollectionUtils.isEmpty(retrieved)) {
            new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - name : " + name);
        }
        return retrieved.stream().map(UserResponseDto::of).toList();
    }

    public UserResponseDto retrieve(int id) {
        User retrieved = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - id : " + id));
        return UserResponseDto.of(retrieved);
    }

    public UserResponseDto create(UserCreateRequestDto request) {
        User created = userRepository.save(request.toEntity());
        return UserResponseDto.of(created);
    }

    public UserResponseDto update(int id, UserUpdateRequestDto request) {
        User retrieved = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - id : " + id));
        retrieved.updateJob(request.getJob(), request.getSpecialty());
        User updated = userRepository.save(retrieved);
        return UserResponseDto.of(updated);
    }

    public int delete(int id) {
        userRepository.deleteById(id);
        return id;
    }
}
