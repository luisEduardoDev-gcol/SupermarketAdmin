package Services;

import Dao.EmpleadoDAO;
import Exceptions.EntidadNoEncontradaException;
import Exceptions.TipoEmpleadoInvalidoException;
import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;
import Models.Empleados.Reponedor;

import java.util.ArrayList;

public class EmpleadoService {

    EmpleadoDAO empleadoDAO;
    ArrayList<Empleado> empleados;

    public EmpleadoService() {
        //ArrayList que sera un contenedor polimorfico para poder agregar los 3 tipos de empleados del sistema
        this.empleadoDAO = EmpleadoDAO.getInstancia();
        this.empleados = this.empleadoDAO.getEmpleados();
    }

    public void agregarEmpleado(String tipoEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException {
        if(tipoEmpleado.equals("Gerente")) {
            Gerente gerente = new Gerente(0, nombreCompleto, correo, salarioMensual, bonificacion);
            this.empleadoDAO.agregarEmpleado(gerente);
        } else if (tipoEmpleado.equals("Cajero")) {
            Cajero cajero = new Cajero(0, nombreCompleto, correo, salarioMensual, turno);
            this.empleadoDAO.agregarEmpleado(cajero);
        } else if (tipoEmpleado.equals("Reponedor")) {
            Reponedor reponedor = new Reponedor(0, nombreCompleto, correo, salarioMensual);
            this.empleadoDAO.agregarEmpleado(reponedor);
        } else {
            throw new TipoEmpleadoInvalidoException("Tipo de empleado no válido");
        }
    }

    public void eliminarEmpleado(int idEmpleado) throws EntidadNoEncontradaException {
        for (Empleado empleado : this.empleados) {
            this.empleadoDAO.eliminarEmpleado(idEmpleado);
            return;
        }
        throw new EntidadNoEncontradaException("No se encuentra el empleado que desea eliminar");
    }

    public void editarEmpleado(String tipoEmpleado, int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno, double bonificacion) throws TipoEmpleadoInvalidoException {
        if(tipoEmpleado.equals("Gerente")) {
            this.empleadoDAO.editarEmpleado(idEmpleado, new Gerente(0, nombreCompleto, correo, salarioMensual, bonificacion));
        } else if (tipoEmpleado.equals("Cajero")) {
            this.empleadoDAO.editarEmpleado(idEmpleado, new Cajero(0, nombreCompleto, correo, salarioMensual, turno));
        } else {
            this.empleadoDAO.editarEmpleado(idEmpleado, new Reponedor(0, nombreCompleto, correo, salarioMensual));
        }
        throw new TipoEmpleadoInvalidoException("No se encuentra el empleado que desea editar");
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        return this.empleadoDAO.buscarEmpleado(idEmpleado);
    }

    public Empleado iniciarSesion(int idEmpleado, String correo){
        for (Empleado empleado : this.empleados) {
            if(empleado.getIdEmpleado() == idEmpleado && empleado.getCorreo().equals(correo)) {
                return empleado;
            }
        }
        return null;
    }
    
    public ArrayList<Empleado> getEmpleados() {
        return this.empleadoDAO.getEmpleados();
    }

}
