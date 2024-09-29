package com.proyectofinal.modelo;

import java.util.List;

public class Vendedor {

    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private List<Producto> productos;
    private List<Vendedor> contactos;
    private Muro muro;
    
    // Constructor
    public Vendedor(String nombre, String apellido, String cedula, String direccion, List<Producto> productos,
            List<Vendedor> contactos, Muro muro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.productos = productos;
        this.contactos = contactos;
        this.muro = muro;
    }
    // Get y Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Vendedor> getContactos() {
        return contactos;
    }

    public void setContactos(List<Vendedor> contactos) {
        this.contactos = contactos;
    }

    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    // Metodos
    public void agregarProducto(Producto producto){

    }

    public void solicitarVinculo(Vendedor vendedor){

    }

    public void publicarComentario(Producto producto, String comentario){

    }

    public void darMeGusta(Producto producto){

    }

    public void enviarMensaje(Vendedor vendedor, String mensaje){

    }


}
