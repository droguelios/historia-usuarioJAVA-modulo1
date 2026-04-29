package org.riwi.talent.history.user5.controlador;

import org.riwi.talent.history.user5.modelo.Empleado;
import org.riwi.talent.history.user5.persistencia.EmpleadoDAO;
import org.riwi.talent.history.user5.persistencia.EmpleadoDAOImpl;

import java.util.List;

public class EmpleadoController {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        this.empleadoDAO = new EmpleadoDAOImpl();
    }

    public void registrarEmpleado(String nombre, double salario, int edad) {
        Empleado nuevoEmpleado = new Empleado(0, nombre, salario, edad);
        empleadoDAO.insertar(nuevoEmpleado);
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoDAO.listarTodos();
    }

    public void actualizarEmpleado(int id, String nombre, double salario, int edad) {
        Empleado empleadoModificado = new Empleado(id, nombre, salario, edad);
        empleadoDAO.actualizar(empleadoModificado);
    }

    public void eliminarEmpleado(int id) {
        empleadoDAO.eliminar(id);
    }
}
