package Services;

import Dao.VentaDAO;
import Models.DetalleVenta;
import Models.Venta;

import java.util.ArrayList;

public class VentaService {
    VentaDAO ventaDAO;

    public VentaService() {
        this.ventaDAO = VentaDAO.getInstancia();
    }


    public void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles) {
        ventaDAO.agregarVenta(venta, detalles);
    }
    
    public ArrayList<Venta> getVentas(){
        return this.ventaDAO.getVentas();
    }
}
