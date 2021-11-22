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
public class Persona {
    private String ID;
    private String nombre;
    private String apellido;
    
    /**
 * Constructor por defecto de la clase Persona
 */  
    public Persona() {}
    
   /**
 * Constructor de la clase Persona
 * @param ID
 * @param nombre
 * @param apellido 
 */    
    public Persona(String ID, String nombre, String apellido) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    /**
 * Método que asigna un valor al atributo ID
 * @param ID 
 */  
    public void setID(String ID) {
        this.ID = ID;
    }
    
    /**
 * Método que devuelve el valor del atributo ID
 * @return ID
 */    
    public String getID() {
        return this.ID;
    }
    
    /**
 * Método que asigna un valor al atributo nombre
 * @param nombre 
 */    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
 * Método que devuelve el valor del atributo nombre
 * @return nombre
 */    
    public String getNombre() {
        return this.nombre;
    }
    
    /**
 * Método que asigna un valor al atributo apellido
 * @param apellido
 */   
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
 * Método que devuelve el valor del atributo apellido
 * @return apellido
 */
    public String getApellido() {
        return this.apellido;
    }
    
}
