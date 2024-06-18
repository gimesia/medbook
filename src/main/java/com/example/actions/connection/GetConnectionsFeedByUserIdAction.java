package com.example.actions.connection;

import com.example.dao.ConnectionDao;
import com.example.dao.ConnectionDaoImpl;
import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.models.ConnectionFeedItem;
import com.example.models.ConnectionMdl;
import com.example.models.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetConnectionsFeedByUserIdAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetConnectionsFeedByUserIdAction.class);
    private int userId;
    private ArrayList<ConnectionFeedItem> connectionFeedItems;
    private String errorMessage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<ConnectionFeedItem> getConnectionFeedItems() {
        return connectionFeedItems;
    }

    public void setConnectionFeedItems(ArrayList<ConnectionFeedItem> connectionFeedItems) {
        this.connectionFeedItems = connectionFeedItems;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String execute() {
        connectionFeedItems = new ArrayList<>();
        try {
            UserDao userDao = new UserDaoImpl();
            ConnectionDao connectionDao = new ConnectionDaoImpl();
            ArrayList<User> allUsers = userDao.getAllUsers();
            ArrayList<ConnectionMdl> connections = connectionDao.getConnectionsByUserId(userId);

            if (allUsers != null && !allUsers.isEmpty()) {
                if (connections != null) {
                    for (User user : allUsers) {
                        if (user.getUserId() == userId) {
                            continue; // Skip the user itself
                        }

                        ConnectionFeedItem connectionFeedItem = new ConnectionFeedItem();
                        connectionFeedItem.setRole(user.getRole());
                        connectionFeedItem.setUsername(user.getUsername());
                        connectionFeedItem.setIsConnected(0);
                        connectionFeedItem.setUserId(user.getUserId());

                        for (ConnectionMdl connectionMdl : connections) {
                            if ((connectionMdl.getUser1Id() == userId && connectionMdl.getUser2Id() == user.getUserId()) ||
                                (connectionMdl.getUser1Id() == user.getUserId() && connectionMdl.getUser2Id() == userId)) {
                                connectionFeedItem.setIsConnected(1);
                                break;
                            }
                        }

                        connectionFeedItems.add(connectionFeedItem);
                    }
                }
                return SUCCESS;
            } else {
                errorMessage = "No connections found for user";
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error finding user by userId", e);
            errorMessage = "An error occurred while fetching connections";
            return ERROR;
        }
    }
}
