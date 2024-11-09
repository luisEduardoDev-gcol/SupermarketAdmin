/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.DetalleVenta;
import Models.Productos.Producto;
import Models.Venta;
import Services.ProductoService;
import Services.VentaService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Simón David Cruz S
 */
public class VentaController {
    VentaService vs;
    ProductoService ps;

    public VentaController() {
        this.vs = new VentaService();
        this.ps = new ProductoService();
    }

    public void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles) {
        vs.agregarVenta(venta, detalles);
    }

    public ArrayList<Venta> getVentas() {
        return this.vs.getVentas();
    }

    public ArrayList<Venta> filtrarVentas(String filtro) {
        return this.vs.filtrarVentas(filtro);
    }

    public ArrayList<Producto> getProductos() {
        return this.ps.getProductos(0, false);
    }

    public ArrayList<Producto> filtrarProductosMasVendidos(String filtro) {
        ArrayList<Venta> ventas = this.vs.filtrarVentas(filtro);

        Map<Producto, Integer> productoVentasCount = new HashMap<>();

        for (Venta venta : ventas) {
            ArrayList<DetalleVenta> detalles = venta.getDetallesVenta();

            for (DetalleVenta detalle : detalles) {
                Producto producto = detalle.getProducto();

                productoVentasCount.put(producto, productoVentasCount.getOrDefault(producto, 0) + detalle.getCantidad());
            }
        }

        ArrayList<Producto> productosMasVendidos = new ArrayList<>(productoVentasCount.keySet());
        productosMasVendidos.sort((p1, p2) -> productoVentasCount.get(p2).compareTo(productoVentasCount.get(p1)));

        return productosMasVendidos;
    }


}