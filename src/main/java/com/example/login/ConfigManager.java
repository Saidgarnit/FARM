package com.example.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration manager for application settings
 */
public class ConfigManager {
    private static ConfigManager instance;
    private Properties properties;
    
    private ConfigManager() {
        loadConfiguration();
    }
    
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
    
    private void loadConfiguration() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                // Load default configuration if file doesn't exist
                loadDefaultConfiguration();
            }
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            loadDefaultConfiguration();
        }
    }
    
    private void loadDefaultConfiguration() {
        // Default database configuration
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/myprojectjavafx");
        properties.setProperty("db.username", "root");
        properties.setProperty("db.password", "");
        properties.setProperty("db.driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("db.pool.max.connections", "10");
        properties.setProperty("db.pool.min.connections", "2");
        
        // Application settings
        properties.setProperty("app.title", "FARM Management System");
        properties.setProperty("app.version", "1.0");
        properties.setProperty("app.session.timeout", "30");
    }
    
    public String getDatabaseUrl() {
        return properties.getProperty("db.url");
    }
    
    public String getDatabaseUsername() {
        return properties.getProperty("db.username");
    }
    
    public String getDatabasePassword() {
        return properties.getProperty("db.password");
    }
    
    public String getDatabaseDriver() {
        return properties.getProperty("db.driver");
    }
    
    public int getMaxConnections() {
        return Integer.parseInt(properties.getProperty("db.pool.max.connections", "10"));
    }
    
    public int getMinConnections() {
        return Integer.parseInt(properties.getProperty("db.pool.min.connections", "2"));
    }
    
    public String getAppTitle() {
        return properties.getProperty("app.title");
    }
    
    public String getAppVersion() {
        return properties.getProperty("app.version");
    }
    
    public int getSessionTimeout() {
        return Integer.parseInt(properties.getProperty("app.session.timeout", "30"));
    }
}