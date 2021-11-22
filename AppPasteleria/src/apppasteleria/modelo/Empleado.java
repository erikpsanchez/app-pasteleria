/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.modelo;

import apppasteleria.Persona;
import java.util.ArrayList;

/**
 *
 * @author erikp
 */
public class Empleado extends Persona {
    public Empleado() {}
    
    public Empleado(String ID, String nombre, String apellido) {
        super(ID, nombre, apellido);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
