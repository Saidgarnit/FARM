package com.example.login.Controllers;

//import com.sun.javafx.scene.control.InputField;
import com.example.login.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Label choicePromptText;
    public ChoiceBox acc_selector;
    public Label acc_usr_lbl;
    public TextField acc_usr_fld;
    public Label acc_pswd_lbl;
    public TextField acc_pswd_fld;
    public Button login_btm;
    public Label error_lbl;
    public Button Login_btn;

    // ...

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the stage when initializing the controller
        this.stage = (Stage) this.login_btm.getScene().getWindow();
       this.login_btm.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        try {
            if (this.stage != null) {
                Model.getInstance().getViewFactory().closeStage(this.stage);
                Model.getInstance().getViewFactory().showClientWindow();
            } else {
                // Handle the case when the stage is not available
                System.err.println("Error: Unable to retrieve the stage.");
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
        }
    }
}
