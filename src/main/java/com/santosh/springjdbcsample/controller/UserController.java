package com.santosh.springjdbcsample.controller;

import com.santosh.springjdbcsample.builder.BaseResponseBuilder;
import com.santosh.springjdbcsample.dto.request.UserRequest;
import com.santosh.springjdbcsample.dto.response.BaseResponse;
import com.santosh.springjdbcsample.dto.response.UserResponse;
import com.santosh.springjdbcsample.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponse> addUser(@RequestBody UserRequest userRequest) {

        userService.addUser(userRequest);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("User added successfully"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> updateUser(@RequestBody UserRequest userRequest) {

        userService.updateUser(userRequest);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("User updated successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        List<UserResponse> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Get User",
            description = "Fetch user details based on provided user id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") int id) {

        UserResponse user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "This is to delete the user in the database")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") int id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("User deleted successfully"), HttpStatus.OK);
    }
}
