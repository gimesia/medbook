package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserInfoByIdAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetUserInfoByIdAction.class);
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
                logger.info("Successfully fetched user with ID: {}", id);
                return SUCCESS;
            } else {
                errorMessage = "User not found";
                logger.warn(errorMessage + " with ID: {}", id);
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching user information with ID: {}", id, e);
            errorMessage = "An error occurred while fetching user information";
            return ERROR;
        }
    }
}
