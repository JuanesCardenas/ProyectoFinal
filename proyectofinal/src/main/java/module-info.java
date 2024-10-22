module com.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires javafx.graphics;

    opens com.proyectofinal.controlador to javafx.fxml;
    opens com.proyectofinal to javafx.fxml;
    exports com.proyectofinal;
}
