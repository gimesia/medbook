package com.example.actions;

import com.example.models.User;
import com.example.services.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.codec.digest.DigestUtils;

public class UserAction extends ActionSupport {
    private UserService userService = new UserService();
    private String username;
    private String password;

    public String register() {
        if (username == null || password == null) {
            addActionError("Username and Password are required.");
            return ERROR;
        }

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(DigestUtils.sha256Hex(password));
        user.setRole("user");
        userService.save(user);
        return SUCCESS;
    }

    public String login() {
        if (username == null || password == null) {
            addActionError("Username and Password are required.");
            return ERROR;
        }

        User user = userService.findByUsername(username);
        if (user != null && user.getPasswordHash().equals(DigestUtils.sha256Hex(password))) {
            return SUCCESS;
        } else {
            addActionError("Invalid Username or Password.");
            return ERROR;
        }
    }

    // Getters and setters for username and password
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
}
