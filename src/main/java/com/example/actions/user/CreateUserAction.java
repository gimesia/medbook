package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class CreateUserAction extends ActionSupport implements SessionAware {
    private static final Logger logger = LoggerFactory.getLogger(CreateUserAction.class);

    private String username;
    private String password;
    private String role;
    private Map<String, Object> session;

    private UserDao userDao;

    public CreateUserAction() {
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
            session.put("user", user);
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error during registration", e);
            return ERROR;
        }
    }
}
