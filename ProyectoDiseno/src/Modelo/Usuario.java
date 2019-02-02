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
public abstract class Usuario {

    private String nombreUsuario,contrasena, nombre, apellido, celular,
                        correo, direccion, cedula, matricula,estado;
    private boolean tieneWs;

    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String celular, String correo, String direccion, String cedula, String matricula, String estado, boolean tieneWs) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.cedula = cedula;
        this.matricula = matricula;
        this.estado = estado;
        this.tieneWs = tieneWs;
    }
    public Usuario(String nombreUser){
        this.nombreUsuario=nombreUser;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isTieneWs() {
        return tieneWs;
    }

    public void setTieneWs(boolean tieneWs) {
        this.tieneWs = tieneWs;
    }
    
    

    public void login(){

    }
    
    public void logout(){

    }


}

