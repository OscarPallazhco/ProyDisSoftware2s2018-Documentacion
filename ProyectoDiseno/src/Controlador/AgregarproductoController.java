/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Observer.Vendedor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utils.RegexMatcher;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class AgregarproductoController implements Initializable {

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
    private JFXButton btnAgregar;
    @FXML
    private JFXButton btnCancelar;
    
    private Connection conectar;
    private String user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }    
    
    
    public void setUser(String user){
        this.user=user;
    }
    @FXML
    private void accionAgregar(ActionEvent event) throws SQLException {
        Platform.runLater(()->{
            
       
        if(validarFields()){
            try {
                guardarDatos();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarproductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("guardado");
        }
        
         });
    }

    @FXML
    private void accionCancelar(ActionEvent event) {
    }
    
    private boolean  validarFields(){
        boolean nombreVacio=RegexMatcher.emptyField(txtNombre.getText().trim());
        boolean precioVacio=RegexMatcher.emptyField(txtPrecio.getText().trim());
        boolean categoriaVacio=RegexMatcher.emptyField(txtCategoria.getText().trim());
        boolean descrpicionVacia=RegexMatcher.emptyField(txtDescripcion.getText().trim());
        boolean tiempoVacio=RegexMatcher.emptyField(txtTiempoEntrega.getText().trim());
        return !(nombreVacio || precioVacio || categoriaVacio || descrpicionVacia|| tiempoVacio);
    }
    
    private void guardarDatos() throws SQLException{
        conectar=SingleConexionBD.conectar();
        String query1= "{CALL guardarProducto(?,?,?,?,?,?)}";
        CallableStatement  stmt = conectar.prepareCall(query1);
        stmt.setString("nombre",txtNombre.getText());
        stmt.setString("descripcion", txtDescripcion.getText());
        stmt.setString("categoria", txtCategoria.getText());
        stmt.setFloat("precio", Float.parseFloat(txtPrecio.getText().trim()));
        stmt.setInt("tiempoEntrega", Integer.parseInt(txtTiempoEntrega.getText().trim()));
        stmt.setString("vendedor",user);
        
        
        stmt.executeQuery();
        System.out.println("datos ingresados con exito");
    }
    
}
