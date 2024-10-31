package com.proyectofinal.modelo;

import java.io.IOException;

public class HiloSerializador implements Runnable{

    private Object objeto;
    private String nombreArchivo;
    private String tipoSerializacion;
    private boolean esSerializar; // true para serializar, false para deserializar

    public HiloSerializador(Object objeto, String nombreArchivo, String tipoSerializacion, boolean esSerializar) {
        this.objeto = objeto;
        this.nombreArchivo = nombreArchivo;
        this.tipoSerializacion = tipoSerializacion;
        this.esSerializar = esSerializar;
    }

    @Override
    public void run() {
        try {
            if (esSerializar) {
                if ("xml".equalsIgnoreCase(tipoSerializacion)) {
                    AdministradorPersistencia.serializarObjetoXML(objeto, nombreArchivo);
                } else if ("binario".equalsIgnoreCase(tipoSerializacion)) {
                    AdministradorPersistencia.serializarObjetoBinario(objeto, nombreArchivo);
                }
                System.out.println("Serialización completada: " + nombreArchivo);
            } else {
                Object resultado = null;
                if ("xml".equalsIgnoreCase(tipoSerializacion)) {
                    resultado = AdministradorPersistencia.deserializarObjetoXML(nombreArchivo);
                } else if ("binario".equalsIgnoreCase(tipoSerializacion)) {
                    resultado = AdministradorPersistencia.deserializarObjetoBinario(nombreArchivo);
                }
                System.out.println("Deserialización completada: " + nombreArchivo + " - Objeto: " + resultado);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error durante el proceso de " + (esSerializar ? "serialización" : "deserialización"));
        }
    }
    
}