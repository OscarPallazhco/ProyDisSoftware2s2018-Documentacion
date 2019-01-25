/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class MasbuscadosController implements Initializable {

    @FXML
    private TableView<Producto> tblMasBuscados;
    @FXML
    private TableColumn<Producto, String> cNombre;
    @FXML
    private TableColumn<Producto, String> cCategoria;
    @FXML
    private TableColumn<Producto, Float> cPrecio;
    @FXML
    private TableColumn<Producto, String> cDescripcion;
    @FXML
    private TableColumn<Producto, Integer> cTiempoEntrega;
    @FXML
    private TableColumn<Producto, Integer> cId;
    @FXML
    private JFXButton bntRegresar;
    ObservableList<Producto> oblist=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(MasbuscadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setMasBuscados();
        // TODO
    }    

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesComprador.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    private void cargarDatos() throws SQLException{
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from productos "
                + "where estado=1 "
              + "ORDER BY numeroBusquedas DESC  "
              + "LIMIT 15";
        Statement stmt = conectar.createStatement(); 
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String nombre= rs.getString("nombre");
            
            String descripcion=rs.getString("descripcion");
            String categoria=rs.getString("categoria");
            float precio=rs.getFloat("precio");
            int tiempo=rs.getInt("tiempoEntrega");
            int id=rs.getInt("id");
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio,id);
            
            oblist.add(p);
        }
    }
    
        private void setMasBuscados(){
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("tiempoEntrega"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tblMasBuscados.setItems(oblist);
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
    }
    
}
