/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria;

/**
 *
 * @author erikp
 */
public class Persona {
    private String ID;
    private String nombre;
    private String apellido;
    
    public Persona() {}
    
    public Persona(String ID, String nombre, String apellido) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
}
