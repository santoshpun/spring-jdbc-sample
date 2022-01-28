package com.santosh.springjdbcsample.service.impl;

import com.santosh.springjdbcsample.builder.UserBuilder;
import com.santosh.springjdbcsample.dto.request.UserRequest;
import com.santosh.springjdbcsample.dto.response.UserResponse;
import com.santosh.springjdbcsample.model.User;
import com.santosh.springjdbcsample.repository.UserRepository;
import com.santosh.springjdbcsample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(UserRequest userRequest) {
        User user = UserBuilder.convertToUser(userRequest);

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean updateUser(UserRequest userRequest) {
        User user = UserBuilder.convertToUser(userRequest);

        userRepository.update(user);

        return true;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserBuilder.convertToUserResponse(users);
    }

    @Override
    public UserResponse getUser(int id) {
        User user = userRepository.findById(id);
        return UserBuilder.convertToUserResponse(user);
    }

    @Override
    public boolean deleteUser(int id) {

        userRepository.deleteById(id);

        return true;
    }
}
