package com.example.dao;

import com.example.models.Image;
import com.example.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ImageDaoImpl implements ImageDao {
    private static final Logger logger = LoggerFactory.getLogger(ImageDaoImpl.class);

    @Override
    public Image getImageById(int imageId) {
        String query = "SELECT * FROM Image WHERE image_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, imageId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Image image = new Image();
                image.setImageId(rs.getInt("image_id"));
                image.setUserId(rs.getInt("user_id"));
                image.setImageReference(rs.getString("image_reference"));
                image.setDevice(rs.getString("device"));
                image.setBodypart(rs.getString("bodypart"));
                image.setDiagnosis(rs.getString("diagnosis"));
                image.setDescription(rs.getString("description"));
                image.setIsPrivate(rs.getBoolean("is_private"));
                image.setCreatedAt(rs.getDate("created_at"));
                return image;
            }
        } catch (SQLException e) {
            logger.error("Error fetching image by ID", e);
        }
        return null;
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
                image.setImageId(rs.getInt("image_id"));
                image.setUserId(rs.getInt("user_id"));
                image.setImageReference(rs.getString("image_reference"));
                image.setDevice(rs.getString("device"));
                image.setBodypart(rs.getString("bodypart"));
                image.setDiagnosis(rs.getString("diagnosis"));
                image.setDescription(rs.getString("description"));
                image.setIsPrivate(rs.getBoolean("is_private"));
                image.setCreatedAt(rs.getDate("created_at"));
                images.add(image);
            }
        } catch (SQLException e) {
            logger.error("Error fetching images for user ID", e);
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
                image.setImageId(rs.getInt("image_id"));
                image.setUserId(rs.getInt("user_id"));
                image.setImageReference(rs.getString("image_reference"));
                image.setDevice(rs.getString("device"));
                image.setBodypart(rs.getString("bodypart"));
                image.setDiagnosis(rs.getString("diagnosis"));
                image.setDescription(rs.getString("description"));
                image.setIsPrivate(rs.getBoolean("is_private"));
                image.setCreatedAt(rs.getDate("created_at"));
                images.add(image);
            }
        } catch (SQLException e) {
            logger.error("Error fetching images for user ID list", e);
        }
        return images;
    }

    @Override
    public void updateImage(Image image) {
        String query = "UPDATE Image SET is_private = ? WHERE image_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, image.isPrivate());
            stmt.setInt(2, image.getImageId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating image", e);
        }
    }

    @Override
    public void editImage(Image image) {
        throw new UnsupportedOperationException("Unimplemented method 'editImage'");
    }
}
