/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Maria Belen Couoh Chan
 * @author Leandro Angel Dzib Nauat
 * @author Erik Alejandro Poot Sánchez
 * @author Carlos Fernando Sánchez Chuc
 */
public class Empleado extends Persona {
    
    /**
 * Constructor por defecto de la clase Empleado
 */  
    public Empleado() {}
    
    /**
 * Constructor de la clase Empleado
 * @param ID
 * @param nombre
 * @param apellido 
 */  
    public Empleado(String ID, String nombre, String apellido) {
        super(ID, nombre, apellido);
    }
    
    /**
 * Método que muestra la información de un objeto de la clase Empleado
 * @return String con los valores de todos los atributos de un objeto de la clase Empleado
 */   
    @Override
    public String toString() {
        return  "ID: " + getID() +
                "Nombre: " + getNombre() +
                "Apellido: " + getApellido();
    }
}

