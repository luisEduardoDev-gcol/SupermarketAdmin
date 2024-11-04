/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Empleados;

import Models.DetalleVenta;
import java.util.ArrayList;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Cajero extends Empleado{
    
    private String turno;
    private ArrayList<DetalleVenta> carrito;
    
    public Cajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno){
        super(idEmpleado, nombreCompleto, correo, salarioMensual);
        this.turno = turno;
        this.carrito = new ArrayList<>();
    }
    
    @Override
    public double calcularSalario(){
        return this.salarioMensual;
    }

    public String getTurno(){
        return turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }

    public ArrayList<DetalleVenta> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<DetalleVenta> carrito) {
        this.carrito = carrito;
    }
    
    
}
