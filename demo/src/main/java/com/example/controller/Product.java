package com.example.controller;

import javafx.beans.property.*;

public class Product {
    public IntegerProperty id;
    public StringProperty name;
    public StringProperty category;
    public DoubleProperty price;
    public IntegerProperty quantity;

    public Product(int id, String name, String category, Double price,
            int quantity) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    // Getters for properties (e.g., getId(), getName())
    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getCategory() {
        return category.get();
    }

    public double getPrice() {
        return price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }
}

