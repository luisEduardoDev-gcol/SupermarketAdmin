/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Productos.Producto;

/**
 *
 * @author Simón David Cruz S
 */
public class DetalleVenta {
    int idDetalle;
    int idVenta;
    Cliente cliente;
    Producto producto;
    int cantidad;
    double precio;

    private static int cont = 0;
    
    public DetalleVenta(Cliente cliente, Producto producto, int cantidad) {
        this.idDetalle = cont;
        this.idVenta = -1;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = producto.getPrecio() * cantidad;
        
        cont++;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
    
}
