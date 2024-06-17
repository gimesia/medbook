package com.example.actions.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dao.ImageDao;
import com.example.dao.ImageDaoImpl;
import com.example.models.Image;
import com.opensymphony.xwork2.ActionSupport;

public class GetImageByIdAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(GetImageByIdAction.class);
    
    private int imageId;
    private Image image;
    private String errorMessage;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Image getImage() {
        return image;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String execute() {
        try {
            ImageDao imageDao = new ImageDaoImpl();
            image = imageDao.getImageById(imageId);
            if (image != null) {
                return SUCCESS;
            } else {
                errorMessage = "Image not found";
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error finding user by username", e);
            errorMessage = "An error occurred while fetching image information";
            return ERROR;
        }
    }
}
