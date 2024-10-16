package com.proyectofinal.modelo;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class AdministradorLogger {

    private FileHandler archivo;
    // Inicialización del logger
    public void inicializarLogger() throws IOException {
        
        try {
            archivo = new FileHandler("logClubDeportivo.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            archivo.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // Escribir un log en el archivo
    public void escribirLog(Class<?> clase, String mensaje, Level nivel) {
        Logger logger = Logger.getLogger(clase.getName());  // Crear logger por clase

        // Asociar el FileHandler al logger si no se ha hecho antes
        if (logger.getHandlers().length == 0) {
            logger.addHandler(archivo);
        }

        logger.log(nivel, mensaje);
    }
}
