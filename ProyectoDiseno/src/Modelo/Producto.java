/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Observer.Vendedor;
import java.util.Objects;

/**
 *
 * @author OscarPallazhco
 */
public class Producto {
    private String nombre, descripcion, categoria;
    private float calificacion, tiempoEntrega, precio;
    private Vendedor vendedor;
    private int vecesBuscado,id;
    private boolean estado; //para operaciones CRUD

    public Producto(String nombre, String descripcion, String categoria, float tiempoEntrega, float precio, int id,Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;
        this.vendedor = vendedor;
        this.vecesBuscado = 0;
        this.estado = true;
        this.id=id;
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
        public Producto(String nombre, String descripcion, String categoria, float tiempoEntrega, float precio,int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;
        this.id=id;
        this.vecesBuscado = 0;
        this.estado = true;
    }
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

  /*  public Vendedor getVendedor() {
        return vendedor;
    } */

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.descripcion);
        hash = 47 * hash + Objects.hashCode(this.categoria);
        hash = 47 * hash + Float.floatToIntBits(this.tiempoEntrega);
        hash = 47 * hash + Float.floatToIntBits(this.precio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Float.floatToIntBits(this.tiempoEntrega) != Float.floatToIntBits(other.tiempoEntrega)) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }
    public String getVendedor(){
        return vendedor.getNombreUsuario();
    }
    
    
    
    
}
