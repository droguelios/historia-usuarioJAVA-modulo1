package org.riwi.user_history_5.model;

import org.riwi.user_history_5.Jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO employees (nombre, salario, edad) VALUES (?, ?, ?)";
        
        try (Connection conn = Jdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, empleado.getNombre());
            pstmt.setDouble(2, empleado.getSalario());
            pstmt.setInt(3, empleado.getEdad());
            
            pstmt.executeUpdate();
            System.out.println("¡Empleado insertado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> listarTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        
        try (Connection conn = Jdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Empleado emp = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("salario"),
                    rs.getInt("edad")
                );
                empleados.add(emp);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return empleados;
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = "UPDATE employees SET nombre = ?, salario = ?, edad = ? WHERE id = ?";
        
        try (Connection conn = Jdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, empleado.getNombre());
            pstmt.setDouble(2, empleado.getSalario());
            pstmt.setInt(3, empleado.getEdad());
            pstmt.setInt(4, empleado.getId());
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("¡Empleado actualizado correctamente!");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        
        try (Connection conn = Jdbc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("¡Empleado eliminado!");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
