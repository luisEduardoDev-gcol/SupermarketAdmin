/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

import Models.Proveedor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProductoPerecedero extends Producto{

    private String fechaCaducidad;

    public ProductoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String fechaCaducidad, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, id_proveedor);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void calcularPrecio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fecha = LocalDate.parse(fechaCaducidad, formatter);
        LocalDate hoy = LocalDate.now();
        
        if(ChronoUnit.DAYS.between(hoy, fecha) < 3){
            this.setDescuento(75);
            this.setPrecio(this.getPrecio()*0.25);
        }else if(ChronoUnit.DAYS.between(hoy, fecha) < 5){
            this.setDescuento(50);
            this.setPrecio(this.getPrecio()*0.50);
        }
        
    }

    @Override
    public void mostrarInformacion() {

    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
