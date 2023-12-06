import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class YourControllerClass {
    
    @FXML
    private TableView<YourDataModelClass> idtableview;

    @FXML
    private TableColumn<YourDataModelClass, String> idrace;

    @FXML
    private TableColumn<YourDataModelClass, String> idnomrace;

    @FXML
    private TableColumn<YourDataModelClass, String> idqantite;

    @FXML
    private TableColumn<YourDataModelClass, String> idprix;

    @FXML
    private TableColumn<YourDataModelClass, String> iddateentre;

    @FXML
    private TableColumn<YourDataModelClass, String> iddateentre1;

    @FXML
    private TextField idserch;

    @FXML
    private TextField idlabelnomrace;

    @FXML
    private TextField idlebelqantitefinale;

    @FXML
    private TextField idlebelprix;

    @FXML
    private DatePicker idlebeldateentre;

    @FXML
    private TextField idlebelnomfournisseur;

    @FXML
    private Button idbuttadd;

    @FXML
    private Button idbuttref;

    @FXML
    private Button idbuttmodife;

    @FXML
    private TextField idlebelprix1;

    // You might have other fields, methods, and initialization logic...

    @FXML
    void initialize() {
        // Initialize your TableView columns with corresponding properties from YourDataModelClass
        idrace.setCellValueFactory(new PropertyValueFactory<>("raceProperty"));
        idnomrace.setCellValueFactory(new PropertyValueFactory<>("nomRaceProperty"));
        idqantite.setCellValueFactory(new PropertyValueFactory<>("qantiteProperty"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prixProperty"));
        iddateentre.setCellValueFactory(new PropertyValueFactory<>("dateEntreProperty"));
        iddateentre1.setCellValueFactory(new PropertyValueFactory<>("dateEntre1Property"));

        // Set up any other initialization logic...

        // Add event handlers for buttons or other interactive elements
        idbuttadd.setOnMouseClicked(this::handleAddButton);
        idbuttref.setOnMouseClicked(this::handleEditButton);
        idbuttmodife.setOnMouseClicked(this::handleDeleteButton);
    }

    // Define methods for handling button clicks or other events
    private void handleAddButton(MouseEvent event) {
        // Logic for handling the "Add" button click
    }

    private void handleEditButton(MouseEvent event) {
        // Logic for handling the "Edit" button click
    }

    private void handleDeleteButton(MouseEvent event) {
        // Logic for handling the "Delete" button click
    }
}
