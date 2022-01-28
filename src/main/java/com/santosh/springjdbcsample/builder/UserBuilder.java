package com.santosh.springjdbcsample.builder;

import com.santosh.springjdbcsample.dto.request.UserRequest;
import com.santosh.springjdbcsample.dto.response.UserResponse;
import com.santosh.springjdbcsample.model.Department;
import com.santosh.springjdbcsample.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserBuilder {

    public static User convertToUser(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setDepartment(new Department(userRequest.getDepartmentId()));
        return user;
    }

    public static UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());
        userResponse.setDepartmentId(user.getDepartment().getId());
        return userResponse;
    }

    public static List<UserResponse> convertToUserResponse(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(convertToUserResponse(user));
        }
        return userResponses;
    }
}
