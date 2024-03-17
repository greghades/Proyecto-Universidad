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

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import models.*;

public class ConexionSQL {

    private Connection conn = null;
    private Statement statement;
    private final String db = "universidad";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String user = "postgres";
    private final String pass = "";

    public ConexionSQL() {
        conectar();
    }

    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            statement = conn.createStatement();
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("conexion fallida");
        }
    }

    public Estudiante getEstudiante(String id) {
        try {
            String query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.nombre_carrera FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera WHERE e.id_estudiante = '%s'", id);
            ResultSet bigSet = statement.executeQuery(query);
            Estudiante estudiante = null;

            while (bigSet.next()) {
                String cedula = bigSet.getString("id_estudiante");
                String nombreCompleto = bigSet.getString("nombre_completo");
                int edad = bigSet.getInt("edad");
                String correo = bigSet.getString("correo");
                String sexo = bigSet.getString("sexo");
                String carrera = bigSet.getString("nombre_carrera");

                estudiante = new Estudiante(carrera, cedula, nombreCompleto, "", correo, edad, sexo);
            }

            return estudiante;
        } catch (SQLException e) {
            return null;
        }
    }

    private ArrayList<Asignatura> getAsignaturas() {
        try {
            String asignaturasQuery = "SELECT * FROM public.\"Asignaturas\"";
            ResultSet asignaturasSet = statement.executeQuery(asignaturasQuery);

            ArrayList<Asignatura> asignaturasList = new ArrayList<>();

            while (asignaturasSet.next()) {
                String idAsignatura = asignaturasSet.getString("id_asignatura");
                String nombreAsignatura = asignaturasSet.getString("nombre_asignatura");
                String preRequisito = asignaturasSet.getString("pre_requisito");
//                String seccion = asignaturasSet.getString("seccion");
                int credito = asignaturasSet.getInt("credito");

                Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, credito, preRequisito, "1");
                asignaturasList.add(asignatura);
            }
            return asignaturasList;
        } catch (SQLException e) {
            return null;
        }
    }

    public SearchResult obtenerDatosDeInscripcion(String id) {
        Estudiante estudiante = getEstudiante(id);
        ArrayList<Asignatura> asignaturasList = getAsignaturas();
        
        System.out.println("asignaturas:" + asignaturasList.get(0).getSeccion());
        
        if (estudiante == null) {
            return null;
        } else {
            return new SearchResult(estudiante, asignaturasList);
        }
    }

    public void cerrar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa", "desconexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida" + e, "desconexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
