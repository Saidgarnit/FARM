package com.example.login;

import com.example.login.Models.Model;
import com.example.login.Views.ViewFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {





    @Override
    public void start(Stage primaryStage) throws IOException {




        // Initialize the Model and ViewFactory
        Model model = Model.getInstance();
        ViewFactory viewFactory = model.getViewFactory();

        // Show the login window
        viewFactory.showLoginWindow();

    }
    public static void main(String[] args) {
        launch(args);
    }



}
