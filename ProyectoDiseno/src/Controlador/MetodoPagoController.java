/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class MetodoPagoController implements Initializable {

    @FXML
    private JFXRadioButton rbSaldo;
    @FXML
    private JFXRadioButton rbEfectivo;
    
    private Producto producto;
    private String user;
    @FXML
    private Label labelProducto;
    @FXML
    private TextArea textAreaDescripcion;
    private  Date fecha_actual;
    @FXML
    private JFXButton btnPagar;
    java.sql.Date fechasql;
    @FXML
    private JFXButton btnRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()->{
          labelProducto.setText(producto.getNombre());
          textAreaDescripcion.setText(producto.getDescripcion());
           fecha_actual = new Date();
        
        fechasql=new java.sql.Date(fecha_actual.getTime());
          
          
        });
       
        
        // TODO
    } 
    
    public void getProducto(Producto p){
        this.producto=p;
    }
    public void getUser(String user){
        this.user=user;
    }

    @FXML
    private void accionPagar(ActionEvent event) throws SQLException {
        System.out.println(producto.getId());
        SingleConexionBD.conectar();
        String query="{CALL ingresarCompra(?,?,?,?,?)}";
        CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        stmt.setDate("fecha",fechasql );
        stmt.setString("comprador", user);
        stmt.setInt("producto", producto.getId());
        stmt.setString("tipoPago","efectivo");
        stmt.setBoolean("estado", true);
        stmt.executeQuery();
    }

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/busqueda.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
}
