package com.example.dao;

import java.util.ArrayList;

import com.example.models.User;

public interface UserDao {
    void createUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id);
    ArrayList<User> getAllUsers();
}
