package com.example.demo.repository.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private String specialty;

    public static User create(String name, Integer age) {
        return new User(null, name, age, "Unemployed", "Empty");
    }

    public void updateJob(String job, String specialty) {
        this.job = job;
        this.specialty = specialty;
    }

    public static User mappedBy(int id, String name, Integer age, String job, String specialty) {
        return new User(id, name, age, job, specialty);
    }
}
