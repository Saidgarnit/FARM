package com.example.login.Controllers;

import com.example.login.JbdcJava;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Hyperlink SignUp;

    public Label email_lbl;
    public TextField email_fld;
    public Label pswd_lbl;
    public PasswordField pswd_fld;
    public ImageView loginImgView;
    public Button Login_btn;

    private Connection dbConnection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnection = JbdcJava.connect();
    }

    @FXML
    public void onLogin(ActionEvent event) throws IOException {
        String enteredEmail = email_fld.getText();
        String enteredPassword = pswd_fld.getText();

        if (dbConnection != null && isValidLogin(enteredEmail, enteredPassword)) {
            openClientScreen(event);
        } else {
            showLoginErrorAlert();
        }
    }

    private boolean isValidLogin(String email, String password) {
        try {
            String query = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean valid = resultSet.next();
            resultSet.close();
            preparedStatement.close();

            return valid;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void openClientScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Client.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/9.png"))));
        stage.setTitle("FIRMTY");
        stage.setResizable(false);
        stage.show();

        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
    }

    private void showLoginErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText("Login Failed");
        alert.setContentText("Incorrect email or password. Please try again.");
        alert.showAndWait();
    }

    public void signUpAction(ActionEvent event) {
    }
}
