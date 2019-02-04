/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Observer.Vendedor;
import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class AdministrarProductosController implements Initializable {

    @FXML
    private TableView<Producto> tblproductos;
    @FXML
    private TableColumn<Producto, String> cNombre;
    @FXML
    private TableColumn<Producto, Float> cPrecio;
    @FXML
    private TableColumn<Producto, String> cCategoria;
    @FXML
    private TableColumn<Producto, String> cDescripcion;
    @FXML
    private TableColumn<Producto, Float> cTiempo;
    @FXML
    private TableColumn<Producto,Vendedor> cVendedor;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtPrecio;
    @FXML
    private JFXTextField txtCategoria;
    @FXML
    private JFXTextField txtDescripcion;
    @FXML
    private JFXTextField txtEntrega;
    @FXML
    private JFXButton btnAgregar;
    @FXML
    private JFXButton btnModificar;
    @FXML
    private JFXButton btnEliminar;
    ObservableList<Producto> oblist=FXCollections.observableArrayList();
    private int posicionProducto;
    @FXML
    private JFXButton btnRegresar;
    @FXML
    private TableColumn<Producto, Integer> cID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoEntrega"));
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        tblproductos.setItems(oblist);
        
        tblproductos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Producto p=(Producto) newValue;
                if(p!=null){
                    txtNombre.setText(p.getNombre());
                    txtCategoria.setText(p.getCategoria());
                    txtDescripcion.setText(p.getDescripcion());
                    txtPrecio.setText(Float.toString(p.getPrecio()));
                    txtEntrega.setText(Integer.toString((int) p.getTiempoEntrega()));
                }
            }
            
        });
    }    

    @FXML
    private void accionClick(MouseEvent event) {
    }

    @FXML
    private void accionAgregar(ActionEvent event) {
    }

    @FXML
    private void accionModificar(ActionEvent event) throws SQLException {

    }

    @FXML
    private void accionEliminar(ActionEvent event) throws SQLException {
        Producto p= (Producto) tblproductos.getSelectionModel().getSelectedItem();
        eliminarProducto(p.getId());
        oblist.remove(p);
        
    }
    private void llenarTabla() throws SQLException{
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from Productos where estado=1";
        Statement stmt = conectar.createStatement(); 
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String nombre= rs.getString("nombre");
            System.out.println(nombre);
            String descripcion=rs.getString("descripcion");
            String categoria=rs.getString("categoria");
            float precio=rs.getFloat("precio");
            int tiempo=rs.getInt("tiempoEntrega");
            int id=rs.getInt("id");
            Vendedor v=new Vendedor(rs.getString("vendedor"));
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio,id,v);
            
            oblist.add(p);
        }
    }

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesAdministrador.fxml"));        
        Parent homepParent=loader.load();
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    private void eliminarProducto(int idproducto) throws SQLException{
        SingleConexionBD.conectar();
        String query="{CALL eliminarProducto(?)}";
        java.sql.CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        
        stmt.setInt("idprod", idproducto);
        stmt.executeQuery();
    }
}
