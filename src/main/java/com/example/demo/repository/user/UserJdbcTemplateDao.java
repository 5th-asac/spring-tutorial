package com.example.demo.repository.user;

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
}
