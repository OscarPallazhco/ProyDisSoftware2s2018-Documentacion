/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import utils.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import utils.RegexMatcher;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class RegistroController implements Initializable {

    @FXML
    private JFXTextField txtNombres;
    @FXML
    private JFXTextField txtApellidos;
    @FXML
    private JFXTextField txtTelefono;
    @FXML
    private JFXTextField txtcedula;
    @FXML
    private JFXTextField txtDireccion;
    @FXML
    private JFXTextField txtMatricula;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXRadioButton rbVendedor;
    @FXML
    private JFXRadioButton rbComprador;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXCheckBox checkSi;
    @FXML
    private ToggleGroup group;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXTextField txtUser;
   
    private Connection conectar;
    private String rol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbVendedor.setUserData("Vendedor");
        rbComprador.setUserData("Comprador");
        rbVendedor.setToggleGroup(group);
        rbComprador.setToggleGroup(group);
        seleccionRol();
        // TODO
         
       
    }    

    @FXML
    private void accionRegistrar(ActionEvent event) throws SQLException, IOException {
        
        if(validarTextField() && rol.equals("Comprador")){
            guardarDatos("{CALL ingresarComprador(?,?,?,?,?,?,?,?,?)}");
            guardarUsuario("Comprador");
            RegexMatcher.errormsj("Registro Exitoso");
            gotoLogin(event);
            
        }else if(validarTextField() && rol.equals("Vendedor")){
            guardarDatos("{CALL ingresarVendedor(?,?,?,?,?,?,?,?,?)}");
            guardarUsuario("Vendedor");
            RegexMatcher.errormsj("Registro Exitoso");
            gotoLogin(event);
        }else{
            RegexMatcher.errormsj("DATOS INCORRECTOS O CAMPOS EN BLANCO");
            limpiarTextfield();
        }
        

    }

    @FXML
    private void accionCancelar(ActionEvent event) throws IOException {
        
        limpiarTextfield();

        
    }
    
    private boolean validarTextField(){
        boolean rbVacio= group.getSelectedToggle()==null;
        boolean nombreVacio=RegexMatcher.emptyField(txtNombres.getText().trim());
        boolean apellidoVacio=RegexMatcher.emptyField(txtApellidos.getText().trim());
        boolean tlefonoVacio=RegexMatcher.emptyField(txtTelefono.getText().trim());
        boolean cedulaVacia= RegexMatcher.emptyField(txtcedula.getText().trim());
        boolean direccionVacia=RegexMatcher.emptyField(txtDireccion.getText().trim());
        boolean matriculaVacia=RegexMatcher.emptyField(txtMatricula.getText().trim());
        boolean emailVacio=RegexMatcher.emptyField(txtEmail.getText().trim());
        boolean cedulaIncorrecta = RegexMatcher.testcedula(txtcedula.getText());
        boolean telefonoIncorrecto=RegexMatcher.testcell(txtTelefono.getText());
        boolean matriculaIncorrecta=RegexMatcher.testMatricula(txtMatricula.getText());
        boolean userVacio= RegexMatcher.emptyField(txtUser.getText().trim());
        boolean passVacio=RegexMatcher.emptyField(txtPass.getText().trim());
        return !(nombreVacio ||apellidoVacio || tlefonoVacio || cedulaVacia || direccionVacia || matriculaVacia
                || emailVacio || passVacio || userVacio ||rbVacio);
        
        
    }
    
    private void guardarDatos(String usuario) throws SQLException{
        
        conectar=SingleConexionBD.conectar();
        String query1= usuario;
        CallableStatement  stmt = conectar.prepareCall(query1);
        stmt.setString("nombreUsuario", txtUser.getText());
        stmt.setString("nombre", txtNombres.getText());
        stmt.setString("apellido", txtApellidos.getText());
        stmt.setString("cedula", txtcedula.getText());
        stmt.setString("correo", txtEmail.getText());
        stmt.setString("direccion", txtDireccion.getText());
        stmt.setString("matricula", txtMatricula.getText());
        stmt.setBoolean("tieneWhatsapp", checkSi.isSelected());
        stmt.setString("telefono", txtTelefono.getText());
        

        stmt.executeQuery();
        System.out.println("datos ingresados con exito");
    }
    private void guardarUsuario(String rol) throws SQLException{
        String query="{CALL ingresarUsuario(?,?,?)}";
        CallableStatement  stmt=SingleConexionBD.conectar().prepareCall(query);
        stmt.setString("nombreUsuario",txtUser.getText().trim());
        stmt.setString("contrasena", txtPass.getText());
        stmt.setString("rol", rol);
        stmt.executeQuery();
        
    }
    private void seleccionRol(){
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (group.getSelectedToggle() != null) {
                rol=group.getSelectedToggle().getUserData().toString(); }
            }
        
    });
    }
    private void limpiarTextfield(){
        txtApellidos.clear();
        txtNombres.clear();
        txtDireccion.clear();
        txtMatricula.clear();
        txtUser.clear();
        txtPass.clear();
        txtEmail.clear();
        txtTelefono.clear();
        txtApellidos.clear();
        txtcedula.clear();
    }
    
    private void gotoLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/inicioSesion.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
}
