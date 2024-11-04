/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.DetalleVenta;
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
    
   
    
    
}
