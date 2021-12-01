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
    
    public int buscar(String ID){
        for(int i=0;i<clientes.size();i++){
            if(ID.equals(clientes.get(i).getID())){
                return i;
            }
        }
        return -1;
    }
    
    public boolean existe(String ID){
        if(buscar(ID) != -1){
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
    public void agregar(String ID, String nombre, String apellido, Integer sweetpoints){
        try{
            if(!existe(ID)){
                clientes.add(new Cliente(ID, nombre, apellido, sweetpoints));
            }
        }catch(NumberFormatException e){
            System.out.println("Datos ingresados en el campo 'sweetpoints' deben ser números.");
        }
    }
    
    public void eliminar(String ID){
        if(existe(ID)){
            clientes.remove(clientes.get(buscar(ID)));
        }
    }
    
    public Integer convertirVentaASweetpoints(Double venta){
        Integer sweetpoints = 0;
        if(venta<50){
            sweetpoints = 0;
        }else if(venta>=50 && venta<75){
            sweetpoints = 2;
        }else if(venta>=75 && venta <150){
            sweetpoints = 3;
        }else if(venta>=150){
            sweetpoints = 5;
        }
        
        return sweetpoints;
    }
    
    
}
