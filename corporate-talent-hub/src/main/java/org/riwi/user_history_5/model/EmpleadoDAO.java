package org.riwi.user_history_5.model;

import java.util.List;

public interface EmpleadoDAO {
    void insertar(Empleado empleado);
    List<Empleado> listarTodos();
    void actualizar(Empleado empleado);
    void eliminar(int id);
}
