package com.example.demo.repository.user;

import com.example.demo.repository.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    Optional<User> findById(Integer integer);
    User save(User entity);
    void deleteById(Integer integer);
}
