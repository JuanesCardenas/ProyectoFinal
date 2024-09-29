package com.proyectofinal.modelo;

import java.util.List;
import java.util.Optional;

public class VendedorCRUD {
    
    private List<Vendedor> listaVendedores;

    // Constructor
    public VendedorCRUD(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }
    // Gets y Sets
    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    // Métodos
    public void crearVendedor(Vendedor vendedor){

    }

    public Optional<String> leerVendedor(String string){

    }

    public boolean actualizarVendedor(String string, Vendedor vendedor){

    }

    public boolean eliminarVendedor(String string){
        
    }
    
    public List<Vendedor> listarVendedores(){

    }
}
