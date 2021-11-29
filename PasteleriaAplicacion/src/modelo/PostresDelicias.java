/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author leodz
 */
public class PostresDelicias extends Producto{
    private String aniadidos;
    
    /**
 * Constructor por defecto de la clase Postres_Delicias
 */  
    public PostresDelicias(){}

    /**
 * Constructor de la clase Postres_Delicias
 * @param ID
 * @param tipo
 * @param nombre
 * @param precio
 * @param cantidad
 * @param aniadidos
 */ 
    public PostresDelicias(String ID, String tipo, String nombre, Double precio, Integer cantidad, String aniadidos){
        super(ID, tipo, nombre, precio, cantidad);
        this.aniadidos = aniadidos;
    }

    /**
 * Método que devuelve el valor del atributo aniadidos
 * @return aniadidos
 */
    public String getAnadidos() {
        return this.aniadidos;
    }

    /**
 * Método que asigna un valor al atributo aniadidos
 * @param aniadidos
 */
    public void setAnadidos(String aniadidos) {
        this.aniadidos = aniadidos;
    }
    
    /**
 * Método que muestra la información de un objeto de la clase Postres_Delicias
 * @return String con los valores de todos los atributos de un objeto de la clase Postres_Delicias
 */
    @Override
    public String toString() {
        return "ID=" + ID + ", tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", añadidos=" + aniadidos;
    }
    
}