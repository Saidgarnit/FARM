package com.example.login.Controllers;

import com.example.login.JBDC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    public Button Signup_btn;
    @FXML
    public Label name_lbl;
    @FXML
    public TextField name_fld;
    @FXML
    public TextField email_fld;
    @FXML
    public Label email_lbl;
    @FXML
    public Label pswd_lbl;
    @FXML
    public PasswordField pswd_fld;
    @FXML
    public Label conpswd_lbl;
    @FXML
    public PasswordField conpswd_fld;
    @FXML
    public Button CreateAccount;
    public Hyperlink Signin;
    public Label error_lbl;

    private Connection dbConnection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnection = JBDC.connect();

        // Add event listeners for email and password fields
        email_fld.textProperty().addListener((observable, oldValue, newValue) -> validateEmailInput(newValue));
        pswd_fld.textProperty().addListener((observable, oldValue, newValue) -> validatePasswordStrength(newValue));
        // Add event listeners for email, password, and name fields
        email_fld.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmailInput(newValue);
            limitCharacterCount2(email_fld, 20); // Limit to 20 characters for email
        });
        pswd_fld.textProperty().addListener((observable, oldValue, newValue) -> {
            validatePasswordStrength(newValue);
            limitCharacterCount(pswd_fld, 15); // Limit to 15 characters for password
        });
        name_fld.textProperty().addListener((observable, oldValue, newValue) -> limitCharacterCount(name_fld, 15)); // Limit to 15 characters for name
        conpswd_fld.textProperty().addListener((observable, oldValue, newValue) -> limitCharacterCount(conpswd_fld, 15));

    }

    private void limitCharacterCount2(TextField emailFld, int i) {
        if (emailFld.getText().length() > i) {
            String text = emailFld.getText().substring(0, i);
            emailFld.setText(text);
        }
    }

    private void limitCharacterCount(TextField emailFld, int limit) {
        if (emailFld.getText().length() > limit) {
            String text = emailFld.getText().substring(0, limit);
            emailFld.setText(text);
        }

    }



    private void validatePasswordStrength(String newValue) {
    }

    private void validateEmailInput(String newValue) {
    }

    public void LoginAction(ActionEvent event) throws IOException {
        showLoginScreen(event);
    }

    public void CreateAccountAction(ActionEvent event) {
        createAdminAccount(event);
    }

    private void showLoginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Login.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/19.gif"))));
        stage.setTitle("FIRMTY");
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    private void createAdminAccount(ActionEvent event) {
        String fullname = name_fld.getText();
        String email = email_fld.getText();
        String password = pswd_fld.getText();
        String confirmPassword = conpswd_fld.getText();

        if (fullname.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert("Please fill out all the fields.");
        } else if (!password.equals(confirmPassword)) {
            showAlert("Password and Confirm Password do not match.");
        } else if (!isValidEmail(email)) {
            showAlert("Invalid email address format.");
        } else if (!isStrongPassword(password)) {
            showAlert("Password is not strong enough. It should be at least 8 characters long.");
        } else {
            if (dbConnection != null) {
                try {
                    String insertQuery = "INSERT INTO admin (full_name, email, password, NTele, DateBird, Age, image_path) VALUES (?, ?, ?, ?, CURRENT_DATE, ?, 'C:\\Users\\Said\\Desktop\\ProjetFX\\login 2\\src\\main\\resources\\Images\\14.png')";
                    PreparedStatement preparedStatement = dbConnection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, fullname);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, "0600000000"); // Assuming NTele is a string now
                    preparedStatement.setInt(5, generateRandomAge());

                    int rowsAffected = preparedStatement.executeUpdate();
                    preparedStatement.close();

                    if (rowsAffected > 0) {
                        showSuccessAlert("Admin account created successfully!");
                        clearFields();
                        showLoginScreen(event);
                    } else {
                        showAlert("Admin account creation failed.");
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                    showAlert("Error occurred during account creation.");
                }
            }
        }
    }    // Generate a random age between 15 and 70
    private int generateRandomAge() {
        return 15 + (int)(Math.random() * 56); // 15 + random number between 0 and 55
    }




    boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@gmail.com");
    }

    boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }
    private void clearFields() {
        name_fld.clear();
        email_fld.clear();
        pswd_fld.clear();
        conpswd_fld.clear();
    }
}