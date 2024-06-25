package com.example.demo.repository.user;

import com.example.demo.controller.dto.UserCreateRequestDto;
import com.example.demo.controller.dto.UserUpdateRequestDto;
import com.example.demo.repository.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJdbcTemplateDao {
    private final JdbcTemplate jdbcTemplate;

    public User getUser(int userId) {
        String getUserQuery = "SELECT * FROM user WHERE id = ?";
        int getUserParams = userId;
        return this.jdbcTemplate.queryForObject(
                getUserQuery,
                (resultSet, rowNum) -> User.mappedBy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("specialty")
                ),
                getUserParams
        );
    }

    public User createUser(UserCreateRequestDto request) {
        // INSERT USER
        String createUserQuery = "INSERT INTO user (name, age, job, specialty) VALUES (?, ?, ?, ?)";
        Object[] createUserParams = new Object[]{
                request.getName(),
                request.getAge(),
                "Unemployed",
                "Empty",
        };
        this.jdbcTemplate.update(
                createUserQuery,
                createUserParams
        );
        // SELECT id
        String lastInsertIdQuery = "SELECT last_insert_id()";
        int createdUserId = this.jdbcTemplate.queryForObject(
                lastInsertIdQuery,
                int.class
        );
        // SELECT USER
        String getUserQuery = "SELECT * FROM user WHERE id = ?";
        int getUserParams = createdUserId;
        return this.jdbcTemplate.queryForObject(
                getUserQuery,
                (resultSet, rowNum) -> User.mappedBy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("specialty")
                ),
                getUserParams
        );
    }

    public User updateUser(int id, UserUpdateRequestDto request) {
        // UPDATE USER
        String updateUserQuery = "UPDATE user SET job = ?, specialty = ? WHERE id = ?";
        Object[] updateUserParams = new Object[]{
                request.getJob(),
                request.getSpecialty(),
        };

        int updatedUserId = this.jdbcTemplate.update(
                updateUserQuery,
                updateUserParams
        );
        // SELECT USER
        String getUserQuery = "SELECT * FROM user WHERE id = ?";
        int getUserParams = updatedUserId;
        return this.jdbcTemplate.queryForObject(
                getUserQuery,
                (rs, rowNum) -> User.mappedBy(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("job"),
                        rs.getString("specialty")
                ),
                getUserParams
        );
    }
}
