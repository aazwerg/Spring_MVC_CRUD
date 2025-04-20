package com.example.spring_mvc_crud.service;

import com.example.spring_mvc_crud.dao.UserDao;
import com.example.spring_mvc_crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        dao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
