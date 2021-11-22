/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.modelo;

/**
 *
 * @author erikp
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
