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

    public Pasteles(String ID, String tipo, String nombre, Double precio, Integer cantidad, String tamano, String sabor){
        super(ID, tipo, nombre, precio, cantidad);
        this.tamano = tamano;
        this.sabor = sabor;
    }

    public String getTamano() {
        return this.tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getSabor() {
        return this.sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    @Override
    public String toString() {
        return "ID=" + ID + ", tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", tamaño=" + tamano + ", sabor=" + sabor;
    }
    
    
    
}
