package com.example.demo.repository.user;

import com.example.demo.common.CustomException;
import com.example.demo.common.ExceptionType;
import com.example.demo.repository.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
@RequiredArgsConstructor
public class UserJdbcApiDao {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public User getUser(int userId) throws SQLException {
        Connection connection = null;   // 1
        Statement statement = null;     // 2
        ResultSet resultSet = null;     // 3
        try {
            connection = DriverManager.getConnection(   // 1
                    url, username, password
            );
            statement = connection.createStatement();   // 2
            resultSet = statement.executeQuery(         // 3
                    "SELECT * FROM user WHERE id = " + userId
            );
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
}
