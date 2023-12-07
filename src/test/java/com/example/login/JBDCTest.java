package com.example.login;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTest {

    @Test
    public void testJDBCConnection() {
        // Attempt to connect to the database
        Connection connection = JBDC.connect();

        // Assert that the connection is not null, indicating successful connection
        assertNotNull(connection);

        // Add further assertions or tests based on your specific requirements
        // For instance, you could test certain database operations using this connection
    }
}
