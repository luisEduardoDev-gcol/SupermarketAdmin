package Services;

import Exceptions.ListaVaciaException;
import Models.DetalleVenta;
import Models.Venta;

import java.util.ArrayList;

public interface IVentaService {
    void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles);
    ArrayList<Venta> getVentas();
    ArrayList<Venta> filtrarVentas(String filtro) throws ListaVaciaException;
}
