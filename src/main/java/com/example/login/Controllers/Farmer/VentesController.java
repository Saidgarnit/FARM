package com.example.login.Controllers.Farmer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YourControllerClass {

    @FXML
    private TableView<YourDataModelClass> idtableview;

    @FXML
    private TableColumn<YourDataModelClass, String> idNomDeProduct;

    @FXML
    private TableColumn<YourDataModelClass, String> idQuantite;

    @FXML
    private TableColumn<YourDataModelClass, String> idPrix;

    @FXML
    private TableColumn<YourDataModelClass, String> idDateVentre;

    @FXML
    private TableColumn<YourDataModelClass, String> idClient;

    // Establish database connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/myprojectjavafx";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    @FXML
    void initialize() {
        // Initialize your TableView columns with corresponding properties from YourDataModelClass
        idNomDeProduct.setCellValueFactory(new PropertyValueFactory<>("nomDeProductProperty"));
        idQuantite.setCellValueFactory(new PropertyValueFactory<>("quantiteProperty"));
        idPrix.setCellValueFactory(new PropertyValueFactory<>("prixProperty"));
        idDateVentre.setCellValueFactory(new PropertyValueFactory<>("dateVentreProperty"));
        idClient.setCellValueFactory(new PropertyValueFactory<>("clientProperty"));

        // Load data from the database
        loadDataFromDatabase();

        // Set up any other initialization logic...

        // Add event handlers for buttons or other interactive elements
        // (Replace these with your actual event handlers)
        idtableview.setOnMouseClicked(this::handleTableClick);
    }

    private void loadDataFromDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ventes");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Create YourDataModelClass objects and add them to the TableView
                YourDataModelClass dataModel = new YourDataModelClass(
                        resultSet.getString("Nom_De_Product"),
                        resultSet.getString("Quantite"),
                        resultSet.getString("Prix"),
                        resultSet.getString("Date_Ventre"),
                        resultSet.getString("Client")
                );

                idtableview.getItems().add(dataModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, log or show a user-friendly message
        }
    }

    private void handleTableClick(MouseEvent event) {
        // Logic for handling table clicks
    }
}
