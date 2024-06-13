package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionsAction extends ActionSupport {

    private List<Map<String, Object>> connections;

    public ConnectionsAction() {
        connections = new ArrayList<>();
        Map<String, Object> connection1 = new HashMap<>();
        connection1.put("username", "USERNAME1");
        connection1.put("role", "MD");
        connection1.put("connected", true);

        Map<String, Object> connection2 = new HashMap<>();
        connection2.put("username", "USERNAME2");
        connection2.put("role", "patient");
        connection2.put("connected", true);

        // Add more connections as needed
        connections.add(connection1);
        connections.add(connection2);
    }

    public List<Map<String, Object>> getConnections() {
        return connections;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
