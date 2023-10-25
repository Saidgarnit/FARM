package com.example.login.Controllers.Farmer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DashboardController {

    @FXML
    private Text acc_username;

    @FXML
    private TextField amount_fld;

    @FXML
    private Label check_nb;

    @FXML
    private Label ex_lbl;

    @FXML
    private Label inc_lbl;

    @FXML
    private Label login_date;

    @FXML
    private TextArea msg_fld;

    @FXML
    private TextField payee_fld;

    @FXML
    private Label saving_bal;

    @FXML
    private Label saving_nb;

    @FXML
    private Button sendmoney_btn;

    @FXML
    private ListView<?> trans_listview;

    @FXML
    private Label xheck_bal;

}
