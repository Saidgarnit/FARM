package com.example.login;

import java.sql.*;

public class JBDC {
    static String url = "jdbc:mysql://localhost:3306/myprojectjavafx";
    static String uname = "root";
    static String pass = "";

    public JBDC() {
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

    // Method to retrieve all records from the admin table

    public static void getAllAdminRecords() {
        try {
            Connection con = connect();
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, email, full_name, Ntele, DateBird, Age FROM admin");

                // Process the results
                while (rs.next()) {
                    // Retrieve data from the result set
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String fullName = rs.getString("full_name");
                    String nTele = rs.getString("Ntele");
                    Date dateBird = rs.getDate("DateBird");
                    int age = rs.getInt("Age");

                    // Display the retrieved data
                    System.out.println("ID: " + id + ", Email: " + email + ", Full Name: " + fullName +
                            ", Ntele: " + nTele + ", Date of Birth: " + dateBird + ", Age: " + age);
                    // Adjust the output format based on your requirements

                    // You can access other columns in a similar manner
                }
                // Close resources
                rs.close();
                stmt.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions here
        }
    }

}

