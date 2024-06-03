package com.example.dao;

import com.example.models.MedicalImage;
import com.example.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalImageDaoImpl implements MedicalImageDao {

    @Override
    public List<MedicalImage> findAll() {
        List<MedicalImage> images = new ArrayList<>();
        String query = "SELECT * FROM medical_images";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                MedicalImage image = new MedicalImage();
                image.setId(rs.getInt("id"));
                image.setName(rs.getString("name"));
                image.setType(rs.getString("type"));
                image.setUrl(rs.getString("url"));
                image.setDescription(rs.getString("description"));
                images.add(image);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    public MedicalImage findById(int id) {
        MedicalImage image = null;
        String query = "SELECT * FROM medical_images WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    image = new MedicalImage();
                    image.setId(rs.getInt("id"));
                    image.setName(rs.getString("name"));
                    image.setType(rs.getString("type"));
                    image.setUrl(rs.getString("url"));
                    image.setDescription(rs.getString("description"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void save(MedicalImage image) {
        String query = "INSERT INTO medical_images (name, type, url, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, image.getName());
            pstmt.setString(2, image.getType());
            pstmt.setString(3, image.getUrl());
            pstmt.setString(4, image.getDescription());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MedicalImage image) {
        String query = "UPDATE medical_images SET name = ?, type = ?, url = ?, description = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, image.getName());
            pstmt.setString(2, image.getType());
            pstmt.setString(3, image.getUrl());
            pstmt.setString(4, image.getDescription());
            pstmt.setInt(5, image.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM medical_images WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
