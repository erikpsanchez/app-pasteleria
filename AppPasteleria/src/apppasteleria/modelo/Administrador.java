/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria;

import java.util.ArrayList;

/**
 *
 * @author erikp
 */
public class Administrador extends Persona {
    private String password;
    
    public Administrador() {}
    
    public Administrador(String ID, String nombre, String apellido,String password) {
        super(ID, nombre, apellido);
        this.password = password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public String toString() {
        return super.toString()+ " Password: "+ "Sin Acceso";
    }
}
