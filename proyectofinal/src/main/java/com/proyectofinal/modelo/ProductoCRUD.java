package com.proyectofinal.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoCRUD {
    // Lista para almacenar productos
    private List<Producto> productos;

    public ProductoCRUD() {
        this.productos = new ArrayList<>();
    }

    // Crear producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Leer producto por código
    public Optional<Producto> buscarProductoPorCodigo(String codigo) {
        return productos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    // Actualizar producto
    public void actualizarProducto(Producto productoActualizado) {
        Optional<Producto> productoExistente = buscarProductoPorCodigo(productoActualizado.getCodigo());
        productoExistente.ifPresent(p -> {
            p.setNombre(productoActualizado.getNombre());
            p.setCategoria(productoActualizado.getCategoria());
            p.setPrecio(productoActualizado.getPrecio());
            p.setEstado(productoActualizado.getEstado());
        });
    }

    // Eliminar producto
    public void eliminarProducto(String codigoProducto) {
        productos.removeIf(p -> p.getCodigo().equals(codigoProducto));
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return new ArrayList<>(productos);
    }
}

