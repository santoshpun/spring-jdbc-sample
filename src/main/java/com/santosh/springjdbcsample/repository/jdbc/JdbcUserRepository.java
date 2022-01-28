package com.santosh.springjdbcsample.repository.jdbc;

import com.santosh.springjdbcsample.model.User;
import com.santosh.springjdbcsample.repository.UserRepository;
import com.santosh.springjdbcsample.repository.rowmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "INSERT INTO users(username, password, name, department_id, added_date) VALUES(?,?,?,?,?)",
                user.getUsername(), user.getPassword(), user.getName(), user.getDepartment().getId(), new Date()
        );
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "UPDATE users SET name = ?, department_id = ? WHERE id = ?",
                user.getName(), user.getDepartment().getId(), user.getId()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "DELETE users WHERE id = ?",
                id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT id, username, name, department_id FROM users",
                new UserMapper()
        );
    }

    @Override
    public User findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, username, name, department_id FROM users WHERE id = ?",
                new UserMapper(),
                id
        );
    }
}
