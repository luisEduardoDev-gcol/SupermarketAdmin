package Models;

import Models.Empleados.Cajero;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private int idVenta;
    private String fecha;
    private Cliente cliente;
    private double total;
    private Cajero cajero;
    private ArrayList<DetalleVenta> detallesVenta;
    
    public Venta(Cliente cliente, Cajero cajero, double total, ArrayList<DetalleVenta> detallesVenta) {
        this.idVenta = -1;
        this.fecha = LocalDate.now().toString();
        this.cliente = cliente;
        this.total = total;
        this.cajero = cajero;
        this.detallesVenta = detallesVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public ArrayList<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(ArrayList<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

   
}
