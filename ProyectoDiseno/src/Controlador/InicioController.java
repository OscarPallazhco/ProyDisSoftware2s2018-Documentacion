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
import java.util.LinkedList;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class InicioController implements Initializable {

    @FXML
    private TableView<Producto> masBuscados;
    @FXML
    private TableView<?> nuevos;
    @FXML
    private JFXButton btnIngresar;
    
    private LinkedList<Producto> lista;
    @FXML
    private TableColumn<Producto, String> tblnombre;
    @FXML
    private TableColumn<Producto, Float> tblprecio;
    @FXML
    private TableColumn<Producto, String> tblcategoria;
    
    ObservableList<Producto> oblist=FXCollections.observableArrayList();
    @FXML
    private TableColumn<Producto, String> tbldescripcion;
    @FXML
    private TableColumn<Producto, Integer> tbltiempo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarDatos();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tblcategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tbltiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoEntrega"));
        tbldescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        masBuscados.setItems(oblist);
        
    }    

    @FXML
    private void accionIngresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/inicioSesion.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();

    }
    
    private LinkedList<Producto> cargarDatos() throws SQLException{
        LinkedList<Producto> productos=new LinkedList<>();
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from Productos";
        Statement stmt = conectar.createStatement(); 
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String nombre= rs.getString("nombre");
            System.out.println(nombre);
            String descripcion=rs.getString("descripcion");
            String categoria=rs.getString("categoria");
            float precio=rs.getFloat("precio");
            int tiempo=rs.getInt("tiempoEntrega");
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio);
            productos.add(p);
            oblist.add(p);
        }
        
        return productos;
    }


    @FXML
    private void accionProducto(MouseEvent event) throws IOException {
        if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
         System.out.println("Bien ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/inicioSesion.fxml"));
        
        Parent homepParent=loader.load();
        InicioSesionController controla=loader.getController();
        controla.getDato("soy uriel");
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
            
        }
    }
    
}

