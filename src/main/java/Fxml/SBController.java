package Fxml;

import com.example.login.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SBController implements Initializable {

    @FXML
    public Button Login_btn;

    @FXML
    public TextField acc_pswd_fld;

    @FXML
    public Label acc_pswd_lbl;

    @FXML
    public ChoiceBox<?> acc_selector;

    @FXML
    public TextField acc_usr_fld;

    @FXML
    public Label acc_usr_lbl;

    @FXML
    public Label error_lbl;
    public Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Login_btn.setOnAction(event -> onlogin());
    }
    private void onlogin(){
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


