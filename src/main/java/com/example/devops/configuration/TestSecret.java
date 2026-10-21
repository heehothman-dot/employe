package com.example.devops.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de TEST pour verifier que SonarCloud detecte les mots de passe en dur.
 * A SUPPRIMER apres le test.
 */
public class TestSecret {

    // Cas 1 : mot de passe dans un COMMENTAIRE
    // password = "CommentaireSecret2026"

    // Cas 2 : mot de passe en dur dans une constante
    private static final String PASSWORD = "Admin@1234";

    // Cas 3 : mot de passe en dur dans une variable locale
    public Connection connexion() throws SQLException {
        String password = "MotDePasseSecret123";
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedemo", "root", password);
    }

    public String getPassword() {
        return PASSWORD;
    }
}
