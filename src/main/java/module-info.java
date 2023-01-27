module com.example.aplicacionlogin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aplicacionlogin to javafx.fxml;
    exports com.example.aplicacionlogin;
}