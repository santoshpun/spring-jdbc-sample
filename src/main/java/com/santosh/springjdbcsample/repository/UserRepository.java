package com.santosh.springjdbcsample.repository;

import com.santosh.springjdbcsample.model.User;

import java.util.List;

public interface UserRepository {

    int count();

    int save(User user);

    int update(User user);

    int deleteById(int id);

    List<User> findAll();

    User findById(int id);
}
