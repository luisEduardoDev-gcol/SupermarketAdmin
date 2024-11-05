/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Cliente;
import Models.DetalleVenta;
import Models.Venta;
import Services.ClienteService;
import java.util.ArrayList;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ClienteController {
    private ClienteService clienteService;
    
    public ClienteController() {
        clienteService = new ClienteService();
    }
    
    public void agregarCliente(Cliente cliente) {
        clienteService.agregarCliente(cliente);
    }

    public void eliminarCliente(int idCliente) throws RuntimeException{
        clienteService.eliminarCliente(idCliente);
    }

    public void editarCliente(Cliente cliente) throws RuntimeException {
        clienteService.editarCliente(cliente);
    }
    
    public Cliente buscarClientePorId(int idCliente){
        return clienteService.buscarClientePorId(idCliente);
    }
     
    public ArrayList<Cliente> getClientes() {
        return clienteService.getClientes();
    }
    public ArrayList<Venta> getVentas(int id_cliente) {
        return clienteService.getVentas(id_cliente);
    }
    public ArrayList<DetalleVenta> getDetallesVenta(int idVenta) {
        return clienteService.getDetallesVenta(idVenta);
    }
    public Venta getVentaPorId(int id_venta) {
        return clienteService.getVentaPorId(id_venta);
    }
}
