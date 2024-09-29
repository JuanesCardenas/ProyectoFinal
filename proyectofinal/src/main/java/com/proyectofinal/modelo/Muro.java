package com.proyectofinal.modelo;

import java.util.List;

public class Muro {

    public List<Publicacion> publicaciones;
    public List<Mensaje> mensajes;
    public List<MeGusta> meGustas;

    // Constructor
    public Muro(List<Publicacion> publicaciones, List<Mensaje> mensajes, List<MeGusta> meGustas) {
        this.publicaciones = publicaciones;
        this.mensajes = mensajes;
        this.meGustas = meGustas;
    }
    // Gets y sets
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    public List<Mensaje> getMensajes() {
        return mensajes;
    }
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    public List<MeGusta> getMeGustas() {
        return meGustas;
    }
    public void setMeGustas(List<MeGusta> meGustas) {
        this.meGustas = meGustas;
    }


    
}
