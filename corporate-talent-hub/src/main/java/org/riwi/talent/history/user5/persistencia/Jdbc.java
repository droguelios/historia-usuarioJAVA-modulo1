package org.riwi.talent.history.user5.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    // Credenciales de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/talent_hub_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Prueba de conexión y sintaxis moderna (try-with-resources)
     */
    public static void operacionModerna() {
        String sql = "SELECT * FROM employees";

        // El try-with-resources asegura que la conexión se cierre automáticamente
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Empleado: " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    // Método para proveer la conexión a los DAO
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
