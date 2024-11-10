/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Simón David Cruz S
 */
import Models.Productos.Factory.ProductoNoPerecederoFactory;
import Models.Productos.Factory.ProductoPerecederoFactory;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    private DataBaseConnector dbc = new DataBaseConnector();
    private static ProductoDAO instancia;

    private ProductoDAO() {
    }

    public static ProductoDAO getInstancia() {
        instancia = instancia == null ? new ProductoDAO() : instancia;
        return instancia;
    }

    
    public void agregarProductoPerecedero(ProductoPerecedero producto){
        String sql = "INSERT INTO Productos (nombre,precio,stock,tipo,caducidad,tiempo_almacen,id_proveedor,categoria)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getClass().getSuperclass().getSimpleName() + "");
            System.out.println(producto.getClass().getName() + "}}}" + producto.getClass().getInterfaces()[0].getSimpleName() + "--");
            pstmt.setString(5, producto.getFechaCaducidad());
            pstmt.setString(6, "");
            pstmt.setInt(7, producto.getIdProveedor());
            pstmt.setString(8, producto.getClass().getInterfaces()[0].getSimpleName());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL AGREGAR PERECEDERO " + e.getMessage());
        }
    }
    
        public void agregarProductoNoPerecedero(ProductoNoPerecedero producto){
        String sql = "INSERT INTO Productos (nombre,precio,stock,tipo,caducidad,tiempo_almacen,id_proveedor,categoria)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getClass().getSimpleName() + "");
            pstmt.setString(5, "");
            pstmt.setString(6, producto.getDuracionAlmacen());
            pstmt.setInt(7, producto.getIdProveedor());
            pstmt.setString(8, producto.getClass().getInterfaces()[0].getSimpleName());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL AGREGAR NO PERECEDERO " + e.getMessage());
        }
    }

    public ArrayList<Producto> getProductos(String criterio, boolean esStockBajo) {

        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT *, "
                + "CASE "
                + "WHEN categoria = 'Higiene_y_Limpieza' THEN 'Higiene y limpieza' "
                + "WHEN categoria = 'Panaderia_y_Pasteleria' THEN 'Panaderia y pasteleria' "
                + "ELSE categoria "
                + "END AS Categoria2 "
                + "FROM Productos ";
        
        if (!esStockBajo) {
            sql += " ORDER BY " + criterio;
        } else {
            sql += " WHERE stock <= 15";
        }
        
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_producto");
                String nombre = rs.getString("nombre");
                int precio = rs.getInt("precio");
                int stock = rs.getInt("stock");
                String caducidad = rs.getString("caducidad");
                String categoria = rs.getString("Categoria2");
                int id_proveedor = rs.getInt("id_proveedor");
                String tiempoAlmacen = rs.getString("tiempo_almacen");

                Producto producto;
                if (caducidad.equals("")) {
                    ProductoNoPerecederoFactory factory = new ProductoNoPerecederoFactory();
                    producto = factory.crearProducto(categoria, codigo, nombre, precio, stock, tiempoAlmacen, id_proveedor);

                } else {
                    ProductoPerecederoFactory factory = new ProductoPerecederoFactory();
                    producto = factory.crearProducto(categoria, codigo, nombre, precio, stock, caducidad, id_proveedor);
                }
                producto.calcularPrecio();
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("FALLO EN getProductos" + e.getMessage());
            e.printStackTrace();
        }
        return productos;
    }

    public void eliminarProducto(int codProducto) {
        String sql = "DELETE FROM Productos WHERE codigo_producto = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, codProducto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL ELIMINAR " + e.getMessage());
        }
    }

    public void editarProducto(int id, Producto producto) {
        String sql = "UPDATE Productos SET nombre = ?, precio = ?, stock = ? , id_proveedor = ?, caducidad = ?, tiempo_almacen = ?, categoria = ?"
                + "WHERE codigo_producto = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getIdProveedor());

            if (producto instanceof ProductoPerecedero) {
                pstmt.setString(5, ((ProductoPerecedero) producto).getFechaCaducidad());
                pstmt.setString(6, "");
            } else {
                pstmt.setString(5, "");
                pstmt.setString(6, ((ProductoNoPerecedero) producto).getDuracionAlmacen());
            }
            pstmt.setString(7, producto.getClass().getInterfaces()[0].getSimpleName());
            pstmt.setInt(8, producto.getCodigoProducto());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL EDITAR " + e.getMessage());
        }
    }

    public Producto buscarProductoCodigo(int codigo) {
        Producto producto = null;
        
        String sql = "SELECT *,"
                + " CASE "
                + "WHEN categoria = 'Higiene_y_Limpieza' THEN 'Higiene y limpieza' "
                + "WHEN categoria = 'Panaderia_y_Pasteleria' THEN 'Panaderia y pasteleria' "
                + "ELSE categoria "
                + "END AS Categoria2 "
                + " FROM Productos WHERE codigo_producto = ?";
        
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            String nombre = rs.getString("nombre");
            int precio = rs.getInt("precio");
            int stock = rs.getInt("stock");
            String caducidad = rs.getString("caducidad");
            int id_proveedor = rs.getInt("id_proveedor");
            String tiempoAlmacen = rs.getString("tiempo_almacen");
            String categoria = rs.getString("categoria2");

            if (caducidad.equals("")) {
                    ProductoNoPerecederoFactory factory = new ProductoNoPerecederoFactory();
                    producto = factory.crearProducto(categoria, codigo, nombre, precio, stock, tiempoAlmacen, id_proveedor);
            } else {
                    ProductoPerecederoFactory factory = new ProductoPerecederoFactory();
                    producto = factory.crearProducto(categoria, codigo, nombre, precio, stock, caducidad, id_proveedor);
            }
            producto.calcularPrecio();
        } catch (SQLException e) {
            System.out.println("FALLO EN buscarProductoCodigo " + e.getMessage());
        }
        return producto;
    }

    public Producto buscarProductoNombre(String name) {
        String sql = "SELECT * FROM Productos WHERE nombre = ?";
        Producto producto = null;
        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo_producto");
                String nombre = rs.getString("nombre");
                int precio = rs.getInt("precio");
                int stock = rs.getInt("stock");
                String caducidad = rs.getString("caducidad");
                int id_proveedor = rs.getInt("id_proveedor");
                String tiempoAlmacen = rs.getString("tiempo_almacen");

                if (caducidad.equals("")) {
                    producto = new ProductoNoPerecedero(codigo, nombre, precio, stock, tiempoAlmacen, id_proveedor);
                } else {
                    producto = new ProductoPerecedero(codigo, nombre, precio, stock, caducidad, id_proveedor);
                }
                producto.calcularPrecio();
            }
        } catch (SQLException e) {
            System.out.println("FALLO EN getProductoByName" + e.getMessage());
        }
        return producto;
    }

    public void actualizarStockProducto(int codigoProducto, int nuevoStock) {
        String sql = "UPDATE Productos SET stock = ? WHERE codigo_producto = ?";

        try (Connection con = dbc.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoStock);
            pstmt.setInt(2, codigoProducto);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al actualizar el stock del producto: " + e.getMessage());
        }
    }

}
