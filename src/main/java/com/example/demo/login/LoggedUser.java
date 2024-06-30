package com.example.demo.login;

import com.example.demo.repository.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggedUser implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private List<SimpleGrantedAuthority> authorities;

    public static LoggedUser of(User entity) {
        return new LoggedUser(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getAge(),
                entity.getRoles().stream().map(SimpleGrantedAuthority::new).toList()
        );
    }
}
