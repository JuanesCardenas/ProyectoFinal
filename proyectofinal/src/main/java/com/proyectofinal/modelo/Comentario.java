package com.proyectofinal.modelo;

import java.time.LocalDateTime;

public class Comentario {

    private Vendedor vendedor;
    private String contenido;
    private LocalDateTime fecha;

    // Constructor
    public Comentario(Vendedor vendedor, String contenido, LocalDateTime fecha) {
        this.vendedor = vendedor;
        this.contenido = contenido;
        this.fecha = fecha;
    }
    // Gets y sets
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Metodo
    public void comentar(Publicacion publicacion){
        
    }
    
}
