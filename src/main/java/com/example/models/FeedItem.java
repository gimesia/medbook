package com.example.models;

import java.util.Date;

public class FeedItem extends Image {
   private String username;

   // Constructor
   public FeedItem(String username,int imageId, int userId, String imageReference, String device, String bodypart, String diagnosis, String description, boolean isPrivate, Date createdAt) {
       super(
         imageId,
         userId,
         imageReference,
         device,
         bodypart,
         diagnosis,
         description,
         isPrivate,
         createdAt
      );
       this.username = username;
   }

   // Getter for username
   public String getUsername() {
       return username;
   }

   // Setter for username
   public void setUsername(String username) {
       this.username = username;
   }

   // Optionally override methods from Image if needed
   @Override
   public String toString() {
       return super.toString() + ", username='" + username + "'";
   }
}
