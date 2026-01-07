package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    int save(User user);

    int update(User user);

    int deleteById(Long id);
}
