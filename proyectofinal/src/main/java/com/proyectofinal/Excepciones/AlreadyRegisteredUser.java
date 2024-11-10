package com.proyectofinal.Excepciones;

public class AlreadyRegisteredUser extends Exception {
    public AlreadyRegisteredUser(String mensaje) {
        super(mensaje);
    }
}
