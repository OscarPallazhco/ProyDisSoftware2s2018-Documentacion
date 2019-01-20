/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author OscarPallazhco
 */
public class Administrador extends Usuario{
    
    public Administrador(String nombreUsuario, String contrasena, String nombre, String apellido, String celular, String correo, String direccion, String cedula, String matricula, String estado, boolean tieneWs) {
        super(nombreUsuario, contrasena, nombre, apellido, celular, correo, direccion, cedula, matricula, estado, tieneWs);
    }
    
    public boolean cambiarRol(Usuario usuario){
        return true;
    }
    
    public Usuario buscarUsuario(String nombreUsuario){
     Usuario usuarioResult = null;      
     return usuarioResult;
    }
    
}
