/*
 Ernesto Contreras
28245373

Albani barragán
28268078

Luis Carrillo
27539960

Gregori Yepez 
28047103

Yaslin Vreugdenhil.
29561929
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author User
 */
public class ConexionSQL {
    Connection conn = null;
    String db = "universidad";
    String url = "jdbc:postgresql://localhost:5432/"+db;
    String user = "postgres";
    String pass = "";

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "conexion exitosa", "conexion", JOptionPane.INFORMATION_MESSAGE);
//            consultarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "conexion fallida "+e, "conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultarTabla() {
        try {
        // Crear una declaración SQL
        Statement statement = conn.createStatement();

        // Ejecutar una consulta SQL
        ResultSet resultSet = statement.executeQuery("SELECT * FROM tabla");
        
        System.out.println("Cedula boton texto!" + resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa", "desconexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "desconexion fallida"+e, "desconexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
