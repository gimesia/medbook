package com.example.dao;

import com.example.models.Image;
import com.example.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDaoImpl implements ImageDao {

   @Override
   public Image getImageById(int id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getImageById'");
   }

   @Override
   public ArrayList<Image> getImagesForUserId(int userId) {
      ArrayList<Image> images = new ArrayList<>();
      String query = "SELECT * FROM Image WHERE user_id = ?";
      try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
         stmt.setInt(1, userId);
         ResultSet rs = stmt.executeQuery();
         while (rs.next()) {
            Image image = new Image();
            image.imageId = (rs.getInt("image_id"));
            image.userId = (rs.getInt("user_id"));
            image.imageReference = (rs.getString("image_reference"));
            image.device = (rs.getString("device"));
            image.bodypart = (rs.getString("bodypart"));
            image.diagnosis = (rs.getString("diagnosis"));
            image.description = (rs.getString("description"));
            image.isPrivate = (rs.getBoolean("is_private"));
            image.createdAt = (rs.getDate("created_at"));
            images.add(image);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return images;
   }


   @Override
   public ArrayList<Image> getImagesForUserIdList(ArrayList<Integer> userIds) {
      ArrayList<Image> images = new ArrayList<>();
      if (userIds == null || userIds.isEmpty()) {
         return images;
      }
      String query = "SELECT * FROM Image WHERE user_id IN (" +
            userIds.stream().map(String::valueOf).collect(Collectors.joining(",")) +
            ")";
      try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
         ResultSet rs = stmt.executeQuery();
         while (rs.next()) {
            Image image = new Image();
            image.imageId = (rs.getInt("image_id"));
            image.userId = (rs.getInt("user_id"));
            image.imageReference = (rs.getString("image_reference"));
            image.device = (rs.getString("device"));
            image.bodypart = (rs.getString("bodypart"));
            image.diagnosis = (rs.getString("diagnosis"));
            image.description = (rs.getString("description"));
            image.isPrivate = (rs.getBoolean("is_private"));
            image.createdAt = (rs.getDate("created_at"));
            images.add(image);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return images;
   }

   @Override
   public Image toggleImagePublicById(int id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'toggleImagePublicById'");
   }

   @Override
   public void editImage(Image image) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'editImage'");
   }
}