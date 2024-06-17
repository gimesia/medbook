package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllUsersAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetAllUsersAction.class);
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
            users = userDao.getAllUsers();
            if (users != null && !users.isEmpty()) {
                logger.info("Successfully fetched all users");
                return SUCCESS;
            } else {
                errorMessage = "No users found";
                logger.warn(errorMessage);
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching users information", e);
            errorMessage = "An error occurred while fetching users information";
            return ERROR;
        }
    }
}
