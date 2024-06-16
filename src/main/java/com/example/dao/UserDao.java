package com.example.dao;

import java.util.ArrayList;

import com.example.models.User;

public interface UserDao {
    void save(User user);
    User findByUsername(String username);
}
