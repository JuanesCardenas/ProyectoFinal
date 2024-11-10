package com.proyectofinal.Excepciones;

public class ContactAlreadyExistsException extends Exception {
    public ContactAlreadyExistsException() {
        super("El contacto ya existe.");
    }

    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}