package com.example.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Classe de TEST VOLONTAIREMENT VULNERABLE (injection SQL)
 * pour verifier que SonarCloud la detecte. A SUPPRIMER apres le test.
 */
@RestController
public class TestInjectionController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    // Cas 1 : injection SQL via JdbcTemplate (concatenation de l'entree utilisateur)
    // Exploit : /test/employes?name=' OR '1'='1
    @GetMapping("/test/employes")
    public List<Map<String, Object>> rechercherParNom(@RequestParam String name) {
        String sql = "SELECT * FROM employe WHERE name = '" + name + "'";
        return jdbcTemplate.queryForList(sql);
    }

    // Cas 2 : injection SQL via JDBC Statement brut
    // Exploit : /test/employes/age?age=0 OR 1=1
    @GetMapping("/test/employes/age")
    public List<String> rechercherParAge(@RequestParam String age) throws SQLException {
        List<String> noms = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT name FROM employe WHERE age = " + age)) {
            while (rs.next()) {
                noms.add(rs.getString("name"));
            }
        }
        return noms;
    }
}
