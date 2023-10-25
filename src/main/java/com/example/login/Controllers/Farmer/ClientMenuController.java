package com.example.login.Controllers.Farmer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.login.Models.Model;

public class ClientMenuController implements Initializable {

    @FXML
    private Button dashboard_btn;
    @FXML
    private Button Products_btn;
    @FXML
    private Button Suppliers_btn;
    @FXML
    private Button Employees_btn;
    @FXML
    private Button report_btn;
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
                Suppliers_btn,
                Employees_btn,
                profil_btn,
                logout_btn,
                report_btn
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
            } else if (selectedButton == Suppliers_btn) {
                icon = Suppliers_icon;
            } else if (selectedButton == Employees_btn) {
                icon = Employees_icon;
            } else if (selectedButton == profil_btn) {
                icon = profil_icon;
            } else if (selectedButton == logout_btn) {
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
        } else if (button == Suppliers_btn) {
            icon = Suppliers_icon;
            onAccounts();
        } else if (button == Employees_btn) {
            icon = Employees_icon;
        } else if (button == profil_btn) {
            icon = profil_icon;
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

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Accounts");
    }

    private void applyButtonEffects(Button button) {
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");
        button.setOnMouseEntered(e -> {
            if (button != selectedButton) {
                button.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;");
                ImageView icon = null;

                if (button == dashboard_btn) {
                    icon = dashboard_icon;
                } else if (button == Products_btn) {
                    icon = Products_icon;
                } else if (button == Suppliers_btn) {
                    icon = Suppliers_icon;
                } else if (button == Employees_btn) {
                    icon = Employees_icon;
                } else if (button == profil_btn) {
                    icon = profil_icon;
                } else if (button == logout_btn) {
                    icon = logou_icon;
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
                } else if (button == Suppliers_btn) {
                    icon = Suppliers_icon;
                } else if (button == Employees_btn) {
                    icon = Employees_icon;
                } else if (button == profil_btn) {
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
}
