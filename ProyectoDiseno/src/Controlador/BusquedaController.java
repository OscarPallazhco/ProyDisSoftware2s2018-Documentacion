/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class BusquedaController implements Initializable {

    @FXML
    private JFXButton btnComprar;
    @FXML
    private JFXTextField txtBuscar;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private TableView<?> tblviewBusqueda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionComprar(ActionEvent event) {
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
    }
    
}
