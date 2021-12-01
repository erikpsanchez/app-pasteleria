/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Administrador;

/**
 *
 * @author belen
 */
public class ControladorAdministrador {
    protected static ArrayList<Administrador> administradores = new ArrayList<>();
    
    public int buscar(String ID){
        for(int i=0; i<administradores.size(); i++){
            if(ID.equals(administradores.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    public boolean existe(String ID){
        if(buscar (ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
      * Método para agregar administradores
     * @param ID 
     * @param nombre
     * @param apellido
     * @param password
      */
    public void agregar(String ID, String nombre, String apellido,String password){
        if(!existe(ID)){
            administradores.add(new Administrador(ID, nombre, apellido, password));
        }
    }
    
    public void eliminar(String ID){
        if(existe(ID)){
            administradores.remove(administradores.get(buscar(ID)));
        }
    }
    
}
