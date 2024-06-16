package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserInfoByUsernameAction extends ActionSupport {
    private String username;
    private User user;
    private String errorMessage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String execute() {
        try {
            UserDao userDao = new UserDaoImpl();
            user = userDao.getUserByUsername(username);
            if (user != null) {
                return SUCCESS;
            } else {
                errorMessage = "User not found";
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "An error occurred while fetching user information";
            return ERROR;
        }
    }
}
