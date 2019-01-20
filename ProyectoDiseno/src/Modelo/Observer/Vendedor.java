/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Observer;

import Modelo.Producto;
import Modelo.Usuario;
import java.util.LinkedList;

/**
 *
 * @author OscarPallazhco
 */
public class Vendedor extends Usuario{

    private float calificacion;
    private LinkedList<Producto> productos;

    public Vendedor(String nombreUsuario, String contrasena, String nombre, String apellido, String celular, String correo, String direccion, String cedula, String matricula, String estado, boolean tieneWs) {
        super(nombreUsuario, contrasena, nombre, apellido, celular, correo, direccion, cedula, matricula, estado, tieneWs);
        this.calificacion = 0;
        this.productos = new LinkedList<>();
        
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }
    
    public boolean eliminarProducto(Producto p){
        return true;
    }
    
    public boolean modificarProducto(Producto p){
        return true;
    }
    
    public LinkedList<Producto> ventasPend(){
        LinkedList<Producto> result =new LinkedList<>();
        return result;
    }
    
    public String dirEntregaProd(Producto p){
        return "";
    }
    
    
}
