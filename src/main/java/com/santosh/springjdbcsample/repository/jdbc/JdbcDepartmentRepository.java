package com.santosh.springjdbcsample.repository.jdbc;

import com.santosh.springjdbcsample.model.Department;
import com.santosh.springjdbcsample.repository.DepartmentRepository;
import com.santosh.springjdbcsample.repository.rowmapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcDepartmentRepository implements DepartmentRepository {
    @Autowired
    @Qualifier("slave")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM department", Integer.class);
    }

    @Override
    public int save(Department department) {
        return jdbcTemplate.update(
                "INSERT INTO department(name) VALUES(?)",
                department.getName()
        );
    }

    @Override
    public int update(Department department) {
        return jdbcTemplate.update(
                "UPDATE department SET name = ? WHERE id = ?",
                department.getName(), department.getId()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "DELETE department WHERE id = ?",
                id);
    }

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query("SELECT id, name FROM department",
                new DepartmentMapper()
        );
    }

    @Override
    public Department findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name FROM department WHERE id = ?",
                new DepartmentMapper(),
                id
        );
    }
}
