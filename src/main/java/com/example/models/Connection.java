package com.example.models;

import java.util.Date;

public class Connection{
    private int connectionId;
    private int userId;
    private final Date createdAt;

    // Default constructor
    public Connection() {
        this.createdAt = new Date();
    }

    // Parameterized constructor
    public Connection(int connectionId, int userId, Date createdAt) {
        this.connectionId = connectionId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Override toString method for better logging and debugging
    @Override
    public String toString() {
        return "Student{" +
                "connectionId=" + connectionId +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                '}';
    }
}