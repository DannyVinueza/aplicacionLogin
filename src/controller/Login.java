package controller;

import javafx.event.Event;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Login {
    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private Label Error;
    


    @FXML
    void Singin(ActionEvent event) {

       if(Username.getText().isBlank() == false && Password.getText().isBlank() == false){
           if(Username.getText().equals("David") && Password.getText().equals("123")){
                loadStage(event);
           }
            else{
                Error.setText("Password o User are incorrect");
            }
        
           
       }
       else{
        Error.setText("Password o User is blank");
       }
        
    }
   


    private void loadStage (Event event) {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            // Object eventSource = event.getSource();
            // Node sourceAsNode = (Node) eventSource;
            // Scene oldScene = sourceAsNode.getScene();
            // javafx.stage.Window window = oldScene.getWindow();
            // Stage stage = (Stage) window;
            // stage.hide();

            Parent root = FXMLLoader.load(getClass().getResource("/assets/view/Dashboard.fxml"));
            Scene scene = new Scene((root));
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

            // newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            //     @Override
            //     public void handle(WindowEvent event) {
            //         Platform.exit();
            //     }
            // });

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    
}
