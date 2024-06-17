package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import com.example.models.ConnectionMdl;
import com.example.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDaoImpl implements ConnectionDao{
   private static final Logger logger = LoggerFactory.getLogger(ConnectionDaoImpl.class);

   @Override
   public ArrayList<ConnectionMdl> getConnectionsForUserId(int id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getConnectionsForUserId'");
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
   
}
