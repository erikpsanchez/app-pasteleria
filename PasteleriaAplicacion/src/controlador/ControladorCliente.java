/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author leodz
 */
public class ControladorCliente {
    protected static ArrayList<Cliente> clientes = new ArrayList<>();
    
    public int buscarCliente(String ID){
        for(int i=0;i<clientes.size();i++){
            if(ID.equals(clientes.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    public boolean existeCliente(String ID){
        if(buscarCliente(ID) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
      * Método para agregar clientes
     * Lanza la excepción NumberFormatException para detectar si en el atributo de sweetpoint se ingresa algo que no sea un número.
     * @param ID 
     * @param nombre
     * @param apellido
     * @param sweetpoints
      */
    public void agregarCliente(String ID, String nombre, String apellido, Integer sweetpoints){
        try{
            if(!existeCliente(ID)){
                clientes.add(new Cliente(ID, nombre, apellido, sweetpoints));
            }
        }catch(NumberFormatException e){
            System.out.println("Datos ingresados en el campo 'sweetpoints' deben ser números.");
        }
    }
    
    public void eliminarCliente(String ID){
        if(existeCliente(ID)){
            clientes.remove(clientes.get(buscarCliente(ID)));
        }
    }
    
}
