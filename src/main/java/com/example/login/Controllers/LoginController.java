package com.example.login.Controllers;


import com.example.login.Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable  {


    public Hyperlink SignUp;
    @FXML
    private Button Login_btn;

    @FXML
    private TextField acc_pswd_fld;

    @FXML
    private Label acc_pswd_lbl;

    @FXML
    private TextField acc_usr_fld;

    @FXML
    private Label acc_usr_lbl;

    @FXML
    private Hyperlink btn_signUp;

    @FXML
    private Label error_lbl;

    @FXML
    private ImageView loginImgView;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the stage when initializing the controller

    }
    @FXML
    public void onLogin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Client.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/9.png"))));
        stage.setTitle("FIRMTY");
        stage.setResizable(false);
        stage.show();
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtain a reference to the login stage
        loginStage.close();
    }

    public void signUpAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Sign.fxml"));
        Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sign Up");
            stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/9.png"))));
            stage.setResizable(false);
            stage.show();
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obtain a reference to the login stage
        loginStage.close();

    }




}
