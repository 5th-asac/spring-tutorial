package com.example.demo.service.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getExampleUser() {
        return new User("Aaron", 10, "Developer", "Backend");
    }
}
