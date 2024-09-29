module com.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyectofinal to javafx.fxml;
    exports com.proyectofinal;
}
