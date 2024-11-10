package com.proyectofinal.Excepciones;

public class FileExportException extends Exception {
    public FileExportException() {
        super("Error durante el envio del archivo.");
    }

    public FileExportException(String message) {
        super(message);
    }
}