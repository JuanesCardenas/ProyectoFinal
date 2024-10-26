package com.proyectofinal.controlador;

import java.io.File;

import com.proyectofinal.modelo.Producto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetalleProductoController {

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private ImageView imagenUrl;

    @FXML
    private Label categoriaProductoLabel;

    @FXML
    private Label precioProductoLabel;

    @FXML
    private Label estadoProductoLabel;

    @FXML
    private Label descripcionProductoLabel;

    // Método para configurar los detalles del producto
    public void setProducto(Producto producto) {
        String imagenPath = producto.getImagen(); 

        if (!imagenPath.startsWith("file://")) {
            imagenPath = new File(imagenPath).toURI().toString(); // Convierte a URI
        }

        imagenUrl.setImage(new Image(imagenPath));
        nombreProductoLabel.setText("Nombre: " + producto.getNombre());
        categoriaProductoLabel.setText("Categoría: " + producto.getCategoria());
        precioProductoLabel.setText("Precio: $" + producto.getPrecio());
        estadoProductoLabel.setText("Estado: " + producto.getEstado());
        descripcionProductoLabel.setText("Descripción: " + producto.getDescripcion());
    }
}

