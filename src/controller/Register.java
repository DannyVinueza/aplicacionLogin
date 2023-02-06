/**
 * It's a controller class for a JavaFX application
 */
package controller;


import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleGroup;


public class Register{
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfTelefono;
    @FXML
    private CheckBox chHombre;
    @FXML
    private CheckBox chMujer;
    @FXML
    private ComboBox<String> cbOpcion;
    @FXML
    private ListView<String> lvContactos;
    @FXML
    private ImageView ivLogo;
    @FXML 
    private Button bGuardar;
    @FXML
    private Spinner<Integer> sEdad;
    private List<String> contactos;
    private ToggleGroup sexo;

    @FXML
    public void initialize(){
        contactos = FXCollections.observableArrayList();
        lvContactos.setItems(FXCollections.observableArrayList(contactos));
        cbOpcion.setItems(FXCollections.observableArrayList("Nuevo", "Eliminar"));
        sEdad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 40, 1));
        
        /*sexo = new ToggleGroup();
        chHombre.setToggleGroup(sexo);
        chMujer.setToggleGroup(sexo);*/
    }
   
    @FXML
    private void guardar(ActionEvent event){
        if (cbOpcion.getValue().equals("Nuevo")) {
            String nombre = tfNombre.getText();
            String apellido = tfApellido.getText();
            String telefono = tfTelefono.getText();
            int edad = sEdad.getValue();
            String sexo = "";
            if (chHombre.isSelected()) {
                sexo = "Hombre";
            } else if (chMujer.isSelected()) {
                sexo = "Mujer";
            }
            contactos.add(nombre + " - " + apellido + " - " + telefono + " - " + edad + " - " + sexo);
            //lvContactos.getItems().add(nombre + " - " + apellido + " - " + telefono + " - " + edad + " - " + sexo);
            lvContactos.setItems(FXCollections.observableArrayList(contactos));
            tfNombre.clear();
            tfApellido.clear();
            tfTelefono.clear();
            chHombre.setSelected(false);
            chMujer.setSelected(false);
        } else if (cbOpcion.getValue().equals("Eliminar")) {
            int index = lvContactos.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                contactos.remove(index);
                int selectedID = lvContactos.getSelectionModel().getSelectedIndex();
                lvContactos.getItems().remove(selectedID);
            }
            
        }
    }
}
