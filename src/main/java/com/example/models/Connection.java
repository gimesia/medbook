package com.example.models;

import java.util.Date;

public class Connection {
    private int connectionId;
    private int user1Id;
    private int user2Id;
    private Date createdAt;

    // Default constructor
    public Connection() {
    }

    // Parameterized constructor
    public Connection(int connectionId, int user1Id, int user2Id, Date createdAt) {
        this.connectionId = connectionId;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
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
        return "Connection{" +
                "connectionId=" + connectionId +
                ", user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                ", createdAt=" + createdAt +
                '}';
    }
}
