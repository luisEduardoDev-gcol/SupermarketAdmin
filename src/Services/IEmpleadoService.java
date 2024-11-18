package Services;

import Exceptions.IdInvalidoException;
import Exceptions.TipoEmpleadoInvalidoException;
import Models.Empleados.Empleado;

import java.util.ArrayList;

public interface IEmpleadoService {
    void agregarEmpleado(String tipoEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException;
    void eliminarEmpleado(int idEmpleado) throws IdInvalidoException;
    void editarEmpleado(String tipoEmpleado, int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException;
    Empleado buscarEmpleado(int idEmpleado);
    Empleado iniciarSesion(int idEmpleado, String correo);
    ArrayList<Empleado> getEmpleados();
}
