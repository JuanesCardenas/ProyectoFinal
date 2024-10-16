package com.proyectofinal.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdministradorPropiedades {

    private Properties propiedades;

    public AdministradorPropiedades(String rutaArchivo) {
        propiedades = new Properties();
        try {
            propiedades.load(new FileInputStream(rutaArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRuta(String key) {
        return propiedades.getProperty(key);
    }
}
