/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.PostresDelicias;

/**
 *
 * @author carlo
 */
public class ControladorPostresDelicias {
     protected static ArrayList<PostresDelicias> listDelicias = new ArrayList<>();
    
    public int buscar(String ID){
        for(int i=0;i<listDelicias.size();i++){
            if(ID.equals(listDelicias.get(i).getID())){
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
     * @param tipo
     * @param nombre
     * @param precio
     * @param cantidad
      */
    public void agregar(String ID, String tipo, String nombre, Double precio, Integer cantidad){
        try{
            if(!existe(ID)){
                listDelicias.add(new PostresDelicias(ID, tipo, nombre, precio, cantidad));
            }
        }catch(NumberFormatException e){
            System.out.println("Datos ingresados en el campo 'ID' deben ser números.");
        }
    }
    
    public void eliminar(String ID){
        if(existe(ID)){
            listDelicias.remove(listDelicias.get(buscar(ID)));
        }
    }
    
    
}
