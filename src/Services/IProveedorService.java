package Services;

import Exceptions.CamposVaciosException;
import Exceptions.EmailInvalidoException;
import Models.Proveedor;
import Models.Productos.Producto;

import java.util.ArrayList;

public interface IProveedorService {
    ArrayList<Proveedor> getProveedores();
    void agregarProveedor(Proveedor proveedor) throws EmailInvalidoException, CamposVaciosException;
    void eliminarProveedor(int idProveedor);
    void editarProveedor(Proveedor proveedor) throws EmailInvalidoException, CamposVaciosException;
    Proveedor buscarProveedorPorId(int idProveedor);
    ArrayList<Producto> buscarProductosProveedor(int idProveedor);
}
