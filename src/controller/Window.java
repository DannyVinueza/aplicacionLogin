package controller;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;




public class Window {

    @FXML
    private StackPane Area;


    @FXML
    void Calculator(MouseEvent event) throws IOException {
      Parent fxml = FXMLLoader.load(getClass().getResource("/assets/view/Calculator.fxml"));
      Area.getChildren().removeAll();
      Area.getChildren().setAll(fxml);
    }

    @FXML
    void Music(MouseEvent event) {

    }

    @FXML
    void Register(MouseEvent event) {

    }
    

}
