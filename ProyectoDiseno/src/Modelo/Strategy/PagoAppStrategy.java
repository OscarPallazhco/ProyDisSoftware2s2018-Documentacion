/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Strategy;

/**
 *
 * @author OscarPallazhco
 */
public class PagoAppStrategy implements PagoStrategy{
    

    @Override
    public boolean pagar(int monto) {
        return true;
    }
    
    public boolean recargar(int monto) {
        return true;
    }

    
}
