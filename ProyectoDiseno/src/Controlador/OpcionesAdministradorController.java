/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
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
public class OpcionesAdministradorController implements Initializable {

    @FXML
    private JFXButton btnAdminUsers;
    @FXML
    private JFXButton btnAdminProductos;
    @FXML
    private JFXButton btnCerrarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionAdminUsers(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/administrarProductos.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }

    @FXML
    private void accionAdminProductos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/administrarProductos.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }

    @FXML
    private void accionCerrar(ActionEvent event) {
    }
    
}
