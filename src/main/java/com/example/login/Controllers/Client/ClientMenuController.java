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
    private Button logout_btn;

    @FXML
    private Button profil_btn;

    @FXML
    private Button report_btn;

    @FXML
    private Button tach1_btn;

    @FXML
    private Button tach2_btn;



    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        addListeners();
    }



    private void addListeners() {
        dashboard_btn.setOnAction(event -> onDashboard());
        tach1_btn.setOnAction(event -> onTransactions());
        accounts_btn.setOnAction(event -> onAccounts());
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

}


