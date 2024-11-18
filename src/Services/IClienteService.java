package Services;

import Exceptions.CamposVaciosException;
import Exceptions.EmailInvalidoException;
import Models.Cliente;
import Models.DetalleVenta;
import Models.Venta;

import java.util.ArrayList;

public interface IClienteService {
    public void agregarCliente(Cliente cliente) throws EmailInvalidoException, CamposVaciosException;
    public void eliminarCliente(int idCliente);
    public void editarCliente(Cliente cliente) throws CamposVaciosException, EmailInvalidoException;
    public Cliente buscarClientePorId(int idCliente);
    public boolean isVacioCampo(Cliente cliente);
    public int buscarIdCliente(String texto);
    public ArrayList<Venta> getVentas(int id_cliente);
    public ArrayList<DetalleVenta> getDetallesVenta(int idVenta);
    public Venta getVentaPorId(int id_venta);
}
