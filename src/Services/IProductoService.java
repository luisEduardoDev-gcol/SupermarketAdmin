package Services;

import Exceptions.ListaVaciaException;
import Exceptions.StockInsuficienteException;
import Models.Productos.Producto;

import java.util.ArrayList;

public interface IProductoService {
    void agregarProducto(Producto producto);
    void editarProducto(Producto producto);
    void eliminarProducto(int codProducto);
    Producto buscarProductoNombre(String nombre);
    Producto buscarProductoCodigo(int codProducto);
    ArrayList<Producto> buscarProductoCriterio(String criterio) throws ListaVaciaException;
    ArrayList<Producto> getProductos(int criterio, boolean esStockBajo);
    void editarStock(int codProducto, int nuevoStock, int stockSeleccionado) throws StockInsuficienteException;
}
