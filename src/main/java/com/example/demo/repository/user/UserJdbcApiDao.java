package com.example.demo.repository.user;

import com.example.demo.common.CustomException;
import com.example.demo.common.ExceptionType;
import com.example.demo.controller.dto.UserCreateRequestDto;
import com.example.demo.repository.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class UserJdbcApiDao {
    private final DataSource dataSource;

    public User getUser(int userId) throws SQLException {
        Connection connection = null;           // 1
        PreparedStatement statement = null;     // 2
        ResultSet resultSet = null;             // 3
        try {
            connection = dataSource.getConnection();    // 1
            statement = connection.prepareStatement(    // 2
                    "SELECT * FROM user WHERE id = ?"
            );
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();       // 3
            if (resultSet.next()) {
                return User.mappedBy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("specialty")
                );
            }
            throw new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - id : " + userId);
        } catch (SQLException e) {
            throw new CustomException(ExceptionType.DATABASE_ERROR, e);
        } finally {
            // 자원반납
            if (resultSet != null) resultSet.close();   // 1
            if (statement != null) statement.close();   // 2
            if (connection != null) connection.close(); // 3
        }
    }

    public User createUser(UserCreateRequestDto request) throws SQLException {
        Connection connection = null;           // 1
        PreparedStatement statement = null;     // 2
        ResultSet resultSet = null;             // 3
        try {
            // (A) INSERT USER
            connection = dataSource.getConnection();    // 1 (A + B + C)
            statement = connection.prepareStatement(    // 2 (A)
                    "INSERT INTO user (name, age, job, specialty) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, request.getName());
            statement.setInt(2, request.getAge());
            statement.setString(3, "Unemployed");
            statement.setString(4, "Empty");
            int executedNumberOfQuery = statement.executeUpdate();
            // (B) SELECT id
            statement = connection.prepareStatement(    // 2 (B)
                    "SELECT last_insert_id()"
            );
            resultSet = statement.executeQuery();       // 3 (B)
            Integer createdUserId = null;
            if (resultSet.next()) {
                createdUserId = resultSet.getInt("id");
            }
            // (C) SELECT USER
            statement = connection.prepareStatement(    // 2 (C)
                    "SELECT * FROM user WHERE id = ?"
            );
            statement.setInt(1, createdUserId);
            resultSet = statement.executeQuery();       // 3 (C)
            if (resultSet.next()) {
                return User.mappedBy(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("specialty")
                );
            }
            throw new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - id : " + createdUserId);
        } catch (SQLException e) {
            throw new CustomException(ExceptionType.DATABASE_ERROR, e);
        } finally {
            // 자원반납
            if (resultSet != null) resultSet.close();   // 1
            if (statement != null) statement.close();   // 2
            if (connection != null) connection.close(); // 3
        }
    }
}
