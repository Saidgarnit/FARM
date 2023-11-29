package com.example.login.Controllers.Farmer;

import com.example.login.JBDC;
import com.example.login.SessionManager;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class DashboardController implements Initializable {

    @FXML
    private Label saving_nb1;
    @FXML
    private Text acc_username;
    @FXML
    private Label login_date;
    @FXML
    private Label fullname_lbl;
    @FXML
    private Label saving_bal;
    @FXML
    private Label emp_lbl;
    @FXML
    private Label Vaccination_lbl;
    @FXML
    private Label Production_lbl;
    @FXML
    private ImageView productions_img;
    @FXML
    private Label saving_bal1;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;

    private final int ANIMATION_DURATION = 5000; // milliseconds

    private static DashboardController instance;
    private int currentEmpValue;


    public static void setInstance(Object instance) {
        DashboardController.instance = (DashboardController) instance;
    }

    public static DashboardController getInstance() {
        return instance;
    }
    // Method to update the displayed full_name in the dashboard
    public void updateFullName(String newFullName) {
        fullname_lbl.setText("HI " + newFullName + "!");
        System.out.println("Updated full name displayed in the dashboard: " + newFullName);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        try (Connection connection = JBDC.connect()) {
            String loggedInAdminEmail = SessionManager.getInstance().getLoggedInAdminEmail();

            if (loggedInAdminEmail != null) {
                String query = "SELECT full_name FROM admin WHERE email = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, loggedInAdminEmail);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String adminFullName = resultSet.getString("full_name");
                            fullname_lbl.setText("HI " + adminFullName + "!");
                            System.out.println("Full name fetched and set successfully: " + adminFullName);
                        } else {
                            handleAdminNotFound();
                        }
                    }
                }
            } else {
                fullname_lbl.setText("No Admin Logged In");
            }

            // Fetch and set the admin's age in the labels with rolling numbers counter effect
            fetchAndSetAge(emp_lbl, 25, 200,5000);  // Replace '25' with the actual admin's age
            fetchAndSetAge(Vaccination_lbl, 30, 200,5000);  // Replace '30' with the actual admin's age
            fetchAndSetAge(Production_lbl, 35, 200,5000);  // Replace '35' with the actual admin's age

            configurePieChart();
            configureBarChart();

            setLoginDate();

        } catch (SQLException e) {
            handleDatabaseError(e);
        }
    }

    // Method to fetch and set age with a rolling numbers counter effect
    private void fetchAndSetAge(Label label, int age, int target, long durationMillis) {
        currentEmpValue = age;
        label.setText("0"); // Initialize the label to 0
        animateCounter(label, currentEmpValue, durationMillis,target); // Animate to the actual age
    }
    // Method to create a rolling numbers counter animation from current value to target value
    private void animateCounter(Label label, int current, long durationMillis, int target) {
        AtomicInteger currentValue = new AtomicInteger(current);
        long startTime = System.nanoTime() / 1_000_000; // Current time in milliseconds

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedMillis = now / 1_000_000 - startTime;

                if (elapsedMillis > durationMillis) {
                    label.setText(Integer.toString(target));
                    stop(); // Stop the animation when it reaches the target value
                } else {
                    int value = current + (int) (elapsedMillis * (target - current) / durationMillis);
                    currentValue.set(value);
                    label.setText(Integer.toString(value));
                }
            }
        };

        timer.start();
    }

    private void handleAdminNotFound() {
        System.err.println("Admin not found in the database");
        fullname_lbl.setText("Admin Not Found");
    }

    private void fetchAndSetAge(Label label, int age) {
        label.setText("0");
        animateCounter(label, age, ANIMATION_DURATION);
    }

    private void animateCounter(Label label, int current, long durationMillis) {
        AtomicInteger currentValue = new AtomicInteger(current);
        long startTime = System.nanoTime() / 1_000_000;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedMillis = now / 1_000_000 - startTime;

                if (elapsedMillis > durationMillis) {
                    label.setText(Integer.toString(currentValue.get()));
                    stop();
                } else {
                    int value = current + (int) (elapsedMillis * (currentValue.get() - current) / durationMillis);
                    currentValue.set(value);
                    label.setText(Integer.toString(value));
                }
            }
        };

        timer.start();
    }

    private void configurePieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Category 1", 30),
                new PieChart.Data("Category 2", 40),
                new PieChart.Data("Category 3", 20),
                new PieChart.Data("Category 4", 10)
        );

        pieChart.setData(pieChartData);
    }

    private void configureBarChart() {
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Ventes");

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Charges");

        series1.getData().addAll(
                new XYChart.Data<>("November", 10),
                new XYChart.Data<>("December", 20),
                new XYChart.Data<>("January", 15),
                new XYChart.Data<>("February", 25)
        );

        series2.getData().addAll(
                new XYChart.Data<>("November", 15),
                new XYChart.Data<>("December", 10),
                new XYChart.Data<>("January", 30),
                new XYChart.Data<>("February", 5)
        );

        barChart.getData().addAll(series1, series2);
    }

    private void setLoginDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        login_date.setText("Today: " + formattedDate);
    }

    private void handleDatabaseError(SQLException e) {
        e.printStackTrace();
        System.err.println("Error connecting to the database: " + e.getMessage());
        fullname_lbl.setText("Database Error");
    }
}
