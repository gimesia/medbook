package com.example.actions.image;

import com.example.dao.ImageDao;
import com.example.dao.ImageDaoImpl;
import com.example.models.Image;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImagesByUserIdAction extends ActionSupport {
   private static final Logger logger = LoggerFactory.getLogger(ImagesByUserIdAction.class);
  
    private int userId;
    private List<Image> images;
    private String errorMessage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
            images = imageDao.getImagesForUserId(userId);
            if (images != null && !images.isEmpty()) {
                return SUCCESS;
            } else {
                errorMessage = "No images found for user";
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "An error occurred while fetching images";
            return ERROR;
        }
    }
}
