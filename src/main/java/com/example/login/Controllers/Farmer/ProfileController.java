package com.example.login.Controllers.Farmer;

import com.example.login.JBDC;
import com.example.login.Models.Admin;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.example.login.SessionManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ProfileController implements Initializable {

    public TextField name_fld;
    public TextField email_fld;
    public TextField tele_fld;
    public DatePicker datebird_fld;
    public Button edit_btn;
    public Button save_btn;
    public PasswordField newpass_fld;
    public TextField newemail_fld;
    public TextField password_fld;
    public Label email_lbl;
    public Label newpass_lbl;
    public Label comnewpass_lbl;
    public PasswordField comnewpass_fld;
    public ImageView img_view;
    public Label name_lbl;
    public Label Age_lbl;
    public Label tele_lbl;
    public TextField Age_fld;
    public Label datebird_lbl;

    private Connection dbConnection;
    private Admin adminProfile;
    private FileChooser fileChooser;
    private File selectedImageFile;
    @Override
    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnection = JBDC.connect();
        String loggedInAdminEmail = SessionManager.getInstance().getLoggedInAdminEmail();

        if (loggedInAdminEmail != null) {
            fetchAdminProfile(loggedInAdminEmail);
            displayAdminProfile();
        }

        // Load and display the image here
        loadImageFromDatabase();

        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg", "*.gif"));

        // Handle the edit button action
        edit_btn.setOnAction(event -> openFileChooser());

        // Handle the save button action
        save_btn.setOnAction(event -> updateAdminProfile());
    }

    private void loadImageFromDatabase() {
        if (adminProfile != null) {
            // Initialize the initialImagePath with your new path
            String initialImagePath = "C:/Users/Said/Desktop/ProjetFX/login 2/src/main/resources/Images/14.jpg";
            // Retrieve the image path from the admin profile
            String imagePathFromDatabase = adminProfile.getImage();

            if (imagePathFromDatabase != null && !imagePathFromDatabase.isEmpty()) {
                try {
                    // Load the image from the path
                    File imageFile = new File(imagePathFromDatabase);
                    if (imageFile.exists()) {
                        FileInputStream inputStream = new FileInputStream(imageFile);
                        Image image = new Image(inputStream);
                        img_view.setImage(image);
                    } else {
//                        showErrorAlert("Image Error", "Image file does not exist at the specified path.");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    showErrorAlert("Image Error", "Failed to load the profile image.");
                }
            } else {
                // If there's no image in the database, use the initialImagePath as a fallback
                try {
                    File imageFile = new File(initialImagePath);
                    if (imageFile.exists()) {
                        FileInputStream inputStream = new FileInputStream(imageFile);
                        Image image = new Image(inputStream);
                        img_view.setImage(image);
                    } else {
//                        showErrorAlert("Image Error", "Initial image file does not exist at the specified path.");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    showErrorAlert("Image Error", "Failed to load the initial profile image.");
                }
            }
        }
    }


    private void openFileChooser() {
        selectedImageFile = fileChooser.showOpenDialog(null);

        Image image = null;
        if (selectedImageFile != null) {
            // Load and display the selected image
            try {
                FileInputStream inputStream = new FileInputStream(selectedImageFile);
                image = new Image(inputStream);
                img_view.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                showErrorAlert("Image Error", "Failed to load the selected image.");
            }
        }
    }



    private void updateAdminProfile() {
        String newName = name_fld.getText();
        String newEmail = email_fld.getText().trim();
        String newTele = tele_fld.getText();
        LocalDate newDateBird = datebird_fld.getValue();
        int newAge;

        // Validate and parse the age field
        try {
            newAge = Integer.parseInt(Age_fld.getText());
            if (newAge < 15 || newAge > 75) {
                showErrorAlert("Invalid Age", "Age must be between 15 and 75.");
                return; // Don't proceed with the update if the age is invalid.
            }
        } catch (NumberFormatException e) {
            showErrorAlert("Invalid Age", "Please enter a valid age.");
            return; // Don't proceed with the update if the age is not a valid number.
        }

        // Validate the name field
        if (newName.isEmpty()) {
            showErrorAlert("Empty Name", "Name field cannot be empty.");
            return; // Exit the method without saving
        } else if (newName.length() > 10) {
            showErrorAlert("Invalid Name Length", "Name must be a maximum of 10 characters.");
            return; // Exit the method without saving
        }

        // Validate the tele field
        if (newTele.isEmpty()) {
            showErrorAlert("Empty Telephone", "Telephone field cannot be empty.");
            return; // Exit the method without saving
        } else if (!newTele.matches("^06\\d{8}$")) {
            showErrorAlert("Invalid Telephone", "Telephone must start with '06' and contain exactly 10 digits.");
            return; // Exit the method without saving
        }

        // If newEmail is empty, show an alert and don't continue with the changes
        if (newEmail.isEmpty()) {
            showErrorAlert("Empty Email", "Email field cannot be empty.");
            return; // Exit the method without saving
        }

        // Check if the new email matches the desired format
        if (!isValidEmailFormat(newEmail)) {
            showErrorAlert("Invalid Email Format", "Please enter a valid email address.");
            return; // Exit the method without saving
        }

        String newPassword = password_fld.getText();
        String confirmPassword = comnewpass_fld.getText();

        // Check if the current password is equal to the password in the database
        if (!newPassword.isEmpty() && !newPassword.equals(adminProfile.getPassword())) {
            // The current password has changed, so we need to validate it
            if (!newPassword.equals(confirmPassword)) {
                showErrorAlert("Password Mismatch", "New password and confirm password do not match.");
                return; // Exit the method without saving
            }

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                showErrorAlert("Empty Password", "Password fields cannot be empty.");
                return; // Exit the method without saving
            }
        } else if (!comnewpass_fld.getText().isEmpty()) {
            // The current password is unchanged, so we only validate if comnewpass_fld is not empty
            if (!newPassword.equals(confirmPassword)) {
                showErrorAlert("Password Mismatch", "New password and confirm password do not match.");
                return; // Exit the method without saving
            }

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                showErrorAlert("Empty Password", "Password fields cannot be empty.");
                return; // Exit the method without saving
            }
        }

        if (newDateBird != null) {
            String newImagePath = null;

            if (selectedImageFile != null) {
                // If a new image has been selected, save it and update the path
                newImagePath = saveImage(selectedImageFile);
            } else {
                // Use the existing image path
                newImagePath = adminProfile.getImagePath();
            }

            try {
                String query = "UPDATE admin SET full_name = ?, email = ?, NTele = ?, datebird = ?, Age = ?, password = ?, image_path = ? WHERE email = ?";
                PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
                preparedStatement.setString(1, newName);
                preparedStatement.setString(2, newEmail);
                preparedStatement.setString(3, newTele);
                preparedStatement.setDate(4, Date.valueOf(newDateBird));
                preparedStatement.setInt(5, newAge);
                preparedStatement.setString(6, newPassword);
                preparedStatement.setString(7, newImagePath); // Update the image path
                preparedStatement.setString(8, adminProfile.getEmail());

                int rowsUpdated = preparedStatement.executeUpdate();
                preparedStatement.close();

                if (rowsUpdated > 0) {
                    // Update was successful
                    System.out.println("Admin profile updated successfully.");
                    DashboardController.getInstance().updateFullName(newName);
                    adminProfile.setFullName(newName);
                    adminProfile.setEmail(newEmail);
                    adminProfile.setTelephone(newTele);
                    adminProfile.setDateOfBirth(newDateBird);
                    adminProfile.setAge(String.valueOf(newAge));
                    adminProfile.setPassword(newPassword);
                    adminProfile.setImagePath(newImagePath);

                    showSuccessAlert("Profile Updated", "Admin profile has been updated successfully.");
                } else {
                    // Update failed
                    System.out.println("Admin profile update failed.");
                    showErrorAlert("Profile Update Failed", "Failed to update admin profile.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showErrorAlert("Database Error", "An error occurred while updating the admin profile.");
            }
        } else {
            showErrorAlert("Invalid Date", "Please select a valid date of birth.");
        }
    }

    private String saveImage(File imageFile) {
        String newImagePath = null;

        try {
            // You can save the image to a specific directory and get the new path
            // For example, let's assume you have an "images" directory
            File targetDirectory = new File("images");
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs();
            }

            String imageFileName = "admin_image_" + adminProfile.getEmail() + ".jpg";
            File destinationFile = new File(targetDirectory, imageFileName);

            // Copy the selected image to the destination file
            Files.copy(imageFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Set the new image path for the admin's profile
            newImagePath = destinationFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Image Save Error", "Failed to save the selected image.");
        }

        return newImagePath;
    }

    // Add a function to validate email format
    private boolean isValidEmailFormat(String email) {
        // You can implement your email format validation logic here
        // For a basic format check, you can use regular expressions
        // This is a simple example; you can modify it as needed
        String regex = "^[a-zA-Z0-9._%+-]+@gmail.com";
        return email.matches(regex);
    }



    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private void fetchAdminProfile(String adminEmail) {
        try {
            String query = "SELECT full_name, email, ntele, datebird, password, Age, image_path FROM admin WHERE email = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, adminEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("ntele");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("Age");
                java.sql.Date dateOfBirthSql = resultSet.getDate("datebird");
                LocalDate dateOfBirth = (dateOfBirthSql != null) ? dateOfBirthSql.toLocalDate() : null;
                String image = resultSet.getString("image_path");

                // Create the Admin object
                adminProfile = new Admin(fullName, email, telephone, age, dateOfBirth, password, image);

                // Load and display the image
                loadImageFromDatabase(image);
            } else {
                System.out.println("Admin profile not found for email: " + adminEmail);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadImageFromDatabase(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    FileInputStream inputStream = new FileInputStream(imageFile);
                    Image image = new Image(inputStream);
                    img_view.setImage(image);
                } else {
//                    showErrorAlert("Image Error", "Image file does not exist at the specified path.");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                showErrorAlert("Image Error", "Failed to load the profile image.");
            }
        } else {
            showErrorAlert("Image Path Error", "Image path is missing or empty.");
        }
    }


    private void displayAdminProfile() {
        name_fld.setText(adminProfile.getFullName());
        email_fld.setText(adminProfile.getEmail());
        int age = adminProfile.getAge();
        Age_fld.setText(String.valueOf(age));
        tele_fld.setText(adminProfile.getTelephone());
        password_fld.setText(adminProfile.getPassword());
        datebird_fld.setValue(adminProfile.getDateMinusAge());
        // Load and display the image
        loadImageFromDatabase(adminProfile.getImage());
    }
}
