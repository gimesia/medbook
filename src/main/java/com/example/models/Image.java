package com.example.models;

import java.util.Date;

public class Image {
    public int imageId;
    public int userId;
    public String imageReference;
    public String device;
    public String bodypart;
    public String diagnosis;
    public String description;
    public boolean isPrivate;
    public Date createdAt;

    // Default constructor
    public Image() {
    }

    // Parameterized constructor
    public Image(int imageId, int userId, String imageReference, String device, String bodypart, String diagnosis, String description, boolean isPrivate, Date createdAt) {
        this.imageId = imageId;
        this.userId = userId;
        this.imageReference = imageReference;
        this.device = device;
        this.bodypart = bodypart;
        this.diagnosis = diagnosis;
        this.description = description;
        this.isPrivate = isPrivate;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }
}
