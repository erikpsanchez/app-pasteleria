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
public class Producto {
    protected String ID;
    protected String tipo;
    protected String nombre;
    protected Double precio;
    protected Integer cantidad;
    
    /**
 * Constructor por defecto de la clase Producto
 */  
    public Producto(){}

    /**
 * Constructor de la clase Producto
 * @param ID
 * @param tipo
 * @param nombre
 * @param precio
 * @param cantidad
 */ 
    public Producto(String ID, String tipo, String nombre, Double precio, Integer cantidad){
        this.ID = ID;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
/**
 * Método que devuelve el valor del atributo ID
 * @return ID
 */
    public String getID() {
        return this.ID;
    }
    
 /**
 * Método que asigna un valor al atributo ID
 * @param ID
 **/
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
 * Método que devuelve el valor del atributo tipo
 * @return tipo
 */
    public String getTipo() {
        return this.tipo;
    }

    /**
 * Método que asigna un valor al atributo tipo
 * @param tipo
 **/
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
   /**
 * Método que devuelve el valor del atributo nombre
 * @return nombre
 */
    public String getNombre() {
        return this.nombre;
    }

       /**
 * Método que asigna un valor al atributo nombre
 * @param nombre
 **/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
 * Método que devuelve el valor del atributo precio
 * @return precio
 */
    public Double getPrecio() {
        return this.precio;
    }
    
       /**
 * Método que asigna un valor al atributo precio
 * @param precio
 **/
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

      /**
 * Método que devuelve el valor del atributo cantidad
 * @return cantidad
 */
    public Integer getCantidad() {
        return this.cantidad;
    }

    /**
 * Método que asigna un valor al atributo cantidad
 * @param cantidad
 **/
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
}