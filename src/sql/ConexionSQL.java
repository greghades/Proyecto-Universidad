/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "conexion fallida"+e, "conexion", JOptionPane.ERROR_MESSAGE);
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
