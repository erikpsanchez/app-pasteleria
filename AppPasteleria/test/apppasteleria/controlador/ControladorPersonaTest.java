/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.controlador;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlo
 */
public class ControladorPersonaTest {
   
    /**
     * Test of buscarCliente method, of class ControladorPersona.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        String ID = "9861135534";
        ControladorPersona instance = new ControladorPersona();
        int expResult =-1;
        int result = instance.buscarCliente(ID);
        assertEquals(expResult , result);
        
    }

    /**
     * Test of buscarEmpleado method, of class ControladorPersona.
     */
    @Test
    public void testBuscarEmpleado() {
        System.out.println("buscarEmpleado");
        String ID = "20212030";
        ControladorPersona instance = new ControladorPersona();
        int expResult = -1;
        int result = instance.buscarEmpleado(ID);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of buscarAdministrador method, of class ControladorPersona.
     */
    @Test
    public void testBuscarAdministrador() {
        System.out.println("buscarAdministrador");
        String ID = "20304320";
        ControladorPersona instance = new ControladorPersona();
        int expResult = -1;
        int result = instance.buscarAdministrador(ID);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of existeCliente method, of class ControladorPersona.
     */
    @Test
    public void testExisteCliente() {
        System.out.println("existeCliente");
        String ID = "2030432";
        ControladorPersona instance = new ControladorPersona();
        boolean expResult = false;
        boolean result = instance.existeCliente(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeEmpleado method, of class ControladorPersona.
     */
    @Test
    public void testExisteEmpleado() {
        System.out.println("existeEmpleado");
        String ID = "2000021";
        ControladorPersona instance = new ControladorPersona();
        boolean expResult = false;
        boolean result = instance.existeEmpleado(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeAdministrador method, of class ControladorPersona.
     */
    @Test
    public void testExisteAdministrador() {
        System.out.println("existeAdministrador");
        String ID = "2000022";
        ControladorPersona instance = new ControladorPersona();
        boolean expResult = false;
        boolean result = instance.existeAdministrador(ID);
        assertEquals(expResult, result);
    }    
}
