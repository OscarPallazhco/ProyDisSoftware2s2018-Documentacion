/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
public class modificarproductoController implements Initializable {

    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtPrecio;
    @FXML
    private JFXTextField txtCategoria;
    @FXML
    private JFXTextField txtDescripcion;
    @FXML
    private JFXTextField txtTiempoEntrega;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnModificar;
    
    private Producto producto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   // public void setProducto()
    @FXML
    private void accionCancelar(ActionEvent event) {
    }

    @FXML
    private void accionModificar(ActionEvent event) {
    }
    
}
