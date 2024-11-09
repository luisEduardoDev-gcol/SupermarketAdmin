/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models.Productos.Factory;

import Models.Productos.Producto;

/**
 *
 * @author Simón David Cruz S
 */
public interface ProductoFactory {
    
    public Producto crearProducto(String categoria,int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Bebidas crearBebidas(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Congelados crearCongelados(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Farmaceuticos crearFarmaceuticos(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Higiene_y_Limpieza crearHigiene_y_Limpieza(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Mascotas crearMascotas(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
    
    public Panaderia_y_Pasteleria crearPanaderia_y_Pasteleria(int codigoProduto, String nombreProducto, double precio, int stock, String fecha, int id_proveedor);
}
