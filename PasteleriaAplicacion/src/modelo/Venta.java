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
public class Venta {
    private String cliente;
    private String idProducto;
    private String producto;
    private Integer cantidad;
    private Double precio;

    public Venta(String cliente, String idProducto, String producto, Integer cantidad, Double precio) {
        this.cliente = cliente;
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "cliente=" + this.cliente + ", idProducto=" + this.idProducto + ", producto=" + this.producto + ", cantidad=" + this.cantidad + ", precio=" + this.precio;
    }
    
    
    
    
}
