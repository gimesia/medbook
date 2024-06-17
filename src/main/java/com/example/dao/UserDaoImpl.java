package com.example.dao;

import com.example.models.User;
import com.example.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void createUser(User user) {
        String query = "INSERT INTO User (username, password_hash, created_at, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis())); // Set created_at
            stmt.setString(4, user.getRole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error saving user", e);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM User WHERE username = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            logger.error("Error finding user by username", e);
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        String query = "SELECT * FROM User WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            logger.error("Error finding user by username", e);
            return new User(1, "ERROR BUT TEST", "pwd", new Date(), "MD");
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Error finding user by username", e);
        }
        return users;
    }

}
