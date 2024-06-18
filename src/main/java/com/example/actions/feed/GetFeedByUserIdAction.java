package com.example.actions.feed;

import com.example.dao.FeedDao;
import com.example.dao.FeedDaoImpl;
import com.example.models.FeedItem;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetFeedByUserIdAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetFeedByUserIdAction.class);
    private final FeedDao feedDao = new FeedDaoImpl();
    private int userId;
    private ArrayList<FeedItem> images;


    private String errorMessage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<FeedItem> getImages() {
        return images;
    }

    public void setImages(ArrayList<FeedItem> images) {
        this.images = images;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String execute() {
        try {
            images = feedDao.getFeedById(userId);
            return SUCCESS;
        
        } catch (Exception e) {
            logger.error("Error finding user by userId", e);
            errorMessage = "An error occurred while fetching connections";
            return ERROR;
        }
    }
}
