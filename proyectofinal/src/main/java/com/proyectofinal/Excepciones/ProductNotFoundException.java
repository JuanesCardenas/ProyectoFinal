package com.proyectofinal.Excepciones;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("El producto no existe.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}