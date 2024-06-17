package com.example.models;

import java.util.Date;

public class Image {
    private int imageId;
    private int userId;
    private String imageReference;
    private String device;
    private String bodypart;
    private String diagnosis;
    private String description;
    private boolean isPrivate;
    private Date createdAt;

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getBodypart() {
        return bodypart;
    }

    public void setBodypart(String bodypart) {
        this.bodypart = bodypart;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // toString method
    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", userId=" + userId +
                ", imageReference='" + imageReference + '\'' +
                ", device='" + device + '\'' +
                ", bodypart='" + bodypart + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", description='" + description + '\'' +
                ", isPrivate=" + isPrivate +
                ", createdAt=" + createdAt +
                '}';
    }
}
