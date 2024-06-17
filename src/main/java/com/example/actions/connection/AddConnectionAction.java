package com.example.actions.connection;

import com.example.actions.image.ImagesByUserIdAction;
import com.example.dao.ConnectionDao;
import com.example.dao.ConnectionDaoImpl;
import com.example.models.ConnectionMdl;
import com.opensymphony.xwork2.ActionSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddConnectionAction extends ActionSupport {
   private static final Logger logger = LoggerFactory.getLogger(AddConnectionAction.class);

    private int user1_id;
    private int user2_id;
    private String errorMessage;

    public int getUser2_id() {
        return user2_id;
    }
    public void setUser2_id(int user2_id) {
        this.user2_id = user2_id;
    }
    public int getUser1_id() {
        return user1_id;
    }
    public void setUser1_id(int user1_id) {
        this.user1_id = user1_id;
    }
    
       public String execute() {
        try {
            ConnectionDao connectionDao = new ConnectionDaoImpl();
            connectionDao.addConnection(user1_id, user2_id);
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error creating connection", e);
            errorMessage = "An error occurred while fetching image information";
            return ERROR;
        }
    }
}