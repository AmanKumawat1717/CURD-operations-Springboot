package com.interview.sarvika.tecnologies.generic_crud_api.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class DatabaseInitializer {

	@Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @PostConstruct
    public void createDatabaseIfNotExists() {
        try {
            // Extract DB name and root URL
            String rootUrl = dbUrl.substring(0, dbUrl.lastIndexOf("/"));
            String dbName = dbUrl.substring(dbUrl.lastIndexOf("/") + 1);

            // Connect to MySQL server 
            try (Connection conn = DriverManager.getConnection(rootUrl, dbUsername, dbPassword);
                 Statement stmt = conn.createStatement()) {

                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
               
            }
        } catch (Exception e) {
            System.err.println("❌ Error while creating database: " + e.getMessage());
        }
    }
}
