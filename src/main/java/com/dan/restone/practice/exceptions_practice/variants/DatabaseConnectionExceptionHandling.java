package com.dan.restone.practice.exceptions_practice.variants;

import java.sql.*;

public class DatabaseConnectionExceptionHandling {

    public static void main(String[] args) {

        String databaseUrl = "jdbc:postgresql://localhost:5432/db_it_school";
        String user = "dev";
        String pw = "cow";

        try(Connection dbConnection = DriverManager.getConnection(databaseUrl, user, pw)){
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        } catch (SQLException e){
            System.out.println("SQL problems");
        }
    }
}
