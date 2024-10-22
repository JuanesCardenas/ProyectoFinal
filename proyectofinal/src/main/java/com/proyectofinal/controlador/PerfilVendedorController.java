package com.proyectofinal.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

import com.proyectofinal.modelo.Producto;

public class PerfilVendedorController {

    @FXML
    private VBox productosVBox;

    // Simulación de una lista de productos
    private List<Producto> productos = List.of(
        new Producto("Laptop","","https://m.media-amazon.com/images/I/71Nsxgmi7xL._AC_SL1500_.jpg", "Electrónica", 1200.0, "Laptop de alta gama con pantalla de 15 pulgadas")
        //new Producto("Smartphone","","", "Electrónica", 800.0, "Smartphone con pantalla OLED de 6 pulgadas"),
        //new Producto("televisor","","", "Electrónica", 800.0, "Smartphone con pantalla OLED de 6 pulgadas")
    );

    @FXML
    public void initialize() {
        // Cargar los productos en el VBox
        cargarProductos();
    }

    private void cargarProductos() {
        for (Producto producto : productos) {
            try {
                // Cargar el archivo FXML del detalle del producto
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/detallesProductos.fxml"));
                Pane productoPane = loader.load();

                // Obtener el controlador del archivo FXML
                DetalleProductoController controller = loader.getController();

                // Pasar los datos del producto al controlador
                controller.setProducto(producto);

                // Añadir el Pane del producto al VBox
                productosVBox.getChildren().add(productoPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
