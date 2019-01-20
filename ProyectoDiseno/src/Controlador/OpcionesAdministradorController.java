/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private void accionAdminUsers(ActionEvent event) {
    }

    @FXML
    private void accionAdminProductos(ActionEvent event) {
    }

    @FXML
    private void accionCerrar(ActionEvent event) {
    }
    
}
