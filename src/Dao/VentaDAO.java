/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Cliente;
import Models.DetalleVenta;
import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;
import Models.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Simón David Cruz S
 */
public class VentaDAO {
    private DataBaseConnector dbc = new DataBaseConnector();
    private EmpleadoDAO empDAO = EmpleadoDAO.getInstancia();
    private ClienteDAO cliDAO = ClienteDAO.getInstancia();
    private ProductoDAO prodDAO = ProductoDAO.getInstancia();
    private static VentaDAO instancia;
    
    private VentaDAO() {
    }
    
    public static VentaDAO getInstancia(){
        instancia = instancia == null? new VentaDAO():instancia;
        return instancia;
    }

    public void agregarVenta(Venta venta, ArrayList<DetalleVenta> detalles){
        String sql1 = "INSERT INTO Ventas (fecha,total,id_cliente,id_cajero)"
                + " VALUES (?,?,?,?)"
                + "RETURNING id_venta";
        
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql1)){
            
            pstmt.setString(1, venta.getFecha());
            pstmt.setDouble(2, venta.getTotal());
            pstmt.setInt(3, venta.getCliente().getIdCliente());
            pstmt.setInt(4, venta.getCajero().getIdEmpleado());
            
            ResultSet rs = pstmt.executeQuery();
            int idVenta = rs.getInt("id_venta");
            pstmt.close();
            
            agregarDetallesVenta(idVenta, detalles);
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR VENTA " + e.getMessage());
        }
    }

    private void agregarDetallesVenta(int idVenta, ArrayList<DetalleVenta> detalles){
        String sql1 = "INSERT INTO DetallesVentas (id_venta,codigo_producto,cantidad,precio)"
                + " VALUES (?,?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql1)){
            
            for (int i = 0; i < detalles.size(); i++) {
                pstmt.setInt(1, idVenta);
                pstmt.setInt(2, detalles.get(i).getProducto().getCodigoProducto());
                pstmt.setInt(3, detalles.get(i).getCantidad());
                pstmt.setDouble(4, detalles.get(i).getPrecio());
            
                pstmt.executeUpdate();
            }
            actualizarStockProductos(detalles);
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR DETALLE DE VENTA " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void actualizarStockProductos(ArrayList<DetalleVenta> detalles){
        String sql = "UPDATE Productos SET stock = ? WHERE codigo_producto = ?";
        
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            for (int i = 0; i < detalles.size(); i++) {
                int stock = detalles.get(i).getProducto().getStock();
                pstmt.setInt(1, stock);
                pstmt.setInt(2,  detalles.get(i).getProducto().getCodigoProducto());
            
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println("FALLO AL ACTUALIZAR STOCK DE PRODUCTOS" + e.getMessage());
        }
    
    }

    public ArrayList<Venta> getVentas(){
        ArrayList<Venta> ventas = new ArrayList<>();
        ArrayList<Empleado> empleados = this.empDAO.getEmpleados();
        ArrayList<Cliente> clientes = this.cliDAO.getClientes();
        ArrayList<Producto> productos = this.prodDAO.getProductos("codigo_producto", false);

        String sql = "SELECT * FROM ventas";

        try (Connection con = dbc.connect();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("id_venta");
                String fecha = rs.getString("fecha");
                double total = rs.getDouble("total");
                int idCliente = rs.getInt("id_cliente");
                int idCajero = rs.getInt("id_cajero");

                // Buscar cliente por idCliente
                Cliente c = null;
                for (Cliente cliente : clientes) {
                    if (cliente.getIdCliente() == idCliente) {
                        c = cliente;
                    }

                }

                // Buscar cajero por idCajero
                Cajero e = null;
                for (Empleado empleado : empleados) {
                    if (empleado.getIdEmpleado() == idCajero) {
                        e = (Cajero) empleado;
                    }
                }

                // Obtener detalles de la venta
                ArrayList<DetalleVenta> detallesVenta = getDetallesVenta(idVenta, productos);

                // Crear y agregar la venta a la lista
                Venta venta = new Venta(c, e, total, detallesVenta);
                venta.setIdVenta(idVenta);
                venta.setFecha(fecha);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("FALLO AL OBTENER VENTAS: " + e.getMessage());
        }

        return ventas;
    }

    // Método para obtener los detalles de una venta específica
    private ArrayList<DetalleVenta> getDetallesVenta(int idVenta, ArrayList<Producto> productos) {
        ArrayList<DetalleVenta> detalles = new ArrayList<>();
        String sqlDetalleVenta = "SELECT * FROM DetallesVentas WHERE id_venta = ?";

        try (Connection con = dbc.connect();
             PreparedStatement pstmt = con.prepareStatement(sqlDetalleVenta)) {
            pstmt.setInt(1, idVenta);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigoProducto = rs.getInt("codigo_producto");
                int cantidad = rs.getInt("cantidad");

                // Buscar el producto correspondiente al codigoProducto
                Producto producto = productos.stream()
                        .filter(p -> p.getCodigoProducto() == codigoProducto)
                        .findFirst()
                        .orElse(null);

                if (producto != null) {
                    DetalleVenta detalle;
                    if (producto instanceof ProductoNoPerecedero) {
                        detalle = new DetalleVenta((ProductoNoPerecedero) producto, cantidad);
                    } else if (producto instanceof ProductoPerecedero) {
                        detalle = new DetalleVenta((ProductoPerecedero) producto, cantidad);
                    } else {
                        System.out.println("Producto con código " + codigoProducto + " no es perecedero ni no perecedero.");
                        continue;
                    }

                    detalle.setIdVenta(idVenta);
                    detalles.add(detalle);
                } else {
                    System.out.println("Producto con código " + codigoProducto + " no encontrado en la lista de productos.");
                }
            }
        } catch (SQLException e) {
            System.out.println("FALLO AL OBTENER DETALLES DE VENTA: " + e.getMessage());
        }

        return detalles;
    }

}
