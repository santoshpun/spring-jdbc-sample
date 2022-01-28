package com.santosh.springjdbcsample.controller;

import com.santosh.springjdbcsample.builder.BaseResponseBuilder;
import com.santosh.springjdbcsample.dto.request.DepartmentRequest;
import com.santosh.springjdbcsample.dto.response.BaseResponse;
import com.santosh.springjdbcsample.dto.response.DepartmentResponse;
import com.santosh.springjdbcsample.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<BaseResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest) {

        departmentService.saveDepartment(departmentRequest);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("Department created successfully"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> updateDepartment(@RequestBody DepartmentRequest departmentRequest) {

        departmentService.updateDepartment(departmentRequest);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("Department updated successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {

        List<DepartmentResponse> departments = departmentService.getAllDepartments();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @Operation(summary = "Get Department",
            description = "Fetch department details based on provided department id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable("id") int id) {

        DepartmentResponse department = departmentService.getDepartment(id);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Operation(summary = "This is to delete the department in the database")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteDepartment(@PathVariable("id") int id) {

        departmentService.deleteDepartment(id);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("Department deleted successfully"), HttpStatus.OK);
    }
}
