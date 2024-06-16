package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);
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

            logger.info("Loaded properties:");
            logger.info("URL: {}", dbUrl);
            logger.info("Username: {}", dbUsername);
            logger.info("Password: {}", dbPassword);
            logger.info("Driver: {}", dbDriver);

            Class.forName(dbDriver);
        } catch (Exception e) {
            logger.error("Failed to load database properties", e);
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            logger.error("Error connecting to the database", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
