package com.santosh.springjdbcsample.service;

import com.santosh.springjdbcsample.dto.request.UserRequest;
import com.santosh.springjdbcsample.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    boolean addUser(UserRequest userRequest);

    boolean updateUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUser(int id);

    boolean deleteUser(int id);
}
