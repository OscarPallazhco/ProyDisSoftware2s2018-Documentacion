/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Patricio
 */
public class OpcionesVendedorController implements Initializable {

    @FXML
    private JFXButton btnMisVentas;
    @FXML
    private JFXButton btnMisProductos;
    @FXML
    private JFXButton btnCerrarSesion;
    
    String user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    

    @FXML
    private void accionMisVentas(ActionEvent event) throws IOException {
        
        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/ventaspendientes.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    
    }
    
    public void getUser(String us){
        this.user=us;
    }

    @FXML
    private void accionMisproductos(ActionEvent event) throws IOException, SQLException {
        
        FXMLLoader load=new FXMLLoader();
        load.setLocation(getClass().getResource("/Vista/misproducts.fxml"));
        load.load();
        MisproductsController productos=load.getController();
        productos.setUserName(user);
        
        Parent p=load.getRoot();
        Stage s=(Stage) ((Node)event.getSource()).getScene().getWindow();
        s.setScene(new Scene(p));
        s.show();
        
        
      

    }
    

    @FXML
    private void accionCerrar(ActionEvent event) throws IOException {
        Parent homepParent=FXMLLoader.load(getClass().getResource("/Vista/inicio.fxml"));
        Scene scene =new Scene(homepParent);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }
    
}
