/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class InicioSesionController implements Initializable {

    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnRegistrar;
    
    private String dato;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void accionLogin(ActionEvent event) throws IOException {
       Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/opcionVendedor.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
        
    

    @FXML
    private void accionRegistrar(ActionEvent event) throws IOException {
        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/registro.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    public void getDato(String dato){
        this.dato=dato;
    }
    
}
