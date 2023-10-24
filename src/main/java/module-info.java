module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;



//    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    //requires org.serial.sqlitejbdc ;

    opens com.example.login  to javafx.fxml;
    opens com.example.login.Controllers.Client to javafx.fxml;
    exports com.example.login.Controllers;
    exports com.example.login;
    exports com.example.login.Controllers.Admin;
    exports com.example.login.Controllers.Client;
    exports com.example.login.Models;
    exports com.example.login.Views;





}