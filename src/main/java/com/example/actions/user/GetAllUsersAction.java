package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GetAllUsersAction extends ActionSupport {
    private List<User> users;
    private String errorMessage;

    public List<User> getUsers() {
        return users;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String execute() {
        try {
            UserDao userDao = new UserDaoImpl();
            users = userDao.getUsers();
            if (users != null && !users.isEmpty()) {
                return SUCCESS;
            } else {
                errorMessage = "No users found";
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "An error occurred while fetching users information";
            return ERROR;
        }
    }
}
