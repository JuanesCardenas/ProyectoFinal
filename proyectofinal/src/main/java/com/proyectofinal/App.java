package com.proyectofinal;

import com.proyectofinal.modelo.AdministradorArchivo;
import com.proyectofinal.modelo.AdministradorPersistencia;
import com.proyectofinal.modelo.AdministradorPropiedades;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        // Inicializa el Stage en el manejador de escenas
        ManejadorEscenas.inicializar(stage);
        AdministradorPropiedades propiedades = new AdministradorPropiedades();
        AdministradorArchivo.crearEstructuraCarpetas(propiedades);
        AdministradorPersistencia.realizarRespaldoCompleto();
        
        // Cambia a la escena de login
        ManejadorEscenas.cambiarEscena("login");
        
        // Muestra el escenario
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}