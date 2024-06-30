package com.example.demo.service;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User retrieve(String name) {
        return userRepository.retrieve(name)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다 - name : " + name));
    }
}
