package Dao;

import Models.Cliente;
import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;
import Models.Empleados.Reponedor;
import Models.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    private DataBaseConnector dbc = new DataBaseConnector();
    private static EmpleadoDAO instancia;
    
    private EmpleadoDAO() {
    }
    
    public static EmpleadoDAO getInstancia(){
        instancia = instancia == null? new EmpleadoDAO():instancia;
        return instancia;
    }
    
    
    public void agregarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Empleados (nombre_completo, correo, salario, tipo_empleado, turno, bonificacion)" + " VALUES (?,?,?,?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setString(2, empleado.getCorreo());
            pstmt.setDouble(3, empleado.getSalarioMensual());

            if(empleado instanceof Gerente){
                pstmt.setString(4, "Gerente");
                pstmt.setString(5, "No aplica");
                pstmt.setDouble(6, ((Gerente) empleado).getBonificacion());
            } else if(empleado instanceof Cajero){
                pstmt.setString(4, "Cajero");
                pstmt.setString(5, ((Cajero) empleado).getTurno());
                pstmt.setDouble(6, 0);
            } else {
                pstmt.setString(4, "Reponedor");
                pstmt.setString(5, "No aplica");
                pstmt.setDouble(6, 0);
            }

            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR UN EMPLEADO " + e.getMessage());
        }

    }

    public void eliminarEmpleado(int idEmpleado) {
        String sql = "DELETE FROM Empleados WHERE id_empleado = ?";

        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL ELIMINAR UN EMPLEADO " + e.getMessage());
        }

    }

    public ArrayList<Empleado> getEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                int idEmpleado = rs.getInt("id_empleado");
                String nombreCompleto = rs.getString("nombre_completo");
                String correo = rs.getString("correo");
                double salario = Double.parseDouble(rs.getString("salario"));
                String turno = rs.getString("turno");
                double bonificacion = Double.parseDouble(rs.getString("bonificacion"));

                if(rs.getString("tipo_empleado").equals("Gerente")) {
                    empleados.add(new Gerente(idEmpleado, nombreCompleto, correo, salario, bonificacion));
                } else if (rs.getString("tipo_empleado").equals("Cajero")) {
                    Cajero cajero = new Cajero(idEmpleado, nombreCompleto, correo, salario, turno);
                    empleados.add(new Cajero(idEmpleado, nombreCompleto, correo, salario, turno));
                } else {
                    empleados.add(new Reponedor(idEmpleado, nombreCompleto, correo, salario));
                }

            }

        } catch(SQLException e){
            System.out.println("FALLO AL OBTENER EMPLEADOS: " + e.getMessage());
        }
        return empleados;
    }

    public void editarEmpleado(int idEmpleado, Empleado empleado) {
        String sql = "UPDATE Empleados SET nombre_completo = ?, correo = ?, salario = ?, tipo_empleado = ?, turno = ?, bonificacion = ? WHERE id_empleado = ?";

        try (Connection con = dbc.connect();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setString(2, empleado.getCorreo());
            pstmt.setDouble(3, empleado.getSalarioMensual());

            if(empleado instanceof Gerente){
                pstmt.setString(4, "Gerente");
                pstmt.setString(5, "No aplica");
                pstmt.setDouble(6, ((Gerente) empleado).getBonificacion());
            } else if(empleado instanceof Cajero){
                pstmt.setString(4, "Cajero");
                pstmt.setString(5, ((Cajero) empleado).getTurno());
                pstmt.setDouble(6, 0);
            } else {
                pstmt.setString(4, "Reponedor");
                pstmt.setString(5, "No aplica");
                pstmt.setDouble(6, 0);
            }

            pstmt.setInt(7, idEmpleado);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL EDITAR UN EMPLEADO " + e.getMessage());
        }
    }

    public Empleado buscarEmpleado(int idEmpleado){
        String sql = "SELECT * FROM Empleados WHERE id_empleado = ?";

        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            ResultSet rs = pstmt.executeQuery();

            String nombreCompleto = rs.getString("nombre_completo");
            String correo = rs.getString("correo");
            double salario = Double.parseDouble(rs.getString("salario"));
            String turno = rs.getString("turno");
            double bonificacion = Double.parseDouble(rs.getString("bonificacion"));

            if(rs.getString("tipo_empleado").equals("Gerente")) {
                return new Gerente(idEmpleado, nombreCompleto, correo, salario, bonificacion);
            } else if (rs.getString("tipo_empleado").equals("Cajero")) {
                return new Cajero(idEmpleado, nombreCompleto, correo, salario, turno);
            } else {
                return new Reponedor(idEmpleado, nombreCompleto, correo, salario);
            }

        }catch(SQLException e){
            System.out.println("FALLO AL BUSCAR EL EMPLEADO " + e.getMessage());
        }
        return null;
    }


}
