/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos.Factory;

import Models.Productos.ProductoNoPerecedero;

/**
 *
 * @author Simón David Cruz S
 */
public class Panaderia_y_PasteleriaNoPerecedero extends ProductoNoPerecedero implements Panaderia_y_Pasteleria{
    
    public Panaderia_y_PasteleriaNoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }
    
}
