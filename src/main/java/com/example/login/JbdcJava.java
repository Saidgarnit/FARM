package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JbdcJava {
    static String url = "jdbc:mysql://localhost:3306/myprojectjavafx";
    static String uname = "root";
    static String pass = "";

    public JbdcJava() {
        // Constructor is used to set up the JDBC connection
        try {
            Connection con = DriverManager.getConnection(url, uname, pass);
            // You can use the 'con' connection for your database operations here

            // Do not close the connection here; it should be kept open for use in your application
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exceptions here
        }
    }

    // You should implement your database operations within this method
    public static Connection connect() {
        try {
            Connection con = DriverManager.getConnection(url, uname, pass);
            return con; // Return the connection for use in your application
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exceptions here
            return null;
        }
    }
}
