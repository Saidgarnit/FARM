package com.example.login.Controllers.Farmer;

import com.example.login.Models.Production;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    public Text login_date;
    @FXML
     Button idbuttadd,idbuttmodife,idbuttref,searchbtn;

    @FXML
    TextField idlabelnomrace,idlebelmetrage,idlebelqantite,idlebelqantitefinale,idlebelprix,idlebelorigine,idlebelnomfournisseur,idserch;
    @FXML
    DatePicker idlebeldateentre;
    @FXML
    ComboBox< String > idlebelnomemploye;
    @FXML
    TableView<Production> idtableview;
    @FXML
    TableColumn<Production, Integer> idrace =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomrace =new TableColumn<>();
    @FXML
    TableColumn<Production, Integer> idmetrage =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idqantite =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idqantitefinale =new TableColumn<>();
    @FXML
    TableColumn<Production, Float> idprix =new TableColumn<>();
    @FXML
    TableColumn<Production, LocalDate> iddateentre =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idorigine =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomemploye =new TableColumn<>();
    @FXML
    TableColumn <Production,String> idnomfournisseur =new TableColumn<>();



    //Database




    //pour faire un connecton avec code et database
    Connection con;

    //execution des commandes sql
    PreparedStatement stmt;

    //poure save les donne
    ResultSet rs;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/myprojectjavafx","root","");
        }catch (Exception e){
            System.out.println(e.toString());
        }




        idlebelnomemploye.getItems().addAll(
                "AHMED","DOHA","SAID","elmhjoub"
        );





        idrace.setCellValueFactory(new PropertyValueFactory<>("id"));
        idnomrace.setCellValueFactory(new PropertyValueFactory<>("Nom_de_race"));
        idmetrage.setCellValueFactory(new PropertyValueFactory<>("metrage"));
        idqantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        idqantitefinale.setCellValueFactory(new PropertyValueFactory<>("Qantite_Finale"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        iddateentre.setCellValueFactory(new PropertyValueFactory<>("Date_dentre"));
        idorigine.setCellValueFactory(new PropertyValueFactory<>("origine"));
        idnomemploye.setCellValueFactory(new PropertyValueFactory<>("Nom_de_lemploye"));
        idnomfournisseur.setCellValueFactory(new PropertyValueFactory<>("Nom_de_fournisseur"));


        getdata();
        getItem();




    }
    // ADD DATA
    @FXML
    void Add (){
        int T1= Integer.parseInt(idlebelmetrage.getText());
        Production TEST =new Production(
                T1,
                idlabelnomrace.getText(),
                idlebelqantite.getText(),
                idlebelqantitefinale.getText(),
                Double.parseDouble(idlebelprix.getText()),
                idlebeldateentre.getValue().toString() ,
                idlebelnomemploye.getSelectionModel().getSelectedItem(),
                idlebelnomfournisseur.getText(),
                idlebelorigine.getText());



            try {
                stmt = con.prepareStatement("INSERT INTO `production` (`metrage`, `Nom_de_race`, `Quantite`, `Qantite_Finale`, `Prix`, `Date_dentre` , `origine`,`Nom_de_lemploye`,`nom_de_fournisseur`) VALUES (?,?,?,?,?,?,?,?,?)");
                stmt.setInt(1,T1);
                stmt.setString(2,idlabelnomrace.getText());
                stmt.setString(3,idlebelqantite.getText());
                stmt.setString(4,idlebelqantitefinale.getText());
                stmt.setString(5,String.valueOf(Double.parseDouble(idlebelprix.getText())));
                stmt.setString(6,idlebeldateentre.getValue().toString() );
                stmt.setString(7,idlebelorigine.getText());
                stmt.setString(8,idlebelnomemploye.getSelectionModel().getSelectedItem());
                stmt.setString(9,idlebelnomfournisseur.getText());
                stmt.executeUpdate();

getdata();

            }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    Void getdata(){
        try{
            idtableview.getItems().clear();
            stmt=con.prepareStatement("SELECT * FROM `production`");
            rs= stmt.executeQuery();
            while (rs.next()){
                Production pro =new Production(
                        rs.getInt("id"),
                        rs.getInt("metrage"),
                        rs.getNString("Nom_de_race"),
                        rs.getString("Quantite"),
                        rs.getString("Qantite_Finale"),
                        rs.getDouble("Prix"),
                        rs.getString("Date_dentre"),
                        rs.getString("Nom_de_lemploye"),
                        rs.getString("nom_de_fournisseur"),
                        rs.getString("origine")

                        );
                idtableview.getItems().add(pro);
            }
            idtableview.refresh();
    }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    void getItem(){
        idtableview.setOnMouseClicked(event ->{
            idlebelmetrage.setText(String.valueOf(idtableview.getSelectionModel().getSelectedItem().getMetrage()));
            idlabelnomrace.setText(idtableview.getSelectionModel().getSelectedItem().getNom_de_race());
            idlebelqantite.setText(idtableview.getSelectionModel().getSelectedItem().getQuantite());
            idlebelqantitefinale.setText(idtableview.getSelectionModel().getSelectedItem().getQantite_Finale());
            idlebelprix.setText(idtableview.getSelectionModel().getSelectedItem().getPrix());
            idlebeldateentre.setValue(LocalDate.parse(idtableview.getSelectionModel().getSelectedItem().getDate_dentre()));
            idlebelorigine.setText(String.valueOf(idtableview.getSelectionModel().getSelectedItem().getOrigine()));
            idlebelnomemploye.setValue(idtableview.getSelectionModel().getSelectedItem().getNom_de_lemploye());
            idlebelnomfournisseur.setText(idtableview.getSelectionModel().getSelectedItem().getNom_de_fournisseur());


        });
    }
    @FXML
    void delet (ActionEvent event) {
        int id = idtableview.getSelectionModel().getSelectedItem().getId();
        try {
            stmt = con.prepareStatement("DELETE FROM production WHERE id='" + id + "'");
            stmt.executeUpdate();
            getdata();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

            @FXML
            void updat (ActionEvent event){
                try {
                    int T1 = Integer.parseInt(idlebelmetrage.getText());
                    int id = idtableview.getSelectionModel().getSelectedItem().getId();

                    stmt = con.prepareStatement("UPDATE `production` SET `metrage`=?, `Nom_de_race`=?, `Quantite`=?, `Qantite_Finale`=?, `Prix`=?, `Date_dentre`=?, `Nom_de_lemploye`=?, `Nom_de_fournisseur`=?, `origine`=? WHERE `id`=?");
                    stmt.setInt(1, T1);
                    stmt.setString(2, idlabelnomrace.getText());
                    stmt.setString(3, idlebelqantite.getText());
                    stmt.setString(4, idlebelqantitefinale.getText());
                    stmt.setDouble(5, Double.parseDouble(idlebelprix.getText()));
                    stmt.setString(6, idlebeldateentre.getValue().toString());
                    stmt.setString(7, idlebelnomemploye.getSelectionModel().getSelectedItem());
                    stmt.setString(8, idlebelnomfournisseur.getText());
                    stmt.setString(9, idlebelorigine.getText());
                    stmt.setInt(10, id);

                    stmt.executeUpdate();

                    getdata();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

    public void searche(ActionEvent actionEvent) {
  // System.out.println(this.idserch.getText());
      this.idtableview.getItems().clear();
        try{
            stmt=con.prepareStatement("select * from production where Nom_de_race LIKE '"+this.idserch.getText()+"%'");
            rs=stmt.executeQuery();

            while (rs.next()){
                Production proo =new Production(
                        rs.getInt("id"),
                        rs.getInt("metrage"),
                        rs.getNString("Nom_de_race"),
                        rs.getString("Quantite"),
                        rs.getString("Qantite_Finale"),
                        rs.getDouble("Prix"),
                        rs.getString("Date_dentre"),
                        rs.getString("origine"),
                        rs.getString("Nom_de_lemploye"),
                        rs.getString("nom_de_fournisseur"));

                this.idtableview.getItems().add(proo);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }



}




