package com.example.login;

import com.example.login.Models.Model;
import com.example.login.Views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App extends Application {

    private JbdcJava dbConnection;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Test the database connection
        testDatabaseConnection();

        // Initialize the Model and ViewFactory
        Model model = Model.getInstance();
        ViewFactory viewFactory = model.getViewFactory();

        // Create an instance of JbdcJava and establish the database connection
        dbConnection = new JbdcJava();

        // Show the login window
        viewFactory.showLoginWindow();
    }

    private void testDatabaseConnection() {
        // Test the database connection here
        Connection connection = JbdcJava.connect();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            // Close the connection after testing
            try {
                connection.close();
                System.out.println("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish connection!");
            // You might want to handle this failure accordingly
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
