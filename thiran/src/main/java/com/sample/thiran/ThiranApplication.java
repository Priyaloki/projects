package com.sample.thiran;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;

@SpringBootApplication
public class ThiranApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThiranApplication.class, args);

        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/retail_management";
        String username = "root";
        String password = "Priyalokesh2!";

        // Try-with-resources to automatically close the connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                // You can perform database operations here
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }

	}

}
