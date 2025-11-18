package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

public class LoginController implements Controller{
    private Stage stage;
    @FXML
    private TextField username = new TextField();
    @FXML
    private PasswordField password = new PasswordField();

    @Override
    public String getTitle() {
        return "Product Management : Login";
    }

    public Stage setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle(getTitle());
        return stage;
    }

    private String getUsername() {
        return username.getText();
    }
    private String getPassword() {
        return password.getText();
    }
    private void handleLogin() throws Exception{
        System.out.println(getUsername());
        System.out.println(hashedPassword(getPassword()));
    }
    private String hashedPassword(String password) {
        String fixedSalt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, fixedSalt);
        return hashedPassword;
    }
    @FXML
    protected void clickLogin() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ProductMenu.fxml"));
        Parent root = loader.load();
        ProductController productMenu = loader.getController();
        productMenu.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void backHome() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hello-view.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();
        homeController.setStage(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        stage.show();
    }

}
