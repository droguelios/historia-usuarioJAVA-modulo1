package org.riwi.talent.history.user5.persistencia;

import org.riwi.talent.history.user5.modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    void insertar(Empleado empleado);
    List<Empleado> listarTodos();
    void actualizar(Empleado empleado);
    void eliminar(int id);
}
