package com.santosh.springjdbcsample.repository;

import com.santosh.springjdbcsample.model.Department;

import java.util.List;

public interface DepartmentRepository {

    int count();

    int save(Department department);

    int update(Department department);

    int deleteById(int id);

    List<Department> findAll();

    Department findById(int id);
}
