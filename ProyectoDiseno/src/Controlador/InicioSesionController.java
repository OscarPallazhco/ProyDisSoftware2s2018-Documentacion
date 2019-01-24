/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.RegexMatcher;
import utils.SingleConexionBD;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class InicioSesionController implements Initializable {

    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnRegistrar;
    
    private String dato;
    private LinkedList<DataUser> usuarios;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios=new LinkedList<>();
        try {
            cargarUsers();
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        // TODO
       
    
    @FXML
    private void accionLogin(ActionEvent event) throws IOException {
         boolean camposVacios=RegexMatcher.emptyField(txtUser.getText().trim()) || RegexMatcher.emptyField(txtPass.getText());
        if(!(camposVacios)){
            DataUser temp=null;
            for (DataUser usuario : usuarios) {
                if(usuario.getUser().equals(txtUser.getText().trim()) && usuario.getContrasena().equals(
                txtPass.getText())){
                    
                    temp=new DataUser(usuario.getUser(), usuario.getContrasena(), usuario.getRol());
                    
                }
            }
            if(temp!=null){
                if(temp.getRol().equals("Vendedor")){
                    gotoVendedor(event);
                }else if(temp.getRol().equals("Comprador")){
                    gotoComprador(event);
                }else{
                    goToAdmin(event);}
                }
                    
                }
            }
        

    
        
    

    @FXML
    private void accionRegistrar(ActionEvent event) throws IOException {
        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/registro.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    public void getDato(String dato){
        this.dato=dato;
    }
    private void cargarUsers() throws SQLException{
        
         String query="select * from Usuarios";
         Statement stmt=  SingleConexionBD.conectar().createStatement();
         ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String user= rs.getString("nombreUsuario");
            
            String pass=rs.getString("contrasena");
            String rol=rs.getString("rol");
            DataUser u= new DataUser(user, pass, rol);
            usuarios.add(u);

    }
    
}
    private void goToAdmin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesAdministrador.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
        
    }
    private void gotoComprador(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionesComprador.fxml"));
        
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        OpcionesCompradorController comp=loader.getController();
        comp.getUser(txtUser.getText());
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
        
    }
    private void gotoVendedor(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/opcionVendedor.fxml"));
        
        Parent homepParent=loader.load();
        OpcionVendedorController v=loader.getController();
        v.getUser(txtUser.getText());
        System.out.println(txtUser.getText() + " ventana iniciosension");
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
        
    }
}
