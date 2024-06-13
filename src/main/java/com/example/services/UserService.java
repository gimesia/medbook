package com.example.services;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public void save(User user) {
        userDao.save(user);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}