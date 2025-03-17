package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao dao;

    public UserServiceImpl(UserDao dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName, Byte age, String email, String phone) {
        dao.saveUser(name, lastName, age, email, phone);
    }

    @Override
    @Transactional
    public void changeUser(Long id, String name, String lastName, Byte age, String email, String phone) {
        dao.changeUser(id, name, lastName, age, email, phone);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        dao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
