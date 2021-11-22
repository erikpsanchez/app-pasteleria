/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppasteleria.modelo;

import apppasteleria.Persona;
import apppasteleria.Persona;
import java.util.ArrayList;

/**
 *
 * @author erikp
 */
public class Cliente extends Persona {
    private Integer sweetpoints;
    
    public Cliente() {}
    
    public Cliente(String ID, String nombre, String apellido, Integer sweetpoints) {
        super(ID, nombre, apellido);
        this.sweetpoints = sweetpoints;
    }
    
    public void setSweetpoints(Integer sweetpoints) {
        this.sweetpoints = sweetpoints;
    }
    
    public Integer getSweetpoints() {
        return this.sweetpoints;
    }
    
    @Override
    public String toString() {
        return super.toString()+ " SweetPoints acumulados:" + sweetpoints;
    }
}
