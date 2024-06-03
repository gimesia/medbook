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

            Class.forName(dbDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
