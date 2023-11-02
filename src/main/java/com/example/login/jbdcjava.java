package com.example.login;

import java.sql.*;


public class jbdcjava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/myprojectjavafx"; //url for connection; here student is our database
        String uname = "root";
        String pass = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
            System.out.println("HELLO WORLD");
        st.close();
        con.close();
    }
}