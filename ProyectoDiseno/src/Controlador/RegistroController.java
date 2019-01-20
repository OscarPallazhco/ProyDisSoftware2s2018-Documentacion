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
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbVendedor.setToggleGroup(group);
        rbComprador.setToggleGroup(group);
        // TODO
         
       
    }    

    @FXML
    private void accionRegistrar(ActionEvent event) throws SQLException {
        
        if(validarTextField()){
            guardarDatos();
        }

    }

    @FXML
    private void accionCancelar(ActionEvent event) {
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
    
    private void guardarDatos() throws SQLException{
        
        conectar=SingleConexionBD.conectar();
        String query1= "{CALL ingresarComprador(?,?,?,?,?,?,?,?)}";
        CallableStatement  stmt = conectar.prepareCall(query1);
        stmt.setString("nombreUsuario", txtUser.getText());
        stmt.setString("nombre", txtNombres.getText());
        stmt.setString("apellido", txtApellidos.getText());
        stmt.setString("cedula", txtcedula.getText());
        stmt.setString("correo", txtEmail.getText());
        stmt.setString("direccion", txtDireccion.getText());
        stmt.setString("matricula", txtMatricula.getText());
        stmt.setBoolean("tieneWhatsapp", checkSi.isSelected());

        stmt.executeQuery();
        System.out.println("datos ingresados con exito");
    }
}
