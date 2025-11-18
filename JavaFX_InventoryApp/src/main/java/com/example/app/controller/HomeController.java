package com.example.app.controller;

import com.example.app.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML private Button addProductBtn;
    private User loggedInUser;

    public void setUser(User user) {
        this.loggedInUser = user;
        if (!"admin".equals(user.getRole())) {
            addProductBtn.setDisable(true);
        }
    }

    @FXML
    public void openAddProduct() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/view/add_product.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Add Product");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
