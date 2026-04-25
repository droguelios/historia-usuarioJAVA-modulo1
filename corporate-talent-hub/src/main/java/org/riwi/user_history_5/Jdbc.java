package org.riwi.user_history_5;

public class Jdbc {
    /*En java 7 y aun en java 8 cuando se trataba de conectar una base de datos
    tenias que cerrarla como si fuera una puerta porque si la dejabas abierta habria una
    fuga de conexion esa es la funcion de finally asegurarse de que esa base de datos
    no estuviera en ese limbo por asi decirlo ya que este iba con una try-catch eso era
    la condicion que se aplicaba de que aun que funcione o no funcione el codgio si o si
    tenia que ejecutarlo


    Connection conn = null;
PreparedStatement pstmt = null;

try {
    conn = DriverManager.getConnection(url, user, pass);
    pstmt = conn.prepareStatement("SELECT * FROM usuarios");
    // ... usar la conexión
} catch (SQLException e) {
    e.printStackTrace();


} finally {
    // aqui es donde empieza a funcionar el finally
    try {
        if (pstmt != null) pstmt.close();
    } catch (SQLException e) { /* Ignorar o loggear */

    /* try {
            if (conn != null) conn.close();

    } catch (SQLException e) { /* Ignorar o loggear */


}










