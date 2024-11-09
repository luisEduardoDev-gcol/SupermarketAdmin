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
public class CongeladosNoPerecedero extends ProductoNoPerecedero implements Congelados{
    
    public CongeladosNoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }
    
    
}
