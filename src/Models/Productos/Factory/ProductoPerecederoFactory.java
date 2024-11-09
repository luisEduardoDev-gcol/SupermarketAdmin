/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos.Factory;

import Models.Productos.Producto;
import Models.Productos.ProductoPerecedero;

/**
 *
 * @author Simón David Cruz S
 */
public class ProductoPerecederoFactory implements ProductoFactory{
    
    @Override
    public Producto crearProducto(String categoria,int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) throws RuntimeException{
        if(categoria.equals("Bebidas")){
            return (Producto)crearBebidas(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }else if(categoria.equals("Congelados")){
            return (Producto)crearCongelados(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }else if(categoria.equals("Farmaceuticos")){
            return (Producto)crearFarmaceuticos(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }else if(categoria.equals("Higiene y Limpieza")){
            return (Producto)crearHigiene_y_Limpieza(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }else if(categoria.equals("Mascotas")){
            return (Producto)crearMascotas(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }else if(categoria.equals("Panaderia y Pasteleria")){
            return (Producto)crearPanaderia_y_Pasteleria(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
        }
        throw new RuntimeException("Categoria de producto inexsitente");
    }
    
    @Override
    public Bebidas crearBebidas(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new BebidasPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }

    @Override
    public Congelados crearCongelados(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new CongeladosPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }

    @Override
    public Farmaceuticos crearFarmaceuticos(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new FarmaceuticosPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }

    @Override
    public Higiene_y_Limpieza crearHigiene_y_Limpieza(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new Higiene_y_LimpiezaPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }

    @Override
    public Mascotas crearMascotas(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new MascotasPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }

    @Override
    public Panaderia_y_Pasteleria crearPanaderia_y_Pasteleria(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        return new Panaderia_y_PasteleriaPerecedero(codigoProduto, nombreProducto, precio, stock, duracionAlmacen, id_proveedor);
    }
}
