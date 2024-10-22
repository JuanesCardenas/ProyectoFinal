package com.proyectofinal.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectofinal.excepciones.ExcepcionLimiteVendedores;

public class VendedorCRUD {
    private List<Vendedor> vendedores;

    public VendedorCRUD() {
        this.vendedores = new ArrayList<>();
    }

    // Crear vendedor
    public void crearVendedor(Vendedor vendedor) {
        if (vendedores.size() >= 10) {
            throw new ExcepcionLimiteVendedores("No se pueden agregar más de 10 vendedores.");
        }
        vendedores.add(vendedor);
    }

    // Leer vendedor por cédula
    public Optional<Vendedor> buscarVendedorPorCedula(String cedula) {
        return vendedores.stream().filter(v -> v.getCedula().equals(cedula)).findFirst();
    }

    // Actualizar vendedor
    public void actualizarVendedor(Vendedor vendedorActualizado) {
        Optional<Vendedor> vendedorExistente = buscarVendedorPorCedula(vendedorActualizado.getCedula());
        vendedorExistente.ifPresent(v -> {
            v.setNombre(vendedorActualizado.getNombre());
            v.setApellidos(vendedorActualizado.getApellidos());
            v.setDireccion(vendedorActualizado.getDireccion());
        });
    }

    // Eliminar vendedor
    public void eliminarVendedor(String cedula) {
        vendedores.removeIf(v -> v.getCedula().equals(cedula));
    }

    // Obtener todos los vendedores
    public List<Vendedor> obtenerTodosLosVendedores() {
        return new ArrayList<>(vendedores);
    }
}

