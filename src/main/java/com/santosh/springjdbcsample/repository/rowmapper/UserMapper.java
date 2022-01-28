package com.santosh.springjdbcsample.repository.rowmapper;

import com.santosh.springjdbcsample.model.Department;
import com.santosh.springjdbcsample.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setName(rs.getString("name"));
        user.setDepartment(new Department(rs.getInt("department_id")));
        return user;
    }
}
