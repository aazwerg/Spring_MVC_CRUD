package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void saveUser(String name, String lastName, Byte age, String email, String phone) {
        em.persist(new User(name, lastName, age, email, phone));
    }

    @Override
    @Transactional
    public void changeUser(Long id, String name, String lastName, Byte age, String email, String phone) {
        em.merge(new User(id, name, lastName, age, email, phone));
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
