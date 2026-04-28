package org.riwi.user_history_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    // Datos de la base de datos (Cambia esto según la pc)
    private static final String URL = "jdbc:mysql://localhost:3306/talent_hub_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Sintaxis moderna (La forma correcta): Try-with-resources
     * Aquí Java hace esto por nosotros.
     */
    public static void operacionModerna() {
        String sql = "SELECT * FROM employees";

        // al meter la conexión y demás entre los paréntesis del try,
        // Java se encarga de cerrarlos solito apenas termine el bloque
        // Es como una puerta con sensor: se cierra sola al salir.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("empleado: " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("salio mal base de datos: " + e.getMessage());
        }

        // ¿por qué esto es mejor? Porque evita las "Fugas de Memoria" (Memory Leaks).
        // antes, si el código fallaba antes de cerrar la conexión, esa conexión se
        // quedaba abierta en el "limbo", tragando RAM y recursos del servidor hasta
        // que todo colapsaba. Con el try-with-resources, eso ya no pasa.
    }

    /**
     * SINTAXIS LEGACY (Como se hacía en los tiempos de Java 8): El bendito finally
     * Lo dejo comentado para que veas el dolor de cabeza que era antes.
     */
    /*
     * public static void operacionAntigua() {
     * Connection conn = null;
     * PreparedStatement pstmt = null;
     * ResultSet rs = null;
     * 
     * try {
     * conn = DriverManager.getConnection(URL, USER, PASSWORD);
     * pstmt = conn.prepareStatement("SELECT * FROM employees");
     * rs = pstmt.executeQuery();
     * 
     * while (rs.next()) {
     * // ... leer datos
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * } finally {
     * // Aquí es donde tocaba cerrar todo a mano.
     * // Era un lío porque si el close() fallaba, tocaba meter otro try-catch.
     * // Si te olvidabas de una llave, tenías una fuga de conexión asegurada.
     * try {
     * if (rs != null) rs.close();
     * if (pstmt != null) pstmt.close();
     * if (conn != null) conn.close();
     * } catch (SQLException e) {
     * System.out.println("Error cerrando las cosas: " + e.getMessage());
     * }
     * }
     * }
     */

    // Este método es el que usaremos en el DAO para no repetir código
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
