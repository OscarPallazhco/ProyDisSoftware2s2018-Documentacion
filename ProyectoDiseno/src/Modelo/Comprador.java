/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Observer.Compra;
import java.util.LinkedList;

/**
 *
 * @author OscarPallazhco
 */
public class Comprador extends Usuario{
    
    private float saldo;
    private LinkedList<Compra> compras;

    public Comprador(String nombreUsuario, String contrasena, String nombre, String apellido, String celular, String correo, String direccion, String cedula, String matricula, String estado, boolean tieneWs, float saldo) {
        super(nombreUsuario, contrasena, nombre, apellido, celular, correo, direccion, cedula, matricula, estado, tieneWs);
        this.saldo = saldo;
        this.compras = new LinkedList<>();
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public LinkedList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(LinkedList<Compra> compras) {
        this.compras = compras;
    }
    
    public boolean comprar(Producto p){
        return true;
    }
    
    public LinkedList<Compra> buscarComprasProd(String nombreProd){
        LinkedList<Compra> result =new LinkedList<>();
        return result;
    }
    
    public LinkedList<Compra> buscarComprasVend(String nombreVend){
        LinkedList<Compra> result =new LinkedList<>();
        return result;
    }

    public LinkedList<Compra> buscarComprasPend(){
        LinkedList<Compra> result =new LinkedList<>();
        return result;
    }

}
