package com.example.actions.connection;

import com.example.dao.ConnectionDao;
import com.example.dao.ConnectionDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AddConnectionAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(AddConnectionAction.class);

    private int user1Id;
    private int user2Id;
    private String successMessage;
    private String errorMessage;

    public String execute() {
        try {
            ConnectionDao connectionDao = new ConnectionDaoImpl();
            connectionDao.addConnection(user1Id, user2Id);
            successMessage = "Connection added successfully.";
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error adding connection", e);
            errorMessage = "Failed to add connection.";
            return ERROR;
        }
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}