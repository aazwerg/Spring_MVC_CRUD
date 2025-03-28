package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
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
