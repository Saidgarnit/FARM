package com.example.login.Controllers.Farmer;

import com.example.login.Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public AnchorPane Logout;
    @FXML
    private BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Listen for changes in the selected menu item
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            // Handle "Transaction" selection
            switch (newVal) {
                case "Transaction" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Suivie" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getSuivieView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                // Handle "Accounts" selection
                case "Accounts" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Employees" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getEmployeesView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Charges" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getChargesView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Ventes" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getVentesView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Profile" -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
//                case "Logout" -> {
//                    try {
//                        client_parent.setCenter(Model.getInstance().getViewFactory().getLogoutView());
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
                // Handle other menu items (defaulting to the dashboard)
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
    public void Logout (ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You re about to logout");
        alert.setContentText("Do you want to save before exiting");
        if (alert.showAndWait().get()== ButtonType.OK){
        Stage stage = (Stage) Logout.getScene().getWindow();
        System.out.println("Logout");
        stage.close();
    }}
}
