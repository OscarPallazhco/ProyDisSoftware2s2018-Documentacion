/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    public JFXTextField txtBuscar;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    public TableView<Producto> tblviewBusqueda;
    
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
    Producto p;
    private String usuario;
    @FXML
    private TableColumn<Producto, Integer> cID;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coincidencias =new HashMap<>();
        
        
        try {
            tblviewBusqueda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                 p=(Producto) newValue;
                if(p!=null){
                   
                }
            }
            
        });
            cargarProductos();
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesComprador.fxml"));
        
        Parent homepParent=loader.load();
        OpcionesCompradorController op= loader.getController();
        op.getUser(usuario);
        Scene scene =new Scene(homepParent);
        
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
        
    }
    
    public void getUsuario(String user){
        this.usuario=user;
    }

    @FXML
    public void accionBuscar(ActionEvent event) throws SQLException {
        
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
            
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio,id);
            
            coincidencias.put(id, p);
         }
    }
    
    private void busqueda() throws SQLException{
        
            for (Map.Entry<Integer, Producto> entry : coincidencias.entrySet()) {
            Integer key = entry.getKey();
            Producto value = entry.getValue();
            boolean coincideNombre = RegexMatcher.testSearch(txtBuscar.getText(), value.getNombre());
            boolean coincideDescripcion = RegexMatcher.testSearch(txtBuscar.getText(), value.getDescripcion());
            if(coincideNombre||coincideDescripcion){
                updateSearch(key);
                oblist.add(value);
            }
        }


        }
    
    public void setDatos(){
        
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblviewBusqueda.setItems(oblist);
    }
    
    private void updateSearch(Integer id) throws SQLException{
        
        SingleConexionBD.conectar();
        String query="{CALL actualizarBusqueda(?)}";
        java.sql.CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        
        stmt.setInt("idprod", id);
        stmt.executeQuery();
        
        
    }
    

    @FXML
    private void compra(MouseEvent event) throws IOException {
        
        
        if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/metodoPago.fxml"));
        
        Parent homepParent=loader.load();
        MetodoPagoController pago=loader.getController();
        
         pago.getProducto(p);
         pago.getUser(usuario);
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }

}
}

