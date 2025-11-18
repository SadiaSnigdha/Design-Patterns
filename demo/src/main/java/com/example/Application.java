package com.example;

import com.example.controller.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException; 

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());

        HomeController homeController = loader.getController();
        homeController.setStage(stage);

        stage.setTitle(homeController.getTitle());
        stage.setScene(scene);
        stage.setWidth(720);
        stage.setHeight(546);
        stage.setResizable(false);
        stage.show();
    } 
    public static void main(String[] args) {
        launch();
    }
}