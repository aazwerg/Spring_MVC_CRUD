package com.example.spring_mvc_crud.service;

import com.example.spring_mvc_crud.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
