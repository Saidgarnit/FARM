package com.example.login.Controllers.Farmer;
import com.example.login.Models.Production;
import com.example.login.Models.Suivi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SuivieController implements Initializable {
    @FXML
    private ComboBox<String> laybelemploiye,lebaltout,label3;
    @FXML
    private TableView<Suivi> tabltou;
    @FXML
    private TableColumn<Suivi, Integer> id;
    @FXML
    private TableColumn<Suivi,String> idQuantite;
    @FXML
    private TableColumn<Suivi, String> idQuantitemodifieparjours;
    @FXML
    private TableColumn<Suivi, String> idage;
    @FXML
    private TableColumn<Suivi, String> iddate;
    @FXML
    private TableColumn<Suivi, String> idnom_de_race;
    @FXML
    private TableColumn<Suivi, String> idconsomation;

    @FXML
    private DatePicker labeldate;

    @FXML
    private TextField qquantite_field;

    @FXML
    private TextField consomation_field;
    @FXML
    private TableColumn<Suivi, String> idemploiye;


    XYChart.Series set2=new XYChart.Series<>();

    HashMap<String,Integer> linechatinfo=new HashMap<>();


    //-------------------- linechart
    @FXML
    private CategoryAxis X;
    @FXML
    private NumberAxis Y;

    @FXML
    private LineChart<?, ?> LineChart;


    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/myprojectjavafx","root","");
        }catch (Exception e){
            System.out.println(e.toString());
        }

        this.laybelemploiye.setOnAction( event -> {
            String test= this.laybelemploiye.getSelectionModel().getSelectedItem();
            this.lebaltout.getItems().clear();
            System.out.println(test);
            this.chek(test);

        });

        insertintolinechart();
        linechartinformation();


        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        idQuantitemodifieparjours.setCellValueFactory(new PropertyValueFactory<>("quantite_par_jour"));
        iddate.setCellValueFactory(new PropertyValueFactory<>("date_mise_a_jour"));
        idconsomation.setCellValueFactory(new PropertyValueFactory<>("consomation"));
        idemploiye.setCellValueFactory(new PropertyValueFactory<>("emploiyee"));

        trouve();
        chekemplo();
        getData();



    }
    void chekemplo(){
        try {
            stmt = con.prepareStatement("SELECT distinct Nom_de_lemploye FROM Production");
            rs=stmt.executeQuery();
            while (rs.next()){
                String Nom_de_lemploye=rs.getString("Nom_de_lemploye");
                laybelemploiye.getItems().add(Nom_de_lemploye);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }

    void chek(String mtr){
        try {
            stmt = con.prepareStatement("SELECT id FROM Production where Nom_de_lemploye ='"+mtr+"'");
            rs=stmt.executeQuery();
            while (rs.next()){
                String metrage=rs.getString("id");
                lebaltout.getItems().add(metrage);
                System.out.println(rs.getString("id"));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }


    }

    @FXML
    void Ajouter(){
        try {
            stmt = con.prepareStatement("INSERT INTO `suivi_production` (`quantite_par_jour`, `consomation`, `date`,emploiyee) VALUES (?,?,?,?)");
            stmt.setString(1,qquantite_field.getText());
            stmt.setString(2,consomation_field.getText());
            stmt.setString(3,labeldate.getValue().toString());
            stmt.setString(4,laybelemploiye.getSelectionModel().getSelectedItem());
            stmt.executeUpdate();
            getData();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        insertintolinechart();
        linechartinformation();
    }

    @FXML
    void getData(){

        try {
            tabltou.getItems().clear();
            stmt = con.prepareStatement("SELECT * from suivi_production;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Assuming you have a ProductionData class to represent the data
                Suivi  data = new Suivi (
                        rs.getInt("id"),
                        rs.getString("quantite_par_jour"),
                        rs.getString("date"),
                        rs.getString("consomation"),
                        rs.getString("emploiyee")
                );
                tabltou.getItems().add(data);
            }
            rs.close();
            stmt.close();

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    void trouve(){
        getData();
        try {
            stmt = con.prepareStatement("SELECT distinct emploiyee FROM suivi_production");
            rs=stmt.executeQuery();
            while (rs.next()){
                String emploiyee=rs.getString("emploiyee");
                label3.getItems().add(emploiyee);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void recherche(){
        String emp = label3.getSelectionModel().getSelectedItem();
        try {
            tabltou.getItems().clear();
            stmt = con.prepareStatement("SELECT * FROM suivi_production where emploiyee = ?");
            stmt.setString(1, emp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Suivi  data = new Suivi (
                        rs.getInt("id"),
                        rs.getString("quantite_par_jour"),
                        rs.getString("date"),
                        rs.getString("consomation"),
                        rs.getString("emploiyee")
                );
                tabltou.getItems().add(data);
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }



    }



    void insertintolinechart(){

        try{
            stmt=con.prepareStatement("SELECT sum(quantite_par_jour),date FROM `suivi_production` group by date");
            rs=stmt.executeQuery();

            while (rs.next()){
                linechatinfo.put(rs.getString("date"),rs.getInt("sum(quantite_par_jour)"));
            }
        }catch (Exception e){

        }


    }

    void linechartinformation(){

        this.linechatinfo.forEach((k,v) -> {
            this.set2.getData().add(new XYChart.Data(k,v));
        });

        this.LineChart.getData().addAll(this.set2);
    }












    }
