package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.example.models.ConnectionMdl;
import com.example.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDaoImpl implements ConnectionDao{
   private static final Logger logger = LoggerFactory.getLogger(ConnectionDaoImpl.class);

    @Override
    public ArrayList<ConnectionMdl> getConnectionsByUserId(int userId) {
        String query = "SELECT * FROM Connection WHERE user1_id = ? OR user2_id = ?";
        ArrayList<ConnectionMdl> connections = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ConnectionMdl connection = new ConnectionMdl();
                connection.setConnectionId(rs.getInt("connection_id"));
                connection.setUser1Id(rs.getInt("user1_id"));
                connection.setUser2Id(rs.getInt("user2_id"));
                connection.setCreatedAt(rs.getTimestamp("created_at"));
                connections.add(connection);
            }
        } catch (SQLException e) {
            logger.error("Error fetching connections by user ID", e);
        }
        return connections;
    }


    @Override
    public void addConnection(int user1Id, int user2Id){
        String sql = "INSERT INTO medbook_db.Connection (user1_id, user2_id, created_at) VALUES (?, ?, NOW())";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user1Id);
            stmt.setInt(2, user2Id);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            logger.error("Error finding user by username", e);
        }
        return;
    }

    @Override
    public void deleteConnection(int user1Id, int user2Id) {
        String sql = "DELETE FROM medbook_db.Connection WHERE (user1_id = ? AND user2_id = ?) OR (user1_id = ? AND user2_id = ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user1Id);
            stmt.setInt(2, user2Id);
            stmt.setInt(3, user2Id);
            stmt.setInt(4, user1Id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting connection", e);
        }
    }
   
  
    @Override
    public Set<Integer> getConnectedUserIdsByUserId(int userId) {
        String query = "SELECT user1_id, user2_id FROM Connection WHERE user1_id = ? OR user2_id = ?";
        Set<Integer> connectedUserIds = new HashSet<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int user1Id = rs.getInt("user1_id");
                int user2Id = rs.getInt("user2_id");
                if (user1Id != userId) {
                    connectedUserIds.add(user1Id);
                }
                if (user2Id != userId) {
                    connectedUserIds.add(user2Id);
                }
            }
        } catch (SQLException e) {
            logger.error("Error fetching connected user IDs by user ID", e);
        }
        return connectedUserIds;
    }
}
