package Services;

import Dao.ProductoDAO;
import Exceptions.StockInsuficienteException;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;

import java.util.ArrayList;

public class ProductoService {
    /*README-------------------------------------------------------------
    * 1. Cuando se realice una venta, se le resta el stock seleccionado
    * por el cliente al stock del producto en el arrayList.
    *
    * 2. Se debe retornar el producto con el numero de stock seleccionado por el cliente,
//    * (cantidad comprada de ese producto) y este retornado, a su ves agregado al arrayList de
//    * productos de la venta, la venta entrara en el historial del cliente(ArryList de ventas).
    * */
    private ProductoDAO pd;
    
    public ProductoService() {
        this.pd = ProductoDAO.getInstancia();
    }
    

    //metodo registrar(validar no mismo codigo)
    public void agregarProducto(Producto producto) {
        if (producto instanceof ProductoPerecedero){
            pd.agregarProductoPerecedero((ProductoPerecedero)producto);
        }else if(producto instanceof ProductoNoPerecedero){
            pd.agregarProductoNoPerecedero((ProductoNoPerecedero)producto);
        }
    }
    
    //actualizar
    public void editarProducto(Producto producto) {
        pd.editarProducto(0, producto);
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        pd.eliminarProducto(codProducto);
    }

    //buscar producto nombre
    public Producto buscarProductoNombre(String nombre) {
        return pd.buscarProductoNombre(nombre);
    }

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        return pd.buscarProductoCodigo(codProducto);
    }
    
    public ArrayList<Producto> getProductos(int criterio, boolean esStockBajo){
        String buffer = criterio == 0? "codigo_producto" : criterio == 1? "nombre": criterio == 2? "precio":"stock";
        return pd.getProductos(buffer, esStockBajo);
    }
    public void editarStock(int codProducto, int nuevoStock, int stockSeleccionado) throws StockInsuficienteException {
        if (nuevoStock<=stockSeleccionado) throw new StockInsuficienteException("El stock puesto debe ser mayor al anterior");
        pd.actualizarStockProducto(codProducto, nuevoStock);
    }

}
