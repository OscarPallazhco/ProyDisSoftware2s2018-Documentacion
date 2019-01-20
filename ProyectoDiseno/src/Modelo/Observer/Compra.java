/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Observer;

import Modelo.Comprador;
import Modelo.Producto;
import Modelo.Strategy.PagoStrategy;
import java.util.Date;

/**
 *
 * @author OscarPallazhco
 */
public class Compra {
    
    private String id, dirEntrega;
    private Date fecha;
    private PagoStrategy pago;
    private Comprador comprador;
    private Producto producto;
    private boolean entregado, pagado, estado;
    private float califVend, califProd;

    public Compra(String id, String dirEntrega, PagoStrategy pago, Comprador comprador, Producto producto, boolean entregado, boolean pagado, boolean estado) {
        this.id = id;
        this.dirEntrega = dirEntrega;
        this.pago = pago;
        this.comprador = comprador;
        this.producto = producto;
        this.entregado = entregado;
        this.pagado = pagado;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirEntrega() {
        return dirEntrega;
    }

    public void setDirEntrega(String dirEntrega) {
        this.dirEntrega = dirEntrega;
    }

    public PagoStrategy getPago() {
        return pago;
    }

    public void setearPagado(PagoStrategy pago) {
        this.pago = pago;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public float getCalifVend() {
        return califVend;
    }

    public void setCalifVend(float califVend) {
        this.califVend = califVend;
    }

    public float getCalifProd() {
        return califProd;
    }

    public void setCalifProd(float califProd) {
        this.califProd = califProd;
    }
  
    
    public boolean notificarVendedor(){
        return true;
    }

}
