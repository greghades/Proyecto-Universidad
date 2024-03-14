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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

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
    
    private void checkConnection() {
        try {
            if (conn.isClosed()) {
                conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           // Creación de la consulta
//        String bigQuery = ;
//        "SELECT * FROM public.\"Estudiantes\" WHERE id_estudiante = '%s'"
//"""
//                          SELECT 
//                              e.id_estudiante, 
//                              e.nombre_completo, 
//                              e.edad, 
//                              e.correo, 
//                              c.nombre_carrera
//                          FROM public."Estudiantes" AS e
//                          INNER JOIN public."Carreras" AS c ON e.id_carrera = c.id_carrera
//                          WHERE e.id_estudiante = '%s'""" 
    
    public SearchResult obtenerDatosDeInscripcion(String id) {
        
        checkConnection();
        try {
        String query = String.format("SELECT * FROM public.\"Estudiantes\" WHERE id_estudiante = '%s'", id);

        
//        System.out.println("Estudiante: " + id + " " + query);

        Statement statement = conn.createStatement();
        ResultSet estudianteSet = statement.executeQuery(query);

        Estudiante estudiante = null;
        
        while (estudianteSet.next()) {
           String idEstudiante = estudianteSet.getString("id_estudiante");
           String idCarrera = estudianteSet.getString("id_carrera"); // Assuming id_carrera is an integer
           String nombreCompleto = estudianteSet.getString("nombre_completo");
           int edad = estudianteSet.getInt("edad");
           String correo = estudianteSet.getString("correo");
           String sexo = estudianteSet.getString("sexo");

           estudiante = new Estudiante(idCarrera, idEstudiante, nombreCompleto, "", correo, edad, sexo);
        }
        
//           System.out.println("Estudiante created: " + estudiante.getCedula());
        
        String asignaturasQuery = "SELECT * FROM public.\"Asignaturas\"";
        ResultSet asignaturasSet = statement.executeQuery(asignaturasQuery);
        
        ArrayList<Asignatura> asignaturasList = new ArrayList<>(); 

        while (asignaturasSet.next()) {
          String idAsignatura = asignaturasSet.getString("id_asignatura");
          String nombreAsignatura = asignaturasSet.getString("nombre_asignatura");
          String preRequisito = asignaturasSet.getString("pre_requisito");
          int credito = asignaturasSet.getInt("credito");

          Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, credito, preRequisito);
          asignaturasList.add(asignatura);
        }

//        Asignatura[] asignaturas = asignaturasList.toArray(new Asignatura[asignaturasList.size()]);
//        System.out.println("Asignaturas created: " + asignaturas[0].getNombre());
        
        String carreraQuery = String.format("SELECT * FROM public.\"Carreras\" WHERE id_carrera = '%s'", estudiante.getIdCarrera());
        ResultSet carreraSet = statement.executeQuery(carreraQuery);
        
        Carrera carrera = null;
        
        while (carreraSet.next()) {
            String idCarrera = carreraSet.getString("id_carrera");
            String nombreCarrera = carreraSet.getString("nombre_carrera");
            
            carrera = new Carrera(idCarrera, nombreCarrera);
        }
        
//        System.out.println("Carrera created: " + carrera.getNombre());
        
        return new SearchResult(estudiante, carrera, asignaturasList);
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
