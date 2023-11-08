package com.example.login.Controllers.Farmer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Label saving_nb1;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        series1.setName("Element 1");

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Element 2");

        // Add data to the series
        series1.getData().add(new XYChart.Data<>("Category 1", 10));
        series1.getData().add(new XYChart.Data<>("Category 2", 20));
        series1.getData().add(new XYChart.Data<>("Category 3", 15));
        series1.getData().add(new XYChart.Data<>("Category 4", 25));

        series2.getData().add(new XYChart.Data<>("Category 1", 15));
        series2.getData().add(new XYChart.Data<>("Category 2", 10));
        series2.getData().add(new XYChart.Data<>("Category 3", 30));
        series2.getData().add(new XYChart.Data<>("Category 4", 5));

        // Add the series to the BarChart
        barChart.getData().addAll(series1, series2);
    }


    // Other controller methods
}