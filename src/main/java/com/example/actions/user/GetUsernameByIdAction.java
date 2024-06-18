package com.example.actions.user;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsernameByIdAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetUsernameByIdAction.class);
    private int userId;
    
    private String username;
    private String errorMessage;
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String execute() {
        try {
            UserDao userDao = new UserDaoImpl();
            User user = userDao.getUserById(userId);
            if (user != null) {
                username = user.getUsername();
                logger.info("Successfully fetched user with ID: {}", userId);
                return SUCCESS;
            } else {
                errorMessage = "User not found";
                logger.warn(errorMessage + " with ID: {}", userId);
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching user information with ID: {}", userId, e);
            errorMessage = "An error occurred while fetching user information";
            return ERROR;
        }
    }
}
