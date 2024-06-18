package com.example.demo;

import com.example.demo.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceBeanConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
