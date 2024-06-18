package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GetUserInfoByUsernameAction extends ActionSupport implements SessionAware {
    private static final Logger logger = LoggerFactory.getLogger(GetUserInfoByUsernameAction.class);

    private int userId;
    private String username;
    private String password;
    private String role;
    private UserDao userDao;
    private Map<String, Object> session;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public GetUserInfoByUsernameAction() {
        userDao = new UserDaoImpl();
    }

    // Getter and setter methods for username, password, and role
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String register() {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPasswordHash(password); // Assume hashing is done elsewhere
            user.setRole(role);

            userDao.createUser(user);
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error during registration", e);
            return ERROR;
        }
    }

    public String login() {
        try {
            User user = userDao.getUserByUsername(username);
            if (user != null && user.getPasswordHash().equals(password)) { // Assume password is hashed
                session.put("user", user);
                userId = user.getUserId();
                return SUCCESS;
            } else {
                addActionError("Invalid username or password.");
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error during login", e);
            addActionError("An error occurred during login.");
            return ERROR;
        }
    }
}