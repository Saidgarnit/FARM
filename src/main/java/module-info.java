module com.example.login {
    requires javafx.controls;



    requires javafx.fxml;
//    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires mysql.connector.j;
    //requires org.serial.sqlitejbdc ;

    opens com.example.login  to javafx.fxml;
    opens com.example.login.Controllers.Farmer to javafx.fxml;
    exports com.example.login.Controllers;
    exports com.example.login;

    exports com.example.login.Controllers.Farmer;
    exports com.example.login.Models;
    exports com.example.login.Views;
    opens com.example.login.Controllers;




}