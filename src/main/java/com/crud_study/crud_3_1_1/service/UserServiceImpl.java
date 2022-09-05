package com.crud_study.crud_3_1_1.service;

import com.crud_study.crud_3_1_1.dao.UserDao;
import com.crud_study.crud_3_1_1.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    @Transactional
    public void addUser (User user){
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User showUser(int id) {
        return userDao.showUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id,user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
