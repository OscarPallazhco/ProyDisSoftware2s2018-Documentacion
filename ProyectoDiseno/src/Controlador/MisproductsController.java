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
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import utils.RegexMatcher;
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
    private String userName;
    
    @FXML
    private TableColumn<Producto, Integer> cId;
    @FXML
    private JFXButton btnRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
                    System.out.println(userName);
                    
        try {
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MisproductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        });

        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoEntrega"));
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
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
    public void setUserName(String user){
        this.userName=user;
    }
    public void setVendedor(Vendedor vendedor){
        this.vendedor=vendedor;
    }
    @FXML
    private void accionAgregar(ActionEvent event) throws IOException, SQLException {
        guardarDatos();

    }

    @FXML
    private void accionModificar(ActionEvent event) throws SQLException {
        Producto p= (Producto) tblproductos.getSelectionModel().getSelectedItem();
        posicionProducto=oblist.indexOf(p);
        p.setNombre(txtNombre.getText());
        p.setPrecio(Float.parseFloat(txtPrecio.getText()));
        p.setCategoria(txtCategoria.getText());
        p.setDescripcion(txtDescripcion.getText());
        p.setTiempoEntrega(Float.parseFloat(txtEntrega.getText()));
        oblist.set(posicionProducto, p);
        modificarProducto(p.getId(),p.getNombre(), p.getDescripcion(), p.getCategoria(),p.getPrecio()
                , (int) p.getTiempoEntrega());
        
    }

    @FXML
    private void accionEliminar(ActionEvent event) throws SQLException {
        Producto p= (Producto) tblproductos.getSelectionModel().getSelectedItem();
        eliminarProducto(p.getId());
        oblist.remove(p);
        
        
    }
    
    public void llenarTabla() throws SQLException{
        String dato="'";
        String userb=dato+userName+dato;
       
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from Productos where vendedor="+userb+" and estado=1";
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
            Producto p=new Producto(nombre, descripcion, categoria, tiempo, precio,id);
            
            
            oblist.add(p);
        }
    }

    @FXML
    private void accionClick(MouseEvent event) {
        
    }
    
    private void eliminarProducto(int id) throws SQLException{
        SingleConexionBD.conectar();
        String query="{CALL eliminarProducto(?)}";
        java.sql.CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        
        stmt.setInt("idprod", id);
        stmt.executeQuery();
    }
    
    private void modificarProducto(int id,String nombre, String descripcion, String categoria, float precio, int dias) throws SQLException{
        SingleConexionBD.conectar();
        String query="{CALL modificarProducto(?,?,?,?,?,?)}";
        java.sql.CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        stmt.setInt("idprod", id);
        stmt.setString("descripcion", descripcion);
        stmt.setString("categoria", categoria);
        stmt.setString("nombre", nombre);
        stmt.setInt("tiempoEntrega", dias);
        stmt.setFloat("precio", precio);
        stmt.executeQuery();
    }

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesVendedor.fxml"));
        
        Parent homepParent=loader.load();
        OpcionesVendedorController ov=loader.getController();
        ov.getUser(userName);
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    private boolean  validarFields(){
        boolean nombreVacio=RegexMatcher.emptyField(txtNombre.getText().trim());
        boolean precioVacio=RegexMatcher.emptyField(txtPrecio.getText().trim());
        boolean categoriaVacio=RegexMatcher.emptyField(txtCategoria.getText().trim());
        boolean descrpicionVacia=RegexMatcher.emptyField(txtDescripcion.getText().trim());
        boolean tiempoVacio=RegexMatcher.emptyField(txtEntrega.getText().trim());
        return !(nombreVacio || precioVacio || categoriaVacio || descrpicionVacia|| tiempoVacio);
    }
    
    
        private void guardarDatos() throws SQLException{
        if(validarFields()){
        String query1= "{CALL ingresarProducto(?,?,?,?,?,?)}";
        CallableStatement  stmt = SingleConexionBD.conectar().prepareCall(query1);
        stmt.setString("nombre",txtNombre.getText());
        stmt.setString("descripcion", txtDescripcion.getText());
        stmt.setString("categoria", txtCategoria.getText());
        stmt.setFloat("precio", Float.parseFloat(txtPrecio.getText().trim()));
        stmt.setInt("tiempoEntrega", Integer.parseInt(txtEntrega.getText().trim()));
        stmt.setString("vendedor",userName);
        
        
        stmt.executeQuery();
        RegexMatcher.errormsj("Producto agregado con exito");
        tblproductos.getItems().clear();
        llenarTabla();
        }
        
    }
    

}
