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
public class Pasteles extends Producto{
    private String tamano;
    private String sabor;
    
    /**
 * Constructor por defecto de la clase Pasteles
 */  
    public Pasteles(){}

      /**
 * Constructor de la clase Pasteles
 * @param ID
 * @param tipo
 * @param nombre
 * @param precio
 * @param cantidad
 * @param tamano
 * @param sabor
 */  
    public Pasteles(String ID, String tipo, String nombre, Double precio, Integer cantidad, String tamano, String sabor){
        super(ID, tipo, nombre, precio, cantidad);
        this.tamano = tamano;
        this.sabor = sabor;
    }

      /**
 * Método que devuelve el valor del atributo tamano
 * @return tamano
 */
    public String getTamano() {
        return this.tamano;
    }

      /**
 * Método que asigna un valor al atributo tamano
 * @param tamano
 */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

      /**
 * Método que devuelve el valor del atributo sabor
 * @return sabor
 */
    public String getSabor() {
        return this.sabor;
    }

      /**
 * Método que asigna un valor al atributo sabor
 * @param sabor
 */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    /**
 * Método que muestra la información de un objeto de la clase Pasteles
 * @return String con los valores de todos los atributos de un objeto de la clase Pasteles
 */
    @Override
    public String toString() {
        return "ID=" + ID + ", tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", tamaño=" + tamano + ", sabor=" + sabor;
    }
     
}
