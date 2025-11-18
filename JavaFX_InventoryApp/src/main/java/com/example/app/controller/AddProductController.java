package com.example.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddProductController {
    @FXML private TextField productId, productName, productCategory, price, quantity;

    @FXML
    public void handleAddProduct() {
        System.out.println("Product Added: " + productName.getText());
    }
}
