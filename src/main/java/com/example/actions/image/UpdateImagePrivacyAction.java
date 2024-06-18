package com.example.actions.image;

import com.example.dao.ImageDao;
import com.example.dao.ImageDaoImpl;
import com.example.models.Image;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UpdateImagePrivacyAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(UpdateImagePrivacyAction.class);

    private int imageId;
    private String successMessage;
    private String errorMessage;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            ImageDao imageDao = new ImageDaoImpl();
            Image image = imageDao.getImageById(imageId);
            if (image != null) {
                boolean newPrivacyStatus = !image.isPrivate();
                image.setIsPrivate(newPrivacyStatus);
                imageDao.updateImage(image);
                successMessage = "Image privacy toggled successfully.";
                out.print("{\"success\":true}");
                return SUCCESS;
            } else {
                errorMessage = "Image not found";
                out.print("{\"success\":false, \"message\":\"" + errorMessage + "\"}");
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error toggling image privacy", e);
            errorMessage = "An error occurred while toggling image privacy";
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"success\":false, \"message\":\"" + errorMessage + "\"}");
            } catch (Exception ex) {
                logger.error("Error writing response", ex);
            }
            return ERROR;
        }
    }
}
