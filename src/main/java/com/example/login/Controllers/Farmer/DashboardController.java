package com.example.login.Controllers.Farmer;

import com.example.login.JbdcJava;
import com.example.login.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import java.util.concurrent.atomic.AtomicInteger;
public class DashboardController implements Initializable {

    public Label saving_nb1;
    public Text acc_username;
    public Label login_date;
    public Label fullname_lbl;
    
    public Label saving_bal;
    
    public Label emp_lbl;
    public Label Vaccination_lbl;
    public Label Production_lbl;
    public ImageView productions_img;
    public Label saving_bal1;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;

    private int currentEmpValue = 0; // You need to initialize the current values
    private int currentVaccinationValue = 0;
    private int currentProductionValue = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Establish a database connection using the JbdcJava class
        Connection connection = JbdcJava.connect();

        // Fetch the admin's email from the SessionManager
        String loggedInAdminEmail = SessionManager.getInstance().getLoggedInAdminEmail();

        if (loggedInAdminEmail != null) {
            String query = "SELECT full_name FROM admin WHERE email = ?";
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, loggedInAdminEmail);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String adminFullName = resultSet.getString("full_name");
                    // Set the full name in the label
                    fullname_lbl.setText("HI"+" "+adminFullName+"!");
                } else {
                    // Handle the case where the admin is not found
                    fullname_lbl.setText("Admin Not Found");
                }

                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any database-related errors here
                fullname_lbl.setText("Database Error");
            }
        } else {
            // Handle the case where no admin is logged in
            fullname_lbl.setText("No Admin Logged In");
        }


        // Fetch and set the admin's age in the labels with rolling numbers counter effect
        fetchAndSetAge(emp_lbl, 25, 200,5000);  // Replace '25' with the actual admin's age
        fetchAndSetAge(Vaccination_lbl, 30, 200,5000);  // Replace '30' with the actual admin's age
        fetchAndSetAge(Production_lbl, 35, 200,5000);  // Replace '35' with the actual admin's age


       


        // Close the database connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related errors here
        }
        // Create sample data for the PieChart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Category 1", 30),
                new PieChart.Data("Category 2", 40),
                new PieChart.Data("Category 3", 20),
                new PieChart.Data("Category 4", 10)
        );

        // Add the data to the PieChart
        pieChart.setData(pieChartData);

        // Create axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the BarChart
        // No need to create a new BarChart instance
        // Use the one defined in your FXML
        // barChart = new BarChart<>(xAxis, yAxis);

        // Create two series
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Ventes");

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Charges");

        // Add data to the series
        series1.getData().add(new XYChart.Data<>("November", 10));
        series1.getData().add(new XYChart.Data<>("December", 20));
        series1.getData().add(new XYChart.Data<>("January", 15));
        series1.getData().add(new XYChart.Data<>("February", 25));

        series2.getData().add(new XYChart.Data<>("November", 15));
        series2.getData().add(new XYChart.Data<>("December", 10));
        series2.getData().add(new XYChart.Data<>("January", 30));
        series2.getData().add(new XYChart.Data<>("February", 5));

        // Add the series to the BarChart
        barChart.getData().addAll(series1, series2);

        // Set the current date to the login_date Label
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        login_date.setText("Today: " + formattedDate);
    }

    // Method to fetch and set age with a rolling numbers counter effect
    private void fetchAndSetAge(Label label, int age, int target, long durationMillis) {
        currentEmpValue = age;
        label.setText("0"); // Initialize the label to 0
        animateCounter(label, currentEmpValue, durationMillis,target); // Animate to the actual age
    }

    // Method to create a rolling numbers counter animation from current value to target value
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




}