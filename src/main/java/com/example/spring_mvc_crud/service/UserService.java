package com.example.spring_mvc_crud.service;


import com.example.spring_mvc_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    void delete(int id);

    User findById(int id);

    User findByUsername(String username);
}
