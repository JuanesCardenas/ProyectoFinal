package com.proyectofinal;

import java.io.IOException;
import java.util.logging.Level;

import com.proyectofinal.modelo.AdministradorLogger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManejadorEscenas {

    private static Stage primaryStage;

    public static void inicializar(@SuppressWarnings("exports") Stage stage) {
        if (primaryStage == null) {
            primaryStage = stage;
        } else {
            AdministradorLogger.getInstance().escribirLog(ManejadorEscenas.class, "Stage ya ha sido inicializado.", Level.WARNING);
            throw new IllegalStateException("Stage ya ha sido inicializado.");
        }
    }

    public static void cambiarEscena(String fxml) throws IOException {
        if (primaryStage == null) {
            AdministradorLogger.getInstance().escribirLog(ManejadorEscenas.class, "Stage no ha sido inicializado.", Level.WARNING);
            throw new IllegalStateException("Stage no ha sido inicializado.");
        }

        FXMLLoader loader = new FXMLLoader(ManejadorEscenas.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        primaryStage.setScene(newScene);

        // Como la ventana del perfil del vendor es muy amplia, esta condición aplica a esa ventana para recortarla.
        if(fxml == "perfilVendedor"){
            primaryStage.setWidth(800);
            primaryStage.setHeight(600);
        }
        primaryStage.show();
    }
}
