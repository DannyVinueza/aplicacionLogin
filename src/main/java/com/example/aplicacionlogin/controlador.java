package com.example.aplicacionlogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class controlador {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}