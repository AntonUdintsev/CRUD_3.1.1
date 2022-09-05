package com.crud_study.crud_3_1_1.service;



import com.crud_study.crud_3_1_1.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void addUser (User user);
    public User showUser (int id);
    public void updateUser(int id,User user);
    public void deleteUser (int id);

}
