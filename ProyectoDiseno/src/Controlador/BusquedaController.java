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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.RegexMatcher;
import utils.SingleConexionBD;

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
    private TableView<Producto> tblviewBusqueda;
    
    private LinkedList<Producto> productos;
    @FXML
    private TableColumn<Producto, String> cNombre;
    @FXML
    private TableColumn<Producto, Float> cPrecio;
    @FXML
    private TableColumn<Producto, String> cCategoria;
    @FXML
    private TableColumn<Producto, String> cDescripcion;
    ObservableList<Producto> oblist=FXCollections.observableArrayList();
    HashMap<Integer,Producto> coincidencias;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coincidencias =new HashMap<>();
       
        
        try {
            cargarProductos();
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void accionComprar(ActionEvent event) {
    }

    @FXML
    private void accionBuscar(ActionEvent event) throws SQLException {
        busqueda();
        setDatos();
    }
    //
    
    private void  cargarProductos() throws SQLException{
        SingleConexionBD.conectar();
        String query="select * from Productos where estado=1";
        Statement stmt = SingleConexionBD.conectar().createStatement(); 
        ResultSet rs = stmt.executeQuery(query);
         while(rs.next()){
            Integer id=rs.getInt("id");
            String nombre= rs.getString("nombre");
            System.out.println(nombre);
            String descripcion=rs.getString("descripcion");
            String categoria=rs.getString("categoria");
            float precio=rs.getFloat("precio");
            int tiempo=rs.getInt("tiempoEntrega");
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio);
            
            coincidencias.put(id, p);
         }
    }
    
    private void busqueda() throws SQLException{
        
            for (Map.Entry<Integer, Producto> entry : coincidencias.entrySet()) {
            Integer key = entry.getKey();
            Producto value = entry.getValue();
            if(RegexMatcher.testSearch(txtBuscar.getText(), value.getNombre())||
                    RegexMatcher.testSearch(txtBuscar.getText(), value.getDescripcion())){
                updateSearch(key);
                oblist.add(value);
            }
        }


        }
    
    private void llenarTable(){
        
    }
    
    private void setDatos(){
        
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tblviewBusqueda.setItems(oblist);
    }
    
    private void updateSearch(Integer id) throws SQLException{
        
        SingleConexionBD.conectar();
        String query="{CALL actualizarBusqueda(?)}";
        java.sql.CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        
        stmt.setInt("iduser", id);
        stmt.executeQuery();
        
        
    }
    }
    

