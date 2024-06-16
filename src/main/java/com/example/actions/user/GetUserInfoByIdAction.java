package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserInfoByIdAction extends ActionSupport {
    private int id;
    private User user;
    private String errorMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            user = userDao.getUserById(id);
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
