package com.example.login.Controllers.Farmer;

import com.example.login.Models.Model;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {



    public Button Ventes_btn;

    public Button Charges_btn;
    public ImageView Charges_Icon;
    public ImageView Ventes_icon;
    public Button Suivie_btn;
    public ImageView Suivie_icon;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button Products_btn;
    @FXML
    private Button Suppliers_btn;
    @FXML
    private Button Employees_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Button profil_btn;

    @FXML
    private ImageView dashboard_icon;
    @FXML
    private ImageView Products_icon;
    @FXML
    private ImageView Suppliers_icon;
    @FXML
    private ImageView Employees_icon;
    @FXML
    private ImageView profil_icon;
    @FXML
    private ImageView logou_icon;

    private Button[] menuButtons;
    private Button selectedButton;




    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        menuButtons = new Button[]{
                dashboard_btn,
                Products_btn,
                Suivie_btn,
                Suppliers_btn,
                Employees_btn,
                profil_btn,
                logout_btn,
                Ventes_btn,
                Charges_btn,

        };
        addListeners();
        selectedButton = null;
        onButtonClicked(dashboard_btn);

    }

    private void addListeners() {
        for (Button button : menuButtons) {
            button.setOnAction(event -> onButtonClicked(button));
            applyButtonEffects(button);
        }
    }

    private void onButtonClicked(Button button) {
        if (selectedButton != null) {
            selectedButton.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
            ImageView icon = null;

            if (selectedButton == dashboard_btn) {
                icon = dashboard_icon;
            } else if (selectedButton == Products_btn) {
                icon = Products_icon;
            } else if (selectedButton == Suivie_btn) {
                icon = Suivie_icon;
            } else if (selectedButton == Suppliers_btn) {
                icon = Suppliers_icon;
            } else if (selectedButton == Employees_btn) {
                icon = Employees_icon;
            } else if (selectedButton == profil_btn) {
                icon = profil_icon;
            } else if (selectedButton == Ventes_btn) {
                icon =   Charges_Icon;;
            }
            else if (selectedButton == Charges_btn) {
                icon = logou_icon;
            }
            else if (selectedButton == logout_btn) {
                icon = logou_icon;
            }
            if (icon != null) {
                icon.setEffect(null); // Remove any effects on the previous button's icon
            }
        }

        selectedButton = button;
        button.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white;");
        ImageView icon = null;

        if (button == dashboard_btn) {
            icon = dashboard_icon;
            onDashboard();
        } else if (button == Products_btn) {
            icon = Products_icon;
            onTransactions();
        } else if (button == Suivie_btn) {
            icon = Suivie_icon;
            onSuivie();
        } else if (button == Suppliers_btn) {
            icon = Suppliers_icon;
            onAccounts();
        } else if (button == Employees_btn) {
            icon = Employees_icon;
            onEmployees();
        }else if (button == Charges_btn) {
            icon = Charges_Icon;
            onCharges();
        } else if (button == Ventes_btn) {
            icon = Ventes_icon;
            onVentes();
        } else if (button == profil_btn) {
            icon = profil_icon;
            onProfile();
        } else if (button == logout_btn) {
            icon = logou_icon;

        }
        if (icon != null) {
            icon.setEffect(new ColorAdjust(0, -1, -1, 0)); // Set image color to white
        }
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transaction");
    }

    private void onSuivie() {Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Suivie");
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Accounts");
    }
    private void onEmployees() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Employees");
    }
    private void onCharges() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Charges");
    }
    private void onVentes() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Ventes");
    }
    private void onProfile() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Profile");
    }


//    private void onLogout() {
//        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Logout");
//    }

    private void applyButtonEffects(Button button) {
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
        button.setOnMouseEntered(e -> {
            if (button != selectedButton) {
                button.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;");
                ImageView icon = null;

                switch (button.getId()) {
                    case "dashboard_btn":
                        icon = dashboard_icon;
                        break;
                    case "Products_btn":
                        icon = Products_icon;
                        break;
                    case "Suivie_btn;":
                        icon = Suivie_icon;
                        break;
                    case "Suppliers_btn":
                        icon = Suppliers_icon;
                        break;
                    case "Employees_btn":
                        icon = Employees_icon;
                        break;
                    case "Charges_btn":
                        icon = Charges_Icon;
                        break;
                    case "Ventes_btn":
                        icon = Ventes_icon;
                        break;
                    case "profil_btn":
                        icon = profil_icon;
                        break;
                    case "logout_btn":
                        icon = logou_icon;
                        break;
                    default:
                        // Handle the default case (if necessary)
                        break;
                }

                if (icon != null) {
                    icon.setEffect(new ColorAdjust(0, -1, -1, 0));
                }
            }
        });



        button.setOnMouseExited(e -> {
            if (button != selectedButton) {
                button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
                ImageView icon = null;

                if (button == dashboard_btn) {
                    icon = dashboard_icon;
                } else if (button == Products_btn) {
                    icon = Products_icon;
                } else if (button == Suivie_btn) {
                    icon = Suivie_icon;
                } else if (button == Suppliers_btn) {
                    icon = Suppliers_icon;
                } else if (button == Employees_btn) {
                    icon = Employees_icon;
                }else if (button == Charges_btn) {
                    icon = Charges_Icon;
                } else if (button == Ventes_btn) {
                    icon = Ventes_icon;
                }else if (button == profil_btn) {
                    icon = profil_icon;
                } else if (button == logout_btn) {
                    icon = logou_icon;
                }
                if (icon != null) {
                    icon.setEffect(null);
                }
            }
        });
    }





    @FXML

    public void logout(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "LOG OUT " + " ?", ButtonType.OK, ButtonType.CANCEL);
        alert.setTitle("Log out");
        alert.setContentText("Are you sure you want to log out?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.isPresent() && option.get() == ButtonType.OK) {
            System.out.println("You successfully logged out!");

            // Load the Login.fxml file and open it
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setScene(new Scene(root));
            loginStage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/19.png"))));
            loginStage.setTitle("FIRMTY");
            loginStage.show();

            // Close the current stage (the one with the logout button)
            ((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow()).close();

            // Add a window close request handler to confirm application exit
            loginStage.setOnCloseRequest(event -> {
                event.consume(); // Consume the event to prevent immediate closure
                showCloseProgramConfirmationDialog();
            });
        } else if (option.isPresent() && option.get() == ButtonType.CANCEL) {
            System.out.println("Cancelled!");
        } else {
            System.out.println("-");
        }
    }

    private void showCloseProgramConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit the program?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Confirm Exit");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                javafx.application.Platform.exit();
            }
        });
    }

}
