/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.EmailInvalidoException;
import Models.Proveedor;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Javier Argoty
 */
public class ProveedorDAO {

    private DataBaseConnector dbc = new DataBaseConnector();
    private static ProveedorDAO instancia;
    
    private ProveedorDAO() {
    }
    
    public static ProveedorDAO getInstancia(){
        instancia = instancia == null? new ProveedorDAO():instancia;
        return instancia;
    }
    
    
    public void agregarProveedor(Proveedor proveedor) throws EmailInvalidoException {
        String sql = "INSERT INTO Proveedores (nombre_empresa,telefono_contacto,email)"
                + " VALUES (?,?,?)";
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, proveedor.getNombreEmpresa());
            pstmt.setString(2, proveedor.getTelefonoContacto());
            pstmt.setString(3, proveedor.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new EmailInvalidoException("El email ya existe en otro proveedor");
        }
    }

    public ArrayList<Proveedor> getProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedores";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_empresa");
                String telefono = rs.getString("telefono_contacto");
                String email = rs.getString("email");

                proveedores.add(new Proveedor(id, nombre, telefono, email));
            }
        } catch (SQLException e) {
            System.out.println("FALLO AL OBTENER PROVEEDORES" + e.getMessage());
        }
        return proveedores;
    }

    public void eliminarProveedor(int idProveedor) {
        String sql = "DELETE FROM Proveedores WHERE id_proveedor = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, idProveedor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL ELIMINAR PROVEEDOR " + e.getMessage());
        }
    }

    public void editarProveedor(Proveedor proveedor) throws EmailInvalidoException {
        String sql = "UPDATE Proveedores SET nombre_empresa = ?, telefono_contacto = ?, email = ? WHERE id_proveedor = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, proveedor.getNombreEmpresa());
            pstmt.setString(2, proveedor.getTelefonoContacto());
            pstmt.setString(3, proveedor.getEmail());
            pstmt.setInt(4, proveedor.getIdProveedor());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new EmailInvalidoException("Este email ya existe en otro proveedor");
        }
    }

    public Proveedor buscarProveedorId(int idProveedor) {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM Proveedores WHERE id_proveedor = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idProveedor);
            ResultSet rs = pstmt.executeQuery();

            String nombre = rs.getString("nombre_empresa");
            String telefono = rs.getString("telefono_contacto");
            String email = rs.getString("email");

            proveedor = new Proveedor(idProveedor, nombre, telefono, email);
        } catch (SQLException e) {
            System.out.println("FALLO EN BUSCAR PROVEEDOR POR ID " + e.getMessage());
        }
        return proveedor;
    }

    public ArrayList<Producto> buscarProductosProveedor(int idProveedor) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos WHERE id_proveedor = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idProveedor);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigoProd = rs.getInt("codigo_producto");
                String nombre = rs.getString("nombre");
                String caducidad = rs.getString("caducidad");

                if (caducidad.equals("")) {
                    productos.add(new ProductoNoPerecedero(codigoProd, nombre, 0, 0, null, idProveedor));
                } else {
                    productos.add(new ProductoPerecedero(codigoProd, nombre, 0, 0, null, idProveedor));
                }
            }
        } catch (SQLException e) {
            System.out.println("FALLO EN BUSCAR PRODUCTOS POR EL ID DEL PROVEEDOR " + e.getMessage());
        }
        return productos;
    }


}
