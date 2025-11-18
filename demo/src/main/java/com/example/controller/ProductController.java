package com.example.controller;

import com.example.ConnectDB;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProductController {

    // Top search section
    @FXML
    private TextField search;

    // Left-side menu buttons
    @FXML
    private Button homeBack;

    @FXML
    private Button supplier;

    @FXML
    private Button sitting;

    @FXML
    private Button logout;

    @FXML
    private Button category;

    // Product action buttons
    @FXML
    private Button addProduct;

    @FXML
    private Button editProduct;

    @FXML
    private Button deleteProduct;

    // Product table
    @FXML
    private TableView<Product> productTable;
    // ========== BUTTON ACTION METHODS ==========
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        ConnectDB db = new ConnectDB();
        productTable.setItems(db.initDB());
    }
    @FXML
    public void clickHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hello-view.fxml"));
            Parent root = loader.load();

            // Load target controller if needed
            HomeController homeController = loader.getController();
            homeController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSupplierClick() {
        System.out.println("Supplier clicked");
        // Navigate to supplier section
    }

    @FXML
    public void onCategoryClick() {
        System.out.println("Category clicked");
        // Navigate to category section
    }

    @FXML
    public void onSettingClick() {
        System.out.println("Setting clicked");
        // Navigate to setting panel
    }

    @FXML
    public void onLogoutClick() {
        System.out.println("Logout clicked");
        // Logout logic
    }

    @FXML
    public void onAddProductClick() {
        System.out.println("Add Product button clicked");
        // Show add product form or open popup
    }

    @FXML
    public void onEditProductClick() {
        System.out.println("Edit Product button clicked");
        // Logic to edit selected product
    }

    @FXML
    public void onDeleteProductClick() {
        System.out.println("Delete Product button clicked");
        // Logic to delete selected product
    }

    @FXML
    public void onSearchClick() {
        String keyword = search.getText();
        System.out.println("Search for: " + keyword);
        // Implement search logic
    }
}
