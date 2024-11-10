package com.proyectofinal.controlador;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.proyectofinal.modelo.Producto;
import com.proyectofinal.modelo.Vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PublicacionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarComentarioBoton;

    @FXML
    private Label autorLabel;

    @FXML
    private AnchorPane comentariosCampo;

    @FXML
    private Label fechaPublicacionLabel;

    @FXML
    private ImageView imagenCampo;

    @FXML
    private Label likeLabel;

    @FXML
    private Button meGustaBoton;

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private Label precioProductoLabel;

    private int cantidadLikes = 0;
    private boolean likeDado = false;

    @FXML
    void AgregarComentario(ActionEvent event) {

    }

    @FXML
    void darMeGusta(ActionEvent event) {
        if (likeDado) { // Para ver si ya le dió like al post, se le quite el like al presionar el botón de nuevo
            cantidadLikes-=1;
            likeDado = false;
        }
        else{
            cantidadLikes+=1;
            likeDado = true;
        }

    }

    public void setPublicacion(Vendedor vendedor, Producto producto){
        String imagenPath = producto.getImagen(); 

        if (!imagenPath.startsWith("file://")) {
            imagenPath = new File(imagenPath).toURI().toString(); // Convierte a URI
        }

        imagenCampo.setImage(new Image(imagenPath));
        nombreProductoLabel.setText("Nombre: " + producto.getNombre());
        precioProductoLabel.setText("Precio: $" + producto.getPrecio());
        autorLabel.setText("Publicado por: " + vendedor.getNombre());
        fechaPublicacionLabel.setText("Publicado el: " + LocalDate.now());
        likeLabel.setText("" + cantidadLikes);

    }

}
