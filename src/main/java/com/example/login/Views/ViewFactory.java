package com.example.login.Views;

import com.example.login.Controllers.Client.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private AnchorPane dashboardView;

    private AnchorPane transactionsView;

    private AnchorPane AccountsView;

    private final StringProperty clientSelectedMenuItem;




    public ViewFactory(StringProperty clientSelectedMenuItem) {
        this.clientSelectedMenuItem = new SimpleStringProperty("SB.fxml");
        // Initialize your ViewFactory here if needed
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml"));
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml"));
                transactionsView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return transactionsView;
    }


    public AnchorPane getAccountsView() throws IOException {
        if (AccountsView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml"));
                AccountsView = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // You might want to show an error message to the user or handle it appropriately
                throw e; // Re-throw the exception if you want it to be handled further
            }
        }
        return AccountsView;
    }







    public void showLoginWindow() {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SB.fxml"));
            createStage(loader, "Login");
    }



   /* public void showClientWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        Parent root = loader.load();

        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader, "Client");
    }
*/


    public void showClientWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
            Parent root = loader.load();

            // Assuming the controller is set in the FXML file, you can obtain it as follows:
            ClientController clientController = loader.getController();

            createStage(root, clientController, "Client");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle or log the exception, and consider showing an error message to the user
        }
    }

    private void createStage(Parent root, ClientController clientController, String client) {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(client);

        // Set the controller for the stage
        stage.setUserData(clientController);

        stage.show();
    }



    private void createStage(FXMLLoader loader, String title) {
        try {
          Scene scene = new Scene(loader.load());
         Stage stage = new Stage();
         stage.setScene(scene);
       stage.setTitle(title);
        stage.show();


    } catch (IOException e) {
            e.printStackTrace();
            // You might want to show an error message to the user
        }
    }

    public void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }




}



























