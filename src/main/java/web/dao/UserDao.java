package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String name, String lastName, Byte age, String email, String phone);
    void changeUser(Long id, String name, String lastName, Byte age, String email, String phone);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}
