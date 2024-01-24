package com.example.login.Controllers.Farmer;

import com.example.login.Models.Ventes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VentesController implements Initializable {

    public TableColumn idrace;
    public TableColumn idnomrace;
    public TableColumn idqantite;
    public TableColumn idprix;
    public TableColumn iddateentre;
    public TableColumn iddateentre1;
    public TextField idserch;
    public TextField idlabelnomrace;
    public TextField idlebelqantitefinale;
    public TextField idlebelprix;
    public DatePicker idlebeldateentre;
    public TextField idlebelnomfournisseur;
    public Button idbuttadd;
    public Button idbuttref;
    public Button idbuttmodife;
    public TextField idlebelprix1;
    @FXML
    private TableView<Ventes> idtableview;

    @FXML
    private TableColumn<Ventes, String> id;

    @FXML
    private TableColumn<Ventes, String> idNomDeProduct;

    @FXML
    private TableColumn<Ventes, String> idQuantite;

    @FXML
    private TableColumn<Ventes, String> idPrix;

    @FXML
    private TableColumn<Ventes, String> idDateVentre;

    @FXML
    private TableColumn<Ventes, String> idClient;

    // Establish database connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/myprojectjavafx";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the table columns
        idNomDeProduct.setCellValueFactory(new PropertyValueFactory<>("nomDeProduct"));
        idQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        idPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        idDateVentre.setCellValueFactory(new PropertyValueFactory<>("dateVentre"));
        idClient.setCellValueFactory(new PropertyValueFactory<>("client"));

        // Load data from the database
        loadDataFromDatabase();

        // Attach event handler for table clicks
        idtableview.setOnMouseClicked(this::handleTableClick);
    }

    private void loadDataFromDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ventes");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Create YourDataModelClass objects and add them to the TableView
                Ventes dataModel = new Ventes(
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
        // You can access the selected item using idtableview.getSelectionModel().getSelectedItem()
    }
}
