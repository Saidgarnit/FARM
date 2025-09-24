package com.example.login.Controllers.Farmer;

import com.example.login.DatabaseManager;
import com.example.login.SecurityUtils;
import com.example.login.Models.Production;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    public Text login_date;
    @FXML
     Button idbuttadd,idbuttmodife,idbuttref,searchbtn;

    @FXML
    TextField idlabelnomrace,idlebelmetrage,idlebelqantite,idlebelqantitefinale,idlebelprix,idlebelorigine,idlebelnomfournisseur,idserch;
    @FXML
    DatePicker idlebeldateentre;
    @FXML
    ComboBox< String > idlebelnomemploye;
    @FXML
    TableView<Production> idtableview;
    @FXML
    TableColumn<Production, Integer> idrace =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomrace =new TableColumn<>();
    @FXML
    TableColumn<Production, Integer> idmetrage =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idqantite =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idqantitefinale =new TableColumn<>();
    @FXML
    TableColumn<Production, Float> idprix =new TableColumn<>();
    @FXML
    TableColumn<Production, LocalDate> iddateentre =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idorigine =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomemploye =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomfournisseur =new TableColumn<>();



    //Database




    //pour faire un connecton avec code et database
    private DatabaseManager dbManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            dbManager = DatabaseManager.getInstance();
            if (!dbManager.testConnection()) {
                showErrorAlert("Database Connection Error", "Unable to connect to the database.");
                return;
            }
        } catch (Exception e) {
            System.err.println("Database initialization error: " + e.getMessage());
            showErrorAlert("Database Error", "Failed to initialize database connection.");
        }




        idlebelnomemploye.getItems().addAll(
                "AHMED","DOHA","SAID","elmhjoub"
        );





        idrace.setCellValueFactory(new PropertyValueFactory<>("id"));
        idnomrace.setCellValueFactory(new PropertyValueFactory<>("Nom_de_race"));
        idmetrage.setCellValueFactory(new PropertyValueFactory<>("metrage"));
        idqantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        idqantitefinale.setCellValueFactory(new PropertyValueFactory<>("Qantite_Finale"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        iddateentre.setCellValueFactory(new PropertyValueFactory<>("Date_dentre"));
        idorigine.setCellValueFactory(new PropertyValueFactory<>("origine"));
        idnomemploye.setCellValueFactory(new PropertyValueFactory<>("Nom_de_lemploye"));
        idnomfournisseur.setCellValueFactory(new PropertyValueFactory<>("Nom_de_fournisseur"));


        getdata();
        getItem();




    }
    // ADD DATA
    @FXML
    void Add() {
        // Validate input fields
        if (!validateInputFields()) {
            return;
        }
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            int metrage = Integer.parseInt(idlebelmetrage.getText());
            double prix = Double.parseDouble(idlebelprix.getText());
            
            conn = dbManager.getConnection();
            stmt = conn.prepareStatement(
                "INSERT INTO production (metrage, Nom_de_race, Quantite, Qantite_Finale, Prix, Date_dentre, origine, Nom_de_lemploye, nom_de_fournisseur) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            stmt.setInt(1, metrage);
            stmt.setString(2, SecurityUtils.sanitizeInput(idlabelnomrace.getText()));
            stmt.setString(3, SecurityUtils.sanitizeInput(idlebelqantite.getText()));
            stmt.setString(4, SecurityUtils.sanitizeInput(idlebelqantitefinale.getText()));
            stmt.setDouble(5, prix);
            stmt.setString(6, idlebeldateentre.getValue().toString());
            stmt.setString(7, SecurityUtils.sanitizeInput(idlebelorigine.getText()));
            stmt.setString(8, idlebelnomemploye.getSelectionModel().getSelectedItem());
            stmt.setString(9, SecurityUtils.sanitizeInput(idlebelnomfournisseur.getText()));
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                showSuccessAlert("Success", "Production record added successfully!");
                clearInputFields();
                getdata();
            }
            
        } catch (NumberFormatException e) {
            showErrorAlert("Input Error", "Please enter valid numbers for metrage and prix.");
        } catch (SQLException e) {
            System.err.println("Add error: " + e.getMessage());
            showErrorAlert("Database Error", "Failed to add production record.");
        } finally {
            DatabaseManager.closeQuietly(stmt);
            if (dbManager != null) {
                dbManager.releaseConnection(conn);
            }
        }
    }
    Void getdata(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            idtableview.getItems().clear();
            conn = dbManager.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM production");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Production pro = new Production(
                        rs.getInt("id"),
                        rs.getInt("metrage"),
                        rs.getString("Nom_de_race"),
                        rs.getString("Quantite"),
                        rs.getString("Qantite_Finale"),
                        rs.getDouble("Prix"),
                        rs.getString("Date_dentre"),
                        rs.getString("Nom_de_lemploye"),
                        rs.getString("nom_de_fournisseur"),
                        rs.getString("origine"));
                idtableview.getItems().add(pro);
            }
            idtableview.refresh();
        } catch (SQLException e) {
            System.err.println("Data loading error: " + e.getMessage());
            showErrorAlert("Data Loading Error", "Failed to load production data.");
        } finally {
            DatabaseManager.closeQuietly(rs, stmt);
            if (dbManager != null) {
                dbManager.releaseConnection(conn);
            }
        }
        return null;
    }
    
    /**
     * Show error alert to user
     */
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Show success alert to user
     */
    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Validate input fields
     */
    private boolean validateInputFields() {
        StringBuilder errors = new StringBuilder();
        
        if (idlebelmetrage.getText() == null || idlebelmetrage.getText().trim().isEmpty()) {
            errors.append("Metrage is required.\n");
        } else {
            try {
                Integer.parseInt(idlebelmetrage.getText());
            } catch (NumberFormatException e) {
                errors.append("Metrage must be a valid number.\n");
            }
        }
        
        if (idlabelnomrace.getText() == null || idlabelnomrace.getText().trim().isEmpty()) {
            errors.append("Nom de race is required.\n");
        }
        
        if (idlebelqantite.getText() == null || idlebelqantite.getText().trim().isEmpty()) {
            errors.append("Quantite is required.\n");
        }
        
        if (idlebelprix.getText() == null || idlebelprix.getText().trim().isEmpty()) {
            errors.append("Prix is required.\n");
        } else {
            try {
                Double.parseDouble(idlebelprix.getText());
            } catch (NumberFormatException e) {
                errors.append("Prix must be a valid number.\n");
            }
        }
        
        if (idlebeldateentre.getValue() == null) {
            errors.append("Date d'entree is required.\n");
        }
        
        if (idlebelnomemploye.getSelectionModel().getSelectedItem() == null) {
            errors.append("Employee selection is required.\n");
        }
        
        if (errors.length() > 0) {
            showErrorAlert("Validation Error", errors.toString());
            return false;
        }
        
        return true;
    }
    
    /**
     * Clear all input fields
     */
    private void clearInputFields() {
        idlebelmetrage.clear();
        idlabelnomrace.clear();
        idlebelqantite.clear();
        idlebelqantitefinale.clear();
        idlebelprix.clear();
        idlebelorigine.clear();
        idlebelnomfournisseur.clear();
        idlebeldateentre.setValue(null);
        idlebelnomemploye.getSelectionModel().clearSelection();
        idserch.clear();
    }
    void getItem(){
        idtableview.setOnMouseClicked(event ->{
            idlebelmetrage.setText(String.valueOf(idtableview.getSelectionModel().getSelectedItem().getMetrage()));
            idlabelnomrace.setText(idtableview.getSelectionModel().getSelectedItem().getNom_de_race());
            idlebelqantite.setText(idtableview.getSelectionModel().getSelectedItem().getQuantite());
            idlebelqantitefinale.setText(idtableview.getSelectionModel().getSelectedItem().getQantite_Finale());
            idlebelprix.setText(idtableview.getSelectionModel().getSelectedItem().getPrix());
            idlebeldateentre.setValue(LocalDate.parse(idtableview.getSelectionModel().getSelectedItem().getDate_dentre()));
            idlebelorigine.setText(String.valueOf(idtableview.getSelectionModel().getSelectedItem().getOrigine()));
            idlebelnomemploye.setValue(idtableview.getSelectionModel().getSelectedItem().getNom_de_lemploye());
            idlebelnomfournisseur.setText(idtableview.getSelectionModel().getSelectedItem().getNom_de_fournisseur());


        });
    }
    @FXML
    void delet(ActionEvent event) {
        Production selectedItem = idtableview.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showErrorAlert("Selection Error", "Please select a record to delete.");
            return;
        }
        
        // Confirm deletion
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText("Delete Production Record");
        confirmAlert.setContentText("Are you sure you want to delete this production record?");
        
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                performDelete(selectedItem.getId());
            }
        });
    }
    
    private void performDelete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = dbManager.getConnection();
            stmt = conn.prepareStatement("DELETE FROM production WHERE id = ?");
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                showSuccessAlert("Success", "Production record deleted successfully!");
                clearInputFields();
                getdata();
            }
        } catch (SQLException e) {
            System.err.println("Delete error: " + e.getMessage());
            showErrorAlert("Database Error", "Failed to delete production record.");
        } finally {
            DatabaseManager.closeQuietly(stmt);
            if (dbManager != null) {
                dbManager.releaseConnection(conn);
            }
        }
    }

    @FXML
    void updat(ActionEvent event) {
        Production selectedItem = idtableview.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showErrorAlert("Selection Error", "Please select a record to update.");
            return;
        }
        
        if (!validateInputFields()) {
            return;
        }
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            int metrage = Integer.parseInt(idlebelmetrage.getText());
            double prix = Double.parseDouble(idlebelprix.getText());
            int id = selectedItem.getId();

            conn = dbManager.getConnection();
            stmt = conn.prepareStatement(
                "UPDATE production SET metrage=?, Nom_de_race=?, Quantite=?, Qantite_Finale=?, Prix=?, Date_dentre=?, Nom_de_lemploye=?, nom_de_fournisseur=?, origine=? WHERE id=?"
            );
            
            stmt.setInt(1, metrage);
            stmt.setString(2, SecurityUtils.sanitizeInput(idlabelnomrace.getText()));
            stmt.setString(3, SecurityUtils.sanitizeInput(idlebelqantite.getText()));
            stmt.setString(4, SecurityUtils.sanitizeInput(idlebelqantitefinale.getText()));
            stmt.setDouble(5, prix);
            stmt.setString(6, idlebeldateentre.getValue().toString());
            stmt.setString(7, idlebelnomemploye.getSelectionModel().getSelectedItem());
            stmt.setString(8, SecurityUtils.sanitizeInput(idlebelnomfournisseur.getText()));
            stmt.setString(9, SecurityUtils.sanitizeInput(idlebelorigine.getText()));
            stmt.setInt(10, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                showSuccessAlert("Success", "Production record updated successfully!");
                clearInputFields();
                getdata();
            }

        } catch (NumberFormatException e) {
            showErrorAlert("Input Error", "Please enter valid numbers for metrage and prix.");
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
            showErrorAlert("Database Error", "Failed to update production record.");
        } finally {
            DatabaseManager.closeQuietly(stmt);
            if (dbManager != null) {
                dbManager.releaseConnection(conn);
            }
        }
    }

    public void searche(ActionEvent actionEvent) {
        String searchTerm = idserch.getText();
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            getdata(); // Show all data if search is empty
            return;
        }
        
        // Sanitize input to prevent SQL injection
        searchTerm = SecurityUtils.sanitizeInput(searchTerm.trim());
        
        this.idtableview.getItems().clear();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = dbManager.getConnection();
            // Use parameterized query to prevent SQL injection
            stmt = conn.prepareStatement("SELECT * FROM production WHERE Nom_de_race LIKE ?");
            stmt.setString(1, searchTerm + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Production proo = new Production(
                        rs.getInt("id"),
                        rs.getInt("metrage"),
                        rs.getString("Nom_de_race"),
                        rs.getString("Quantite"),
                        rs.getString("Qantite_Finale"),
                        rs.getDouble("Prix"),
                        rs.getString("Date_dentre"),
                        rs.getString("origine"),
                        rs.getString("Nom_de_lemploye"),
                        rs.getString("nom_de_fournisseur"));

                this.idtableview.getItems().add(proo);
            }
        } catch (SQLException e) {
            System.err.println("Search error: " + e.getMessage());
            showErrorAlert("Search Error", "An error occurred while searching. Please try again.");
        } finally {
            DatabaseManager.closeQuietly(rs, stmt);
            if (dbManager != null) {
                dbManager.releaseConnection(conn);
            }
        }
    }



}




