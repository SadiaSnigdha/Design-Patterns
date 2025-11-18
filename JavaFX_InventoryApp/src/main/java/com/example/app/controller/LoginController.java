package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.util.HashUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private static final HashMap<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", HashUtil.hashPassword("admin123"), "admin"));
        users.put("employee", new User("employee", HashUtil.hashPassword("emp123"), "employee"));
    }

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = users.get(username);
        if (user != null && HashUtil.checkPassword(password, user.getPasswordHash())) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/view/home.fxml"));
                Scene scene = new Scene(loader.load());
                HomeController controller = loader.getController();
                controller.setUser(user);
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Invalid credentials");
        }
    }
}
