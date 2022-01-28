package com.santosh.springjdbcsample.service.impl;

import com.santosh.springjdbcsample.builder.DepartmentBuilder;
import com.santosh.springjdbcsample.dto.request.DepartmentRequest;
import com.santosh.springjdbcsample.dto.response.DepartmentResponse;
import com.santosh.springjdbcsample.model.Department;
import com.santosh.springjdbcsample.repository.DepartmentRepository;
import com.santosh.springjdbcsample.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean saveDepartment(DepartmentRequest departmentRequest) {
        Department department = DepartmentBuilder.convertToDepartment(departmentRequest);

        departmentRepository.save(department);

        return true;
    }

    @Override
    public boolean updateDepartment(DepartmentRequest departmentRequest) {
        Department department = DepartmentBuilder.convertToDepartment(departmentRequest);

        departmentRepository.update(department);

        return true;
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return DepartmentBuilder.convertToDepartmentResponse(departments);
    }

    @Override
    public DepartmentResponse getDepartment(int id) {
        Department department = departmentRepository.findById(id);
        return DepartmentBuilder.convertToDepartmentResponse(department);
    }

    @Override
    public boolean deleteDepartment(int id) {
        
        departmentRepository.deleteById(id);

        return true;
    }
}
