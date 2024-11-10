package Controllers;

import Exceptions.StockInsuficienteException;
import Models.Productos.Producto;
import Services.ProductoService;
import java.util.ArrayList;

public class ProductoController {

    ProductoService productoService;

    public ProductoController() {
        this.productoService = new ProductoService();
    }

    public void agregarProducto(Producto producto) throws RuntimeException{
        productoService.agregarProducto(producto);
    }
    
    public ArrayList<Producto> getProductos(int criterio, boolean esStockBajo){
        return productoService.getProductos(criterio, esStockBajo);
    }

    //actualizar
    public void editarProducto(Producto producto) {
        productoService.editarProducto(producto);
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        productoService.eliminarProducto(codProducto);
    }

    //buscar producto nombre
    public Producto buscarProductoNombre(String nombre) {
        return productoService.buscarProductoNombre(nombre);
    }

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        return productoService.buscarProductoCodigo(codProducto);
    }
    
    public void editarStock(int codProducto, int nuevoStock, int stockSeleccionado) throws StockInsuficienteException {
        productoService.editarStock(codProducto, nuevoStock, stockSeleccionado);
    }

    //buscar producto precio
    /*public Producto buscarProductoPrecio(int precio) {
        return productoService.buscarProductoPrecio(precio);
    }

    //buscar producto stock
    public Producto buscarProductoStock(int stock) {
        return productoService.buscarProductoStock(stock);
    }*/
}
