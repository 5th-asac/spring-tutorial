package com.example.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final PasswordEncoder passwordEncoder;

    public Optional<User> retrieve(String name) {
        List<User> database = List.of(
            new User(1, "aaron", passwordEncoder.encode("123"), "Aaron", 10, "aaron@gmail.com", List.of("ROLE_USER", "ROLE_ADMIN")),
            new User(2, "baron", passwordEncoder.encode("123"), "Baron", 20, "baron@gmail.com", List.of("ROLE_USER"))
        );
        Optional<User> found = database.stream()
                .filter(item -> item.getName().toLowerCase().equals(name.toLowerCase()))
                .findAny();
        return found;
    }
}
