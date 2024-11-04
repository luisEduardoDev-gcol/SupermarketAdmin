/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProductoNoPerecedero extends Producto{

    private String duracionAlmacen;

    public ProductoNoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, id_proveedor);
        this.duracionAlmacen = duracionAlmacen;
    }

    @Override
    public void calcularPrecio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fecha = LocalDate.parse(duracionAlmacen, formatter);
        LocalDate hoy = LocalDate.now();
        
        if(ChronoUnit.DAYS.between(hoy, fecha) < 5){
            this.setDescuento(75);
            this.setPrecio(this.getPrecio()*0.25);
        }
        
    }

    @Override
    public void mostrarInformacion() {

    }

    public String getDuracionAlmacen() {
        return duracionAlmacen;
    }

    public void setDuracionAlmacen(String duracionAlmacen) {
        this.duracionAlmacen = duracionAlmacen;
    }
}
