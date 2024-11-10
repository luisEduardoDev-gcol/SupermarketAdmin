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
public class MascotasNoPerecedero extends ProductoNoPerecedero implements Mascotas{
    
    public MascotasNoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }
    
}
