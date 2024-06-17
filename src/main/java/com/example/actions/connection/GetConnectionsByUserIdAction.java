package com.example.actions.connection;

import com.example.dao.ConnectionDao;
import com.example.dao.ConnectionDaoImpl;
import com.example.models.ConnectionMdl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetConnectionsByUserIdAction extends ActionSupport {
      private static final Logger logger = LoggerFactory.getLogger(GetConnectionsByUserIdAction.class);
      
      private int userId;
      private ArrayList<ConnectionMdl> connections;
      private String errorMessage;
      
      public int getUserId() {
         return userId;
      }
      public void setUserId(int userId) {
         this.userId = userId;
      }
      
      public ArrayList<ConnectionMdl> getConnections() {
         return connections;
      }
      public void setConnections(ArrayList<ConnectionMdl> connections) {
         this.connections = connections;
      }

      public String getErrorMessage() {
         return errorMessage;
      }


      public String execute() {
        try {
            ConnectionDao connectionDao = new ConnectionDaoImpl();
            connections = connectionDao.getConnectionsForUserId(userId);
            if (connections != null /*&& !connections.isEmpty()*/) {
                return SUCCESS;
            } else {
                errorMessage = "No connections found for user";
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("Error finding user by username", e);
            errorMessage = "An error occurred while fetching images";
            return ERROR;
        }
    }
}
