package com.santosh.springjdbcsample.builder;

import com.santosh.springjdbcsample.dto.request.DepartmentRequest;
import com.santosh.springjdbcsample.dto.response.DepartmentResponse;
import com.santosh.springjdbcsample.model.Department;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DepartmentBuilder {

    public static Department convertToDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setId(departmentRequest.getId());
        department.setName(departmentRequest.getName());
        return department;
    }

    public static DepartmentResponse convertToDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        return departmentResponse;
    }

    public static List<DepartmentResponse> convertToDepartmentResponse(List<Department> departments) {
        List<DepartmentResponse> departmentResponses = new ArrayList<>();

        for (Department department : departments) {
            departmentResponses.add(convertToDepartmentResponse(department));
        }
        return departmentResponses;
    }
}
