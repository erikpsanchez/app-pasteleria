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
public class Administrador extends Persona {
    private String password;
    
    /**
 * Constructor por defecto de la clase Administrador
 */
    public Administrador() {}
    
    /**
 * Constructor de la clase Administrador. 
 * @param ID
 * @param nombre
 * @param apellido
 * @param password 
 */ 
    public Administrador(String ID, String nombre, String apellido,String password) {
        super(ID, nombre, apellido);
        this.password = password;
    }
    
    /**
 * Método que asigna un valor al atributo password
 *@param password 
 */    
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
 * Método que devuelve el valor del atributo password
 * @return password
 */ 
    public String getPassword() {
        return this.password;
    }
    
    /**
 * Método que muestra la información de un objeto de la clase Administrador
 * @return String con los valores de todos los atributos de un objeto de la clase Administrador
 */ 
    @Override
    public String toString() {
        return  "ID: " + getID() +
                "Nombre: " + getNombre() +
                "Apellido: " + getApellido() + 
                "Password: " + getPassword();
    }
}
