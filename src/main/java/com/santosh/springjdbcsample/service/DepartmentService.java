package com.santosh.springjdbcsample.service;

import com.santosh.springjdbcsample.dto.request.DepartmentRequest;
import com.santosh.springjdbcsample.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    boolean saveDepartment(DepartmentRequest createDepartmentRequest);

    boolean updateDepartment(DepartmentRequest createDepartmentRequest);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartment(int id);

    boolean deleteDepartment(int id);
}
