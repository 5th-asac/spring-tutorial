package com.example.demo.repository.user;

import com.example.demo.repository.user.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName(String name);
}