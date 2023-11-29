package com.example.login;

import java.sql.Connection;
import java.sql.SQLException;

public class MyThread extends Thread {
    private boolean isConnectionSuccessful;

    public boolean isConnectionSuccessful() {
        return isConnectionSuccessful;
    }

    @Override
    public void run() {
        Connection connection = JBDC.connect();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            isConnectionSuccessful = true;
            // Close the connection after testing
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish connection!");
            isConnectionSuccessful = false;
            // You might want to handle this failure accordingly
        }
    }
}
