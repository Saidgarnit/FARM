package com.example.login;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Improved database manager with connection pooling and proper resource management
 */
public class DatabaseManager {
    private static final Logger logger = Logger.getLogger(DatabaseManager.class.getName());
    private static DatabaseManager instance;
    private final BlockingQueue<Connection> connectionPool;
    private final ConfigManager config;
    private final String databaseUrl;
    private final String username;
    private final String password;
    
    private DatabaseManager() {
        this.config = ConfigManager.getInstance();
        this.databaseUrl = config.getDatabaseUrl();
        this.username = config.getDatabaseUsername();
        this.password = config.getDatabasePassword();
        this.connectionPool = new ArrayBlockingQueue<>(config.getMaxConnections());
        
        initializeConnectionPool();
    }
    
    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
    
    private void initializeConnectionPool() {
        try {
            // Load the MySQL driver
            Class.forName(config.getDatabaseDriver());
            
            // Create initial connections
            for (int i = 0; i < config.getMinConnections(); i++) {
                Connection conn = createConnection();
                if (conn != null) {
                    connectionPool.offer(conn);
                }
            }
            logger.info("Database connection pool initialized with " + connectionPool.size() + " connections");
        } catch (ClassNotFoundException e) {
            logger.severe("MySQL driver not found: " + e.getMessage());
        }
    }
    
    private Connection createConnection() {
        try {
            Connection conn = DriverManager.getConnection(databaseUrl, username, password);
            conn.setAutoCommit(true);
            return conn;
        } catch (SQLException e) {
            logger.severe("Failed to create database connection: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Get a connection from the pool
     */
    public Connection getConnection() throws SQLException {
        Connection conn = connectionPool.poll();
        if (conn == null || conn.isClosed()) {
            // Create a new connection if pool is empty or connection is closed
            conn = createConnection();
            if (conn == null) {
                throw new SQLException("Unable to create database connection");
            }
        }
        
        // Test the connection
        if (!conn.isValid(5)) {
            conn.close();
            conn = createConnection();
            if (conn == null) {
                throw new SQLException("Unable to create valid database connection");
            }
        }
        
        return conn;
    }
    
    /**
     * Return a connection to the pool
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed() && connection.isValid(5)) {
                    connectionPool.offer(connection);
                } else {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.warning("Error releasing connection: " + e.getMessage());
                try {
                    connection.close();
                } catch (SQLException ex) {
                    logger.severe("Error closing connection: " + ex.getMessage());
                }
            }
        }
    }
    
    /**
     * Execute a prepared statement with proper resource management
     */
    public ResultSet executeQuery(String sql, Object... parameters) throws SQLException {
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            setParameters(stmt, parameters);
            return stmt.executeQuery();
        } catch (SQLException e) {
            releaseConnection(conn);
            throw e;
        }
    }
    
    /**
     * Execute an update statement with proper resource management
     */
    public int executeUpdate(String sql, Object... parameters) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            setParameters(stmt, parameters);
            int result = stmt.executeUpdate();
            return result;
        } finally {
            closeQuietly(stmt);
            releaseConnection(conn);
        }
    }
    
    /**
     * Set parameters for prepared statement
     */
    private void setParameters(PreparedStatement stmt, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            stmt.setObject(i + 1, parameters[i]);
        }
    }
    
    /**
     * Close resources quietly without throwing exceptions
     */
    public static void closeQuietly(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    logger.warning("Error closing resource: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Close all connections in the pool
     */
    public void shutdown() {
        while (!connectionPool.isEmpty()) {
            try {
                Connection conn = connectionPool.poll();
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.warning("Error closing connection during shutdown: " + e.getMessage());
            }
        }
        logger.info("Database connection pool shutdown complete");
    }
    
    /**
     * Test database connectivity
     */
    public boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && conn.isValid(5);
        } catch (SQLException e) {
            logger.severe("Database connection test failed: " + e.getMessage());
            return false;
        }
    }
}