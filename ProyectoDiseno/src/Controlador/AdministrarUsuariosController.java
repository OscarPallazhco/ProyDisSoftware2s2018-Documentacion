/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataUser;
import Modelo.Observer.Vendedor;
import Modelo.Producto;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.CallableStatement;
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
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author edduard
 */
public class AdministrarUsuariosController implements Initializable {

    @FXML
    private TableView<DataUser> tblUsuarios;
    @FXML
    private TableColumn<DataUser, String> cUsuario;
    @FXML
    private TableColumn<DataUser, String> cRol;
    @FXML
    private TableColumn<DataUser, Boolean> cEstado;
    @FXML
    private JFXButton btnAgregar;
    @FXML
    private JFXButton btnModificar;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnRegresar;
    
    ObservableList<DataUser> oblist=FXCollections.observableArrayList();

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
        cUsuario.setCellValueFactory(new PropertyValueFactory<>("user"));
        cRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        cEstado.setCellValueFactory(new PropertyValueFactory<DataUser,Boolean>("estado"));
        cEstado.setVisible(false);
        
        
        tblUsuarios.setItems(oblist);                   
    }    

    private void llenarTabla() throws SQLException{
        Connection conectar = SingleConexionBD.conectar();
        String query="select * from Usuarios where estado = 1";
        Statement stmt = conectar.createStatement(); 
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String usuario = rs.getString("nombreUsuario");
            String contrasena = rs.getString("contrasena");
            String rol = rs.getString("rol");
            boolean estado = rs.getBoolean("estado");
            DataUser du = new DataUser(usuario, contrasena, rol,estado);
            //System.out.println(usuario+", "+contrasena+", "+rol+", "+estado);
            oblist.add(du);
        }
    }
    
    private static void eliminarComprador(String nombreComprador) throws SQLException{        
        String query="{CALL eliminarComprador(?)}";
        CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);        
        stmt.setString("compradorElim", nombreComprador);
        stmt.executeQuery();
    }
    
    private static void eliminarVendedor(String nombreComprador) throws SQLException{        
        String query="{CALL eliminarComprador(?)}";
        CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);        
        stmt.setString("compradorElim", nombreComprador);
        stmt.executeQuery();
    }
    
    @FXML
    private void accionClick(MouseEvent event) {
    }

    @FXML
    private void accionAgregar(ActionEvent event) {
    }

    @FXML
    private void accionModificar(ActionEvent event) {
    }

    @FXML
    private void accionEliminar(ActionEvent event) {
    }

    @FXML
    private void accionRegresar(ActionEvent event) {
    }
    
}
