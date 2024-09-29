package com.proyectofinal.modelo;

public class Producto {
    
    private String nombre;
    private String codigo;
    private String imagen;
    private String categoria;
    private double precio;
    private Estado estado;

    // Constructor
    public Producto(String nombre, String codigo, String imagen, String categoria, double precio, Estado estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }
    // Gets y Sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Metodos
    public void publicar(){

    }
    public void cancelar(){

    }
    public void vender(){

    }
    

}
