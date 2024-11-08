package Services;

import Dao.VentaDAO;
import Models.DetalleVenta;
import Models.Venta;

import java.util.ArrayList;

public class VentaService {
    //ArrayList<Venta> ventas;
    VentaDAO ventaDAO;

    public VentaService() {
        //this.ventas = ventas;
        this.ventaDAO = new VentaDAO();
    }

    //version de prueba
    public void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles) {
        ventaDAO.agregarVenta(venta, detalles);
    }
    
    public ArrayList<Venta> getVentas(){
        return this.ventaDAO.getVentas();
    }
}
