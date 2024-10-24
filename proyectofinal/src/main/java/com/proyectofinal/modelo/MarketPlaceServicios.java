package com.proyectofinal.modelo;

import java.io.IOException;

public class MarketPlaceServicios {

    private static MarketPlaceServicios instancia;
    private VendedorCRUD vendedorCRUD;  // Instancia de VendedorCRUD para la gestión de vendedores

    public MarketPlaceServicios(){
        this.vendedorCRUD = new VendedorCRUD();
    }

    // Método para obtener la única instancia de la clase
    public static MarketPlaceServicios getInstance(){
        if (instancia == null) {
            instancia = new MarketPlaceServicios();
        }
        return instancia;
    }

    // Registrar un nuevo vendedor usando VendedorCRUD
    public void registrarVendedor(Vendedor nuevoVendedor) throws IOException {
        vendedorCRUD.registrarVendedor(nuevoVendedor);
    }

    // Método para buscar un vendedor por nombre y cédula, delegando a VendedorCRUD
    public Vendedor buscarVendedor(String nombre, int cedula) {
        return vendedorCRUD.buscarVendedor(nombre, cedula);  // Delegar a VendedorCRUD
    }
    
}
