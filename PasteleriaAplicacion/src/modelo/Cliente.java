/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author leodz
 */
public class Cliente extends Persona {
    private Integer sweetpoints;
    
    /**
 * Constructor por defecto de la clase Cliente
 */
    public Cliente() {}
    
    /**
 * Constructor de la clase Cliente
 * @param ID
 * @param nombre
 * @param apellido
 * @param sweetpoints 
 */ 
    public Cliente(String ID, String nombre, String apellido, Integer sweetpoints) {
        super(ID, nombre, apellido);
        this.sweetpoints = sweetpoints;
    }
    
    /**
 * Método que asigna un valor al atributo sweetpoints
 * @param sweetpoints 
 */
    public void setSweetpoints(Integer sweetpoints) {
        this.sweetpoints = sweetpoints;
    }
    
    /**
 * Método que devuelve el valor del atributo sweetpoints
 * @return sweetpoints
 */
    public Integer getSweetpoints() {
        return this.sweetpoints;
    }
    
    /**
 * Método que muestra la información de un objeto de la clase Cliente
 * @return String con los valores de todos los atributos de un objeto de la clase Cliente
 */
    @Override
    public String toString() {
        return  "ID: " + getID() +
                "; Nombre: " + getNombre() +
                "; Apellido: " + getApellido() + 
                "; Sweetpoints: " + getSweetpoints();
    }
    
    
    
}

