/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.DetalleVenta;
import Models.Venta;
import Services.VentaService;
import java.util.ArrayList;

/**
 *
 * @author Simón David Cruz S
 */
public class VentaController {
    VentaService vs;

    public VentaController() {
        this.vs = new VentaService();
    }
    
    public void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles) {
        vs.agregarVenta(venta, detalles);
    }
}
