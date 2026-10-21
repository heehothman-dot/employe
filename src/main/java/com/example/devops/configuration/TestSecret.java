package com.example.devops.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestSecret {


    // password = "CommentaireSecret2026"


    private static final String PASSWORD = "Admin@1234";


    public Connection connexion() throws SQLException {
        String password = "MotDePasseSecret123";
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedemo", "root", password);
    }

    public String getPassword() {
        return PASSWORD;
    }
}
