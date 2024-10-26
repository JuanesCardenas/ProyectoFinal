package com.proyectofinal.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import com.proyectofinal.modelo.AdministradorLogger;
import com.proyectofinal.modelo.Producto;
import com.proyectofinal.modelo.Vendedor;

public class PerfilVendedorController {
    
     @FXML
    private Label cedulaLabel;

    @FXML
    private Label direccionLabel;

    @FXML
    private VBox muroVBox;

    @FXML
    private Label nombreLabel;

    @FXML
    private VBox productosVBox;

    @FXML
    private Button publicarButton;

    private Vendedor vendedorActual;

    @FXML
    public void initialize() {
        // Cargar los productos en el VBox
        
    }

    public void setVendedorActual(Vendedor vendedor) {
        this.vendedorActual = vendedor;
        mostrarInformacionVendedor();
        cargarProductos();
        
    }

    private void mostrarInformacionVendedor() {
        if (vendedorActual != null) {
            nombreLabel.setText(vendedorActual.getNombre() + " " + vendedorActual.getApellidos());
            cedulaLabel.setText(String.valueOf(vendedorActual.getCedula()));
            direccionLabel.setText(vendedorActual.getDireccion());
        }
    }

    private void cargarProductos() {
        List<Producto> productos = vendedorActual.getProductos();
        productosVBox.getChildren().clear();

        for (Producto producto : productos) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/detallesProductos.fxml"));
                Pane productoPane = loader.load();
                DetalleProductoController controller = loader.getController();
                controller.setProducto(producto);
                productosVBox.getChildren().add(productoPane);
            } catch (IOException e) {
                e.printStackTrace();
                AdministradorLogger.getInstance().escribirLog(PerfilVendedorController.class, "No se pudo cargar la ventana detallesProductos." + e.toString(), Level.WARNING);
            }
        }
    }

    public void PublicarBoton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/proyectofinal/agregarProducto.fxml"));
            Parent root = loader.load();
            AgregarProductoController agregarProductoController = loader.getController();
            agregarProductoController.setVendedorActual(vendedorActual); // Pasar el vendedor actual

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Agregar Producto");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la ventana para agregar producto.", e.toString());
            AdministradorLogger.getInstance().escribirLog(PerfilVendedorController.class, "No se pudo abrir la ventana para agregar producto." + e.toString(), Level.WARNING);
        }
        cargarProductos();
    }
    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
