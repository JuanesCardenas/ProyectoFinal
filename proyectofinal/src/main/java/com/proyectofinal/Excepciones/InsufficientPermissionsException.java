package com.proyectofinal.Excepciones;

public class InsufficientPermissionsException extends Exception {
    public InsufficientPermissionsException() {
        super("Permisos insuficientes para realizar esta acción.");
    }

    public InsufficientPermissionsException(String message) {
        super(message);
    }
}