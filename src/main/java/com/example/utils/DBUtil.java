package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String dbUrl;
    private static String dbUsername;
    private static String dbPassword;
    private static String dbDriver;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            dbUrl = properties.getProperty("jdbc.url");
            dbUsername = properties.getProperty("jdbc.username");
            dbPassword = properties.getProperty("jdbc.password");
            dbDriver = properties.getProperty("jdbc.driverClassName");

            System.out.println("Loaded properties:");
            System.out.println("URL: " + dbUrl);
            System.out.println("Username: " + dbUsername);
            System.out.println("Password: " + dbPassword);
            System.out.println("Driver: " + dbDriver);

            Class.forName(dbDriver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
