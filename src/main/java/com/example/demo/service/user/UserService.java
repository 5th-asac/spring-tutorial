package com.example.demo.service.user;

public class UserService {

    public User getExampleUser(Integer id) {
        if (id.equals(2)) {
            return new User("Baron", 20, "Designer", "Platform");
        } else {
            return new User("Aaron", 10, "Developer", "Backend");
        }
    }
}
