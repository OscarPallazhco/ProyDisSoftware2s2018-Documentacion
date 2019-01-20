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
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class MisproductsController implements Initializable {

    @FXML
    private TableView<Producto> tblproductos;
    @FXML
    private TableColumn<Producto,String> cNombre;
    @FXML
    private TableColumn<Producto,Float> cPrecio;
    @FXML
    private TableColumn<Producto, String> cCategoria;
    @FXML
    private TableColumn<Producto, String> cDescripcion;
    @FXML
    private TableColumn<Producto, Integer> cTiempo;
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
    private Vendedor vendedor;
    ObservableList<Producto> oblist=FXCollections.observableArrayList();
    private int posicionProducto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MisproductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoEntrega"));
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
        // TODO
    }    
    
    public void setVendedor(Vendedor vendedor){
        this.vendedor=vendedor;
    }
    @FXML
    private void accionAgregar(ActionEvent event) {
    }

    @FXML
    private void accionModificar(ActionEvent event) {
        Producto p= (Producto) tblproductos.getSelectionModel().getSelectedItem();
        posicionProducto=oblist.indexOf(p);
        p.setNombre(txtNombre.getText());
        p.setPrecio(Float.parseFloat(txtPrecio.getText()));
        p.setCategoria(txtCategoria.getText());
        p.setDescripcion(txtDescripcion.getText());
        p.setTiempoEntrega(Float.parseFloat(txtEntrega.getText()));
        oblist.set(posicionProducto, p);
        
    }

    @FXML
    private void accionEliminar(ActionEvent event) {
        Producto p= (Producto) tblproductos.getSelectionModel().getSelectedItem();
        oblist.remove(p);
    }
    
    private void llenarTabla() throws SQLException{
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from Productos where vendedor='josedel'";
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
            
            oblist.add(p);
        }
    }

    @FXML
    private void accionClick(MouseEvent event) {
    }
}
