/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comprador;
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
public class OpcionesCompradorController implements Initializable {

    @FXML
    private JFXButton btnBusqueda;
    @FXML
    private JFXButton btnPedidos;
    @FXML
    private JFXButton btnNuevosArticulos;
    @FXML
    private JFXButton btnCerrarSesion;
    @FXML
    private JFXButton btnMasBuscados;
    
    Comprador comprador;
    
    String user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    
    public void getUser(String user){
        this.user=user;
    }

    @FXML
    private void accionBuscar(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/busqueda.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        BusquedaController busqueda=loader.getController();
        busqueda.getUsuario(user);
        
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    

    @FXML
    private void accionPedidos(ActionEvent event) throws IOException {

        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/comprasPendientes.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    

    @FXML
    private void btnNuevosArticulos(ActionEvent event) {
    }

    @FXML
    private void accionCerrarSesion(ActionEvent event) throws IOException {
        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/inicio.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
        
    }

    @FXML
    private void btnMasbuscados(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/masbuscados.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
}
