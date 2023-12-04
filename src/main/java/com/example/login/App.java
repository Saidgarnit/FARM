package com.example.login;

import com.example.login.Models.Model;
import com.example.login.Views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;

public class App extends Application {

    private JBDC dbConnection;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Test the database connection asynchronously in a separate thread
        MyThread testConnectionThread = new MyThread();
        testConnectionThread.start();

        // Initialize the Model and ViewFactory
        Model model = Model.getInstance();
        ViewFactory viewFactory = model.getViewFactory();

        // Create an instance of JbdcJava and establish the database connection
        dbConnection = new JBDC();

        // Show the login window
        viewFactory.showLoginWindow();

//        // Call the method to retrieve admin records
//        JBDC.getAllAdminRecords();

        // Wait for the thread to complete
        try {
            testConnectionThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check the status of the thread
        if (testConnectionThread.isConnectionSuccessful()) {
            System.out.println("Thread successfully established the connection!");
        } else {
            System.out.println("Thread failed to establish the connection!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
