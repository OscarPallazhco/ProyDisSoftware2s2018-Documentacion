/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danie
 */
public class SingleConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/poliventas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    private static Connection instancia = null;
    
    public static Connection conectar(){
        try{
            if (instancia == null){
                Class.forName("com.mysql.jdbc.Driver");
                instancia = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASENA);               
                System.out.println("Todo bien mi son");
            }

        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error en la conexion: " + ex.getMessage());
        }
        return instancia;
    }
    
    public boolean desconectar(){
        try{
            instancia.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Error en desconectar: "+ex.getMessage());
        }
        return false;
    }
    
    public Connection getInstancia(){
        return this.instancia;
    }
}
