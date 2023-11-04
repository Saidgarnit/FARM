package com.example.login.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private Connection dbConnection;

    public AdminDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Admin getAdminByEmail(String email) {
        Admin admin = null;
        try {
            String query = "SELECT full_name, email, ntele, datebird, password, Age, image_path FROM admin WHERE email = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin(
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("ntele"),
                        resultSet.getInt("Age"),
                        resultSet.getDate("datebird").toLocalDate(),
                        resultSet.getString("password"), // corrected column name
                        resultSet.getString("image_path")
                );
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
