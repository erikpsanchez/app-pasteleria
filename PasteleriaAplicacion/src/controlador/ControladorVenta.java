/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Venta;

/**
 *
 * @author leodz
 */
public class ControladorVenta {
    public static ArrayList<Venta> ventas = new ArrayList<>();
    public static ArrayList<Venta> ventaTemporal =  new ArrayList<>();
    
    public void agregarVenta(String cliente, String idProducto, String producto, Integer cantidad, Double precio){
        ventas.add(new Venta(cliente, idProducto, producto, cantidad, precio));
    }
    
    public void agregarVentaTemporal(String cliente, String idProducto, String producto, Integer cantidad, Double precio){
        ventaTemporal.add(new Venta(cliente, idProducto, producto, cantidad, precio));
    }
    
    public void eliminarVentaTemporal(Venta v){
        ventaTemporal.remove(v);
    }
}
