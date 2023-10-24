package com.example.login.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.login.Models.Model;

public class ClientMenuController implements Initializable {

    @FXML
    private Button accounts_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button tach1_btn;

    private Button selectedButton; // Track the currently selected button

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        addListeners();
        selectedButton = null; // No button initially selected
        applyButtonEffects(dashboard_btn);
        applyButtonEffects(tach1_btn);
        applyButtonEffects(accounts_btn);
    }

    private void addListeners() {
        dashboard_btn.setOnAction(event -> onButtonClicked(dashboard_btn));
        tach1_btn.setOnAction(event -> onButtonClicked(tach1_btn));
        accounts_btn.setOnAction(event -> onButtonClicked(accounts_btn));
    }

    private void onButtonClicked(Button button) {
        // Handle the click event for the buttons
        if (selectedButton != null) {
            // Restore the style of the previously selected button
            selectedButton.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
        }
        // Set the new selected button
        selectedButton = button;
        // Update the style for the newly selected button
        button.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white;");

        // Handle the specific action for the clicked button here
        if (button == dashboard_btn) {
            onDashboard();
        } else if (button == tach1_btn) {
            onTransactions();
        } else if (button == accounts_btn) {
            onAccounts();
        }
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transaction");
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Accounts");
    }

    // Helper method to apply hover and click effects to a button
    private void applyButtonEffects(Button button) {
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");

        button.setOnMouseEntered(e -> {
            if (button != selectedButton) {
                button.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;");
            }
        });

        button.setOnMouseExited(e -> {
            if (button != selectedButton) {
                button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
            }
        });
    }
}
