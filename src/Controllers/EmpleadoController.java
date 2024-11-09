package Controllers;

import Exceptions.IdInvalidoException;
import Exceptions.TipoEmpleadoInvalidoException;
import Models.Empleados.Empleado;
import Services.EmpleadoService;

import java.util.ArrayList;

public class EmpleadoController {
    private EmpleadoService empleadoService;

    public EmpleadoController() {
        empleadoService = new EmpleadoService();
    }

    public void agregarEmpleado(String tipoEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException {
        this.empleadoService.agregarEmpleado(tipoEmpleado, nombreCompleto, correo, salarioMensual, turno, bonificacion);
    }

    //Metodo para eliminar empleado por su id empleado
    public void eliminarEmpleado(int idEmpleado) throws IdInvalidoException {
        this.empleadoService.eliminarEmpleado(idEmpleado);
    }

    public void editarEmpleado(String tipoEmpleado, int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException{
        this.empleadoService.editarEmpleado(tipoEmpleado, idEmpleado, nombreCompleto, correo, salarioMensual, turno, bonificacion);
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        return this.empleadoService.buscarEmpleado(idEmpleado);
    }
    
    public Empleado iniciarSesion(int idEmpleado, String correo) {
        return this.empleadoService.iniciarSesion(idEmpleado, correo);
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleadoService.getEmpleados();
    }

}
