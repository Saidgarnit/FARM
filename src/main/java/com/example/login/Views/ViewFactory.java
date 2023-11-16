package com.example.login.Views;

import com.example.login.Controllers.Farmer.ClientController;
import com.example.login.Controllers.LoginController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ViewFactory {
    private  AnchorPane LogoutView;

    private AnchorPane dashboardView;

    private AnchorPane transactionsView;

    private AnchorPane AccountsView;
    private AnchorPane ProfileView;

    private AnchorPane EmployeesView;
    private AnchorPane ChrgesView;
    private AnchorPane VentesView;
    private AnchorPane SuivieView;
    private final StringProperty clientSelectedMenuItem;




    public ViewFactory(StringProperty clientSelectedMenuItem) {
        this.clientSelectedMenuItem = new SimpleStringProperty("Fxml/Login.fxml");
        // Initialize your ViewFactory here if needed
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Dashboard.fxml"));
                dashboardView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user
            }
        }
        return dashboardView;
    }
    public AnchorPane getTransactionsView() throws IOException {
        if (transactionsView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Products.fxml"));
                transactionsView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return transactionsView;
    }
    public AnchorPane getSuivieView() throws IOException {
        if (SuivieView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Suivie.fxml"));
                SuivieView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return SuivieView;
    }

    public AnchorPane getAccountsView() throws IOException {
        if (AccountsView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Suppliers.fxml"));
                AccountsView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return AccountsView;
    }
    public AnchorPane getEmployeesView() throws IOException {
        if (EmployeesView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Employees.fxml"));
                EmployeesView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return EmployeesView;
    }
    public AnchorPane getChargesView() throws IOException {
        if (ChrgesView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Charges.fxml"));
                ChrgesView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return ChrgesView;
    }
    public AnchorPane getVentesView() throws IOException {
        if (VentesView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Ventes.fxml"));
                VentesView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return VentesView;
    }
    public AnchorPane getProfileView() throws IOException {
        if (ProfileView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Profile.fxml"));
                ProfileView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return ProfileView;
    }
//    public Node getLogoutView() throws IOException {
//
//        return null;
//    }



    public void showLoginWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Stage loginStage = createStage(loader);

        // Set confirmation dialog for closing the login stage
        setConfirmationOnClose(loginStage);

        loginStage.show();
    }
    private Stage createStage(FXMLLoader loader) throws IOException {
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/19.gif"))));
        stage.setResizable(false);
        stage.setTitle("FIRMTY"); // Set the window title here
        return stage;
    }


    public void showClientWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Farmer/Client.fxml"));
            Parent root = loader.load();

            // Assuming the controller is set in the FXML file, you can obtain it as follows:
            ClientController clientController = loader.getController();

            createStage(root, clientController, "FIRMTY");


        } catch (IOException e) {
            e.printStackTrace();
            // Handle or log the exception, and consider showing an error message to the user
        }
    }

    private void createStage(Parent root, ClientController clientController, String FIRMTY) {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(FIRMTY);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/19.gif"))));
        stage.setResizable(false);
        stage.setScene(scene);
        // Set the controller for the stage
        stage.setUserData(clientController);
        stage.show();
    }


    public void setConfirmationOnClose(Stage stage) {
        // Handle window close request for any given stage
        stage.setOnCloseRequest(event -> {
            event.consume(); // Consume the event to prevent immediate window closure

            // Show confirmation alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Do you want to exit?");
            alert.setContentText("Are you sure you want to exit?");

            // Customizing buttons in the alert
            ButtonType exitButton = new ButtonType("Exit");
            ButtonType cancelButton = new ButtonType("Cancel");

            alert.getButtonTypes().setAll(exitButton, cancelButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == exitButton) {
                // If 'Exit' button is clicked, close the stage
                closeStage(stage);
            }
            // If 'Cancel' or close button of the alert is clicked, do nothing (continue running)
        });
    }

    public void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }
}



























