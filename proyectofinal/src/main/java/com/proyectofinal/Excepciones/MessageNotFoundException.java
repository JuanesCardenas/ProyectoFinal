package com.proyectofinal.Excepciones;

public class MessageNotFoundException extends Exception {
    public MessageNotFoundException() {
        super("EL mensaje no existe.");
    }

    public MessageNotFoundException(String message) {
        super(message);
    }
}