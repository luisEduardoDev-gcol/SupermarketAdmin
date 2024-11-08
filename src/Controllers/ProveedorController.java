/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Exceptions.CamposVaciosException;
import Exceptions.EmailInvalidoException;
import Models.Proveedor;
import Models.Productos.Producto;

import Services.ProveedorService;
import java.util.ArrayList;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProveedorController {
    private ProveedorService proveedorService;
    
    public ProveedorController() {
        proveedorService = new ProveedorService();
    }
    
    public void agregarProveedor(Proveedor proveedor) throws EmailInvalidoException, CamposVaciosException {
        proveedorService.agregarProveedor(proveedor);
    }

    public void eliminarProveedor(int idProveedor){
        proveedorService.eliminarProveedor(idProveedor);
    }

    public void editarProveedor(Proveedor proveedor) throws EmailInvalidoException, CamposVaciosException  {
        proveedorService.editarProveedor(proveedor);
    }
    
    public Proveedor buscarProveedorPorId(int idProveedor){
        return proveedorService.buscarProveedorPorId(idProveedor);
    }
    
    public ArrayList<Producto> buscarProductosProveedor(int idProveedor) {
        return proveedorService.buscarProductosProveedor(idProveedor);
    }
    
    public ArrayList<Proveedor> getProveedores() {
        return proveedorService.getProveedores();
    }
}
