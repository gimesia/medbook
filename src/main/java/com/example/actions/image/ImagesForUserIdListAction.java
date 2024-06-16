package com.example.actions.image;

import com.example.dao.ImageDao;
import com.example.dao.ImageDaoImpl;
import com.example.models.Image;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ImagesForUserIdListAction extends ActionSupport {
    private List<Integer> userIds;
    private List<Image> images;
    private String errorMessage;

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public List<Image> getImages() {
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
            e.printStackTrace();
            errorMessage = "An error occurred while fetching images";
            return ERROR;
        }
    }
}
