package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.controller.Product;
import javafx.collections.ObservableList;

public class ConnectDB {
    private static Statement statement;
    private static Connection connection;
    ObservableList<Product> products = javafx.collections.FXCollections.observableArrayList();

    public ObservableList<Product> initDB() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data.db");
            statement = connection.createStatement();

            String sqlQuery = "select * from products";
            ResultSet rs = statement.executeQuery(sqlQuery);
            products.clear();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
                products.add(p);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
}
