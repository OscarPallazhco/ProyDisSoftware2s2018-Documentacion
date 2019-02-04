/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danie
 */
public class BusquedaControllerTest {
    
    public BusquedaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test de metodo accionBuscar de BusquedaController con producto existente.
     */    
    @Test
    public void testBusquedaSimple() throws SQLException{
        System.out.println("Busqueda Simple con Producto existente");
        BusquedaController instancia = new BusquedaController();
        instancia.txtBuscar.setText("Mochila");
        instancia.accionBuscar(new ActionEvent());
        assertNotNull(instancia.coincidencias);
        assertNotNull(instancia.oblist);
    }
    
    /**
     * Test de metodo accionBuscar de BusquedaController con criterio no
     * valido de busqueda.
     */
    @Test
    public void testBusquedaVacia() throws SQLException{
        System.out.println("Busqueda Simple con pocos caracteres");
        BusquedaController instancia = new BusquedaController();
        instancia.txtBuscar.setText("Mo");
        instancia.accionBuscar(new ActionEvent());
        assertNotEquals(0,instancia.coincidencias.size());
        assertNotEquals(0,instancia.oblist.size());
    }
    
    /**
     * Test de metodo setDatos para verificar que la tabla 
     */
    @Test
    public void testLlenadoTabla() throws SQLException{
        System.out.println("Busqueda Simple con pocos caracteres");
        BusquedaController instancia = new BusquedaController();
        instancia.txtBuscar.setText("Mochila");
        instancia.accionBuscar(new ActionEvent());
        instancia.setDatos();
        assertNotEquals(0,instancia.tblviewBusqueda.getItems().size());
    }
    
}
