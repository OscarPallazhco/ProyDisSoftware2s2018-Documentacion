/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Observer.Vendedor;

/**
 *
 * @author OscarPallazhco
 */
public class Producto {
    private String nombre, descripcion, categoria;
    private float calificacion, tiempoEntrega, precio;
    private Vendedor vendedor;
    private int vecesBuscado;
    private boolean estado; //para operaciones CRUD

    public Producto(String nombre, String descripcion, String categoria, float tiempoEntrega, float precio, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;
        this.vendedor = vendedor;
        this.vecesBuscado = 0;
        this.estado = true;
    }
    
        public Producto(String nombre, String descripcion, String categoria, float tiempoEntrega, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;
        
        this.vecesBuscado = 0;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public float getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(float tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getVecesBuscado() {
        return vecesBuscado;
    }

    public void setVecesBuscado(int vecesBuscado) {
        this.vecesBuscado = vecesBuscado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean eliminar(){
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", calificacion=" + calificacion + ", tiempoEntrega=" + tiempoEntrega + ", precio=" + precio + ", vendedor=" + vendedor + ", vecesBuscado=" + vecesBuscado + '}';
    }
    
    
    
    
}
