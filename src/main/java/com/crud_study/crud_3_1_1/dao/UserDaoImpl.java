package com.crud_study.crud_3_1_1.dao;


import com.crud_study.crud_3_1_1.model.User;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(showUser(id));
    }


}
