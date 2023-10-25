package com.example.login.Controllers.Farmer;

import com.example.login.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    @FXML
    private BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Listen for changes in the selected menu item
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            // Handle "Transaction" selection
            if (newVal.equals("Transaction")) {
                try {
                    client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // Handle "Accounts" selection
            else if (newVal.equals("Accounts")) {
                try {
                    client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // Handle other menu items (defaulting to the dashboard)
            else {
                client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
