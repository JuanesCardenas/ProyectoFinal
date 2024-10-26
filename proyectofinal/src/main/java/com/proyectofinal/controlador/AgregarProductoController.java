package com.proyectofinal.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;

import com.proyectofinal.modelo.AdministradorLogger;
import com.proyectofinal.modelo.AdministradorPropiedades;
import com.proyectofinal.modelo.Producto;
import com.proyectofinal.modelo.Vendedor;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AgregarProductoController {
    
    @FXML
    private TextField nombreField;
    @FXML
    private TextField codigoField;
    @FXML
    private TextField categoriaField;
    @FXML
    private TextField precioField;
    @FXML
    private TextArea descripcionArea;
    @FXML
    private ImageView imagenView;
    @FXML
    private Button agregarButton;

    private String imagenPath;  // Para almacenar la ruta de la imagen

    private Vendedor vendedorActual;

    public void setVendedorActual(Vendedor vendedor) {
        this.vendedorActual = vendedor;
    
    }

    @FXML
    private void initialize() {
        // Inicializar variables o configurar UI si es necesario
        imagenPath = "";
    }

    public void cargarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                // Define la carpeta donde quieres guardar las imágenes (asegúrate de que existe)
                Path destination = Path.of(AdministradorPropiedades.getInstance().getRuta("archivos.directory") + "/" + file.getName());
                // Copia la imagen a la carpeta
                Files.copy(file.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
                // Guarda la ruta relativa de la imagen en el objeto Producto
                imagenPath = destination.toString();
                // Muestra la imagen en la interfaz
                imagenView.setImage(new Image(destination.toUri().toString()));
            } catch (IOException e) {
                e.printStackTrace();
                // Manejar el error adecuadamente (por ejemplo, mostrando un mensaje al usuario)
                mostrarAlerta("Error", "No se pudo cargar la imagen.", e.toString());
                AdministradorLogger.getInstance().escribirLog(AgregarProductoController.class, "No se pudo cargar la imagen." + e.toString(), Level.INFO);
            }
        }
    }

    public void agregarProducto() {
        String nombre = nombreField.getText();
        String codigo = codigoField.getText();
        String categoria = categoriaField.getText();
        double precio;

        // Validar entrada del precio
        try {
            precio = Double.parseDouble(precioField.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un número válido.", e.toString());
            AdministradorLogger.getInstance().escribirLog(AgregarProductoController.class, "El precio debe ser un número válido." + e.toString(), Level.INFO);
            return;
        }

        String descripcion = descripcionArea.getText();

        // Crear el objeto Producto
        Producto nuevoProducto = new Producto(nombre, codigo, imagenPath, categoria, precio, descripcion);

        // Agregar el nuevo producto al vendedor actual
        if (vendedorActual != null) {
            vendedorActual.publicarProducto(nuevoProducto);
        }

        // Limpiar los campos después de agregar
        limpiarCampos();
        mostrarInformacion("Éxito", "Publicación exitosa","Producto agregado correctamente.");
        AdministradorLogger.getInstance().escribirLog(AgregarProductoController.class, "Publicacion exitosa", Level.INFO);
        // Cerrar la ventana
        cerrarVentana();
        
    }

    public void cancelar() {
        limpiarCampos();
    }
    
    private void cerrarVentana() {
        Stage stage = (Stage) agregarButton.getScene().getWindow();
        stage.close(); // Cerrar la ventana actual
    }

    private void limpiarCampos() {
        nombreField.clear();
        codigoField.clear();
        categoriaField.clear();
        precioField.clear();
        descripcionArea.clear();
        imagenView.setImage(null);
        imagenPath = null;  // Resetea la ruta de la imagen
    }

    private void mostrarInformacion(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION); // Cambiar a tipo de alerta de información
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
