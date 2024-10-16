package com.proyectofinal.Excepciones;

public class ExcepcionLimiteVendedores extends RuntimeException {
    public ExcepcionLimiteVendedores(String mensaje) {
        super(mensaje);
    }
}