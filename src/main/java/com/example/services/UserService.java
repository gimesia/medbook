package com.example.services;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}