package com.proyectofinal.controlador;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class LoginController {
    
      @FXML
    private PasswordField cedulaConfirRegisLabel;

    @FXML
    private PasswordField cedulaRegistroLabel;

    @FXML
    private PasswordField contraseñaLoginLabel;

    @FXML
    private Button crearVendedorButton;

    @FXML
    private TextField direccionRegistroLabel;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private TextField nombreLonginLabel;

    @FXML
    private TextField nombreRegistroLabel;

    @FXML
    private AnchorPane opcionPane;

    @FXML
    private AnchorPane registroPane;

    @FXML
    private Button tengoCuentaButton;

    @FXML
    public void initialize() {
        
    }

    public void registrarse(ActionEvent event){

        TranslateTransition slider = new TranslateTransition();

        if(event.getSource() == crearVendedorButton){
            slider.setNode(opcionPane);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) ->{
                tengoCuentaButton.setVisible(true);
                crearVendedorButton.setVisible(false);
            });

            slider.play();
        }else if(event.getSource() == tengoCuentaButton){
            slider.setNode(opcionPane);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) ->{
                tengoCuentaButton.setVisible(false);
                crearVendedorButton.setVisible(true);
            });

            slider.play();
        }
    }
}
