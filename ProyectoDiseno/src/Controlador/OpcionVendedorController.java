/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
public class OpcionVendedorController implements Initializable {

    @FXML
    private JFXButton btnComprar;
    @FXML
    private JFXButton btnVender;
    
    private String user;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(user + " ventana opcionVen init");
        // TODO
    }    
    public void getUser(String user){
        this.user=user;
    }
    @FXML
    private void accionComprar(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/Vista/opcionesComprador.fxml"));
        Parent homepParent=loader.load();

        Scene scene =new Scene(homepParent);
        OpcionesCompradorController op=loader.getController();
        op.getUser(user);
        Stage mainstage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        mainstage.hide();
        mainstage.setScene(scene);
        mainstage.show();
    }

    @FXML
    private void accionVender(ActionEvent event) throws IOException {
        System.out.println(user);
        FXMLLoader load=new FXMLLoader();
        load.setLocation(getClass().getResource("/Vista/opcionesVendedor.fxml"));
        load.load();
        OpcionesVendedorController v=load.getController();
        v.getUser(user);
       
        
        Parent p=load.getRoot();
        Stage s=new Stage();
        s.setScene(new Scene(p));
        s.show();
    
        
        
        
        
        



    }
     

}
    

