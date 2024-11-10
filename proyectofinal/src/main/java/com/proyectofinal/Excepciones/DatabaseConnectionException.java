package com.proyectofinal.Excepciones;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException() {
        super("Error al conectar con la base de datos.");
    }

    public DatabaseConnectionException(String message) {
        super(message);
    }
}