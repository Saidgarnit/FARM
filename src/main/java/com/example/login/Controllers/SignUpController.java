package com.example.login.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    public Button Signup_btn;
    public Label name_lbl;
    public TextField name_fld;
    public TextField email_fld;
    public Label email_lbl;
    public Label pswd_lbl;
    public PasswordField pswd_fld;
    public Label conpswd_lbl;
    public PasswordField conpswd_fld;



    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the stage when initializing the controller

    }


    public void LoginAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/9.png"))));
        stage.setResizable(false);
        stage.show();
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtain a reference to the login stage
        loginStage.close();
    }
    public void CreateAccountAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/9.png"))));
        stage.setResizable(false);
        stage.show();
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtain a reference to the login stage
        loginStage.close();
    }

}