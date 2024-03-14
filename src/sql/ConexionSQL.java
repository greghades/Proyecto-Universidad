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
import java.sql.*;

public class ConexionSQL {
    Connection conn = null;
    String db = "universidad";
    String url = "jdbc:postgresql://localhost:5432/"+db;
    String user = "postgres";
    String pass = "";

    public ConexionSQL() {
        conectar();
    }
    
    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "conexion exitosa", "conexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "conexion fallida "+e, "conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultarTabla() {
        try {
        // Creación de la consulta
        String query = "SELECT * FROM public.\"Asignaturas\"";

        // Creación de la sentencia
        Statement statement = conn.createStatement();

        // Ejecución de la consulta
        ResultSet resultSet = statement.executeQuery(query);

        // Recorrido de los resultados
        while (resultSet.next()) {
            // Obtención de los valores de las columnas
            int idAsignatura = resultSet.getInt("id_asignatura");
            String nombreAsignatura = resultSet.getString("nombre_asignatura");
            String preRequisito = resultSet.getString("pre_requisito");
            int credito = resultSet.getInt("credito");
            String retirada = resultSet.getString("retirada");

            // Impresión de los valores
            System.out.println("ID Asignatura: " + idAsignatura);
            System.out.println("Nombre Asignatura: " + nombreAsignatura);
            System.out.println("Pre-requisito: " + preRequisito);
            System.out.println("Crédito: " + credito);
            System.out.println("Retirada: " + retirada);
            System.out.println();
        }

        // Cierre de la conexión
        conn.close();

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
