package com.example.login;

import com.example.login.Models.Model;
import com.example.login.Views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private JbdcJava dbConnection;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialize the Model and ViewFactory
        Model model = Model.getInstance();
        ViewFactory viewFactory = model.getViewFactory();

        // Create an instance of JbdcJava and establish the database connection
        dbConnection = new JbdcJava();

        // Show the login window
        viewFactory.showClientWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
