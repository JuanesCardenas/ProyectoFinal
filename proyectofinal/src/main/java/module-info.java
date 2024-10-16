module com.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens com.proyectofinal to javafx.fxml;
    exports com.proyectofinal;
}
