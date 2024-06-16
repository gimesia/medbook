package com.example.actions.image;

import com.example.dao.ImageDao;
import com.example.dao.ImageDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.models.Image;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ImagesForUserIdListAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private ArrayList<Integer> userIds;
    private ArrayList<Image> images;
    private String errorMessage;

    public ArrayList<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(ArrayList<Integer> userIds) {
        this.userIds = userIds;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String execute() {
        try {
            ImageDao imageDao = new ImageDaoImpl();
            images = imageDao.getImagesForUserIdList(userIds);
            if (images != null && !images.isEmpty()) {
                return SUCCESS;
            } else {
                errorMessage = "No images found for user list";
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error finding user by username", e);
            errorMessage = "An error occurred while fetching images";
            return ERROR;
        }
    }
}
