/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

import Models.Proveedor;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public abstract class Producto {
    
    private int codigoProducto;
    private String nombreProducto;
    private double precio;
    private int stock;
    private int id_proveedor;
    private double descuento;
    private String categoria;

    public Producto(int codigoProducto, String nombreProducto, double precio, int stock, int id_proveedor) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.id_proveedor = id_proveedor;
        this.precio = precio;
        this.descuento = 0;
    }


    //

    public abstract void calcularPrecio();

    public abstract void mostrarInformacion();
    
    public void setCodigoProducto(int codigoProducto){
        this.codigoProducto = codigoProducto;
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
    }
    
    public void setNombreProducto(String nombreProducto){ 
        this.nombreProducto = nombreProducto;
    }
    
    public String getNombreProducto(){
        return this.nombreProducto;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public int getStock(){
        return this.stock;
    }

    public int getIdProveedor() {
        return id_proveedor;
    }

    public void setIdProveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }



    
}
