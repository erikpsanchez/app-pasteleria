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
public class Postres_Delicias extends Producto{
    private String aniadidos;
    
    public Postres_Delicias(){}

    public Postres_Delicias(String ID, String tipo, String nombre, Double precio, Integer cantidad, String aniadidos){
        super(ID, tipo, nombre, precio, cantidad);
        this.aniadidos = aniadidos;
    }

    public String getAnadidos() {
        return this.aniadidos;
    }

    public void setAnadidos(String anadidos) {
        this.aniadidos = anadidos;
    }
    
    @Override
    public String toString() {
        return "ID=" + ID + ", tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", añadidos=" + aniadidos;
    }
    
}