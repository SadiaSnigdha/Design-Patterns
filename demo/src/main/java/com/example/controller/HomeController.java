package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController implements Controller {
  
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public String getTitle() {
        return "Product Management : Home";
    }
    @FXML
    protected void onLoginClick() throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login.fxml"));
            Parent root = loader.load();

            LoginController loginController = loader.getController();

            loginController.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            System.out.println("Login Error");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onShowProdClick() throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ProductMenu.fxml"));
            Parent root = loader.load();

            ProductController loginController = loader.getController();

            loginController.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            System.out.println("prod menu page Error");
            e.printStackTrace();
        }
    }

}