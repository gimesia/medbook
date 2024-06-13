package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

    private String username;
    private String email;
    private String role;

    public AccountAction() {
        // Hardcoded account details for now
        username = "Aron";
        email = "aron@example.com";
        role = "MD";
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
