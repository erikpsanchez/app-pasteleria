/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Maria Belen Couoh Chan
 * @author Leandro Angel Dzib Nauat
 * @author Erik Alejandro Poot Sánchez
 * @author Carlos Fernando Sánchez Chuc
 */
public class ControladorEmpleado {
    /**
     * ArrayList donde guardar a los clientes
     */
    public static ArrayList<Empleado> empleados = new ArrayList<>();
    
    /**
     * Método para buscar un cliente en el Array por ID
     * @param ID Identificador del cliente
     * @return Entero con la localización del cliente en el Array
     */
    public int buscar(String ID){
        for(int i=0;i<empleados.size();i++){
            if(ID.equals(empleados.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método para saber si existe un empleado en el Array por ID
     * @param ID Identificador del cliente
     * @return boolean
     */
    public boolean existe(String ID){
        if(buscar(ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método para agregar empleados
     * @param ID 
     * @param nombre
     * @param apellido
      */
    public void agregar(String ID, String nombre, String apellido){
        if(!existe(ID)){
            empleados.add(new Empleado(ID, nombre, apellido));
        }
    }
    
    /**
     * Método para eliminar un empleado del Array por ID
     * @param ID Identificador del cliente
     */
    public void eliminar(String ID){
        if(existe(ID)){
            empleados.remove(empleados.get(buscar(ID)));
        }
    }
}
