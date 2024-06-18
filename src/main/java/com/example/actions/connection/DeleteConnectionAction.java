package com.example.actions.connection;

import com.example.dao.ConnectionDao;
import com.example.dao.ConnectionDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class DeleteConnectionAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(DeleteConnectionAction.class);

    private int user1Id;
    private int user2Id;

    @Override
    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            ConnectionDao connectionDao = new ConnectionDaoImpl();
            connectionDao.deleteConnection(user1Id, user2Id);
            out.print("{\"success\":true}");
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error deleting connection", e);
            try (PrintWriter out = response.getWriter()) {
                out.print("{\"success\":false}");
            } catch (Exception ex) {
                logger.error("Error writing response", ex);
            }
            return ERROR;
        }
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }
}
