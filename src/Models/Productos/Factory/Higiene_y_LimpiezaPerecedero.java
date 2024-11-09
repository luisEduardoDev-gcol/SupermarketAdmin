/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos.Factory;

import Models.Productos.ProductoPerecedero;

/**
 *
 * @author Simón David Cruz S
 */
public class Higiene_y_LimpiezaPerecedero extends ProductoPerecedero implements Higiene_y_Limpieza{
    
    public Higiene_y_LimpiezaPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String fechaCaducidad, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, fechaCaducidad, id_proveedor);
    }
    
}
