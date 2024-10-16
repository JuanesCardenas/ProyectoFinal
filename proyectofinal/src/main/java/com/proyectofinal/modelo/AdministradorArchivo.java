package com.proyectofinal.modelo;

import java.io.File;

public class AdministradorArchivo {

    public static void crearEstructuraCarpetas() {
        AdministradorPropiedades propiedades = new AdministradorPropiedades("Config.properties");
        try {

            // Obtener las rutas desde config.properties
            String persistenciaPath = propiedades.getRuta("persistencia.directory");
            String respaldoPath = propiedades.getRuta("respaldo.directory");
            String archivosPath = propiedades.getRuta("archivos.directory");
            String logPath = propiedades.getRuta("log.directory");

            // Crear carpetas 
            new File(persistenciaPath).mkdirs();
            new File(respaldoPath).mkdirs();
            new File(archivosPath).mkdirs();
            new File(logPath).mkdirs();

            // Registrar en el log que la estructura de carpetas ha sido creada
            AdministradorLogger logger = new AdministradorLogger();
            logger.inicializarLogger();  // Asegúrate de inicializar el logger antes de usarlo
            logger.escribirLog(AdministradorArchivo.class, "Estructura de carpetas creada.", java.util.logging.Level.INFO);
            
        } catch (Exception e) {
            e.printStackTrace();  // O manejar el error con un log o alerta de GUI
        }
    }
}

