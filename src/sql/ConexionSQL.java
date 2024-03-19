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
    private final String pass = "1234";

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
            String query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.* FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera WHERE e.id_estudiante = '%s'", id);
            ResultSet bigSet = statement.executeQuery(query);
            Estudiante estudiante = null;

            while (bigSet.next()) {
                String cedula = bigSet.getString("id_estudiante");
                String nombreCompleto = bigSet.getString("nombre_completo");
                int edad = bigSet.getInt("edad");
                String correo = bigSet.getString("correo");
                String sexo = bigSet.getString("sexo");
                String nombreCarrera = bigSet.getString("nombre_carrera");
                String idCarrera = bigSet.getString("id_carrera");

                Carrera carrera = new Carrera(idCarrera, nombreCarrera);
                estudiante = new Estudiante(carrera, cedula, nombreCompleto, "", correo, edad, sexo);
            }

            return estudiante;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public PeriodoAcademico getPeriodoAcademico(String id) {
        try {
          String query = "SELECT p.id_periodo, p.nombre_periodo_a, p.fecha_inicio, p.fecha_final FROM public.\"Periodo_academico\" p WHERE p.id_periodo = 'PER-001'";
          ResultSet periodoSet = statement.executeQuery(query);
            PeriodoAcademico periodoAcademico = null;
            
            while (periodoSet.next()) {
                String id_periodo = periodoSet.getString("id_periodo");
                String nombre_periodo_a = periodoSet.getString("nombre_periodo_a");
                Date fecha_inicio = periodoSet.getDate("fecha_inicio");
                Date fecha_final = periodoSet.getDate("fecha_final");

                periodoAcademico = new PeriodoAcademico(id_periodo, nombre_periodo_a, fecha_inicio, fecha_final);
            }
            
//            System.out.println("Periodo: " + periodoAcademico.getNombre());
            return periodoAcademico;
        } catch (SQLException e) {
            return null;
        }
    }

    private ArrayList<Asignatura> getAsignaturasParaInscripcion(String idCarrera) {
        try {
            String asignaturasQuery = String.format("SELECT * FROM public.\"Asignaturas\" AS a INNER JOIN public.\"Asignaturas_carrera\" AS ac ON a.id_asignatura = ac.id_asignatura WHERE ac.id_carrera = '%s'", idCarrera);
            ResultSet asignaturasSet = statement.executeQuery(asignaturasQuery);

            ArrayList<Asignatura> asignaturasList = new ArrayList<>();

            while (asignaturasSet.next()) {
                String idAsignatura = asignaturasSet.getString("id_asignatura");
                String nombreAsignatura = asignaturasSet.getString("nombre_asignatura");
                int cargaAcademica = asignaturasSet.getInt("carga_academica");
                boolean esRetirada = asignaturasSet.getBoolean("retirada");

                Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, cargaAcademica, esRetirada);
                asignaturasList.add(asignatura);
            }
            return asignaturasList;
        } catch (SQLException e) {
            return null;
        }
    }
//haciendo arreglos en estudiante:
    public ArrayList<Estudiante> getEstudiantes() {
        try {
            String estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.id_carrera, c.nombre_carrera FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera";
            ResultSet estudiantesSet = statement.executeQuery(estudiantesQuery);

            ArrayList<Estudiante> estudiantesList = new ArrayList<>();

            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombreEstudiante = estudiantesSet.getString("nombre_estudiante");
                String apellidoEstudiante = estudiantesSet.getString("apellido_estudiante");
                String correoEstudiante = estudiantesSet.getString("correo_estudiante");
                int edad = estudiantesSet.getInt("edad");
                String sexoEstudiante = estudiantesSet.getString("sexo_estudiante");
                String idCarrera = estudiantesSet.getString("id_carrera");
                String nombreCarrera = estudiantesSet.getString("nombre_carrera");

                Carrera carrera = new Carrera(idCarrera, nombreCarrera);
                Estudiante estudiante = new Estudiante(carrera, cedula, nombreEstudiante, apellidoEstudiante, correoEstudiante, edad, sexoEstudiante);
                estudiantesList.add(estudiante);
            }
//            System.out.println("estudiantes: " + estudiantesList);
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public InscripcionInfo obtenerDatosDeInscripcion(String id) {
        Estudiante estudiante = getEstudiante(id);
        if (estudiante == null) {
            return null;
        }
        ArrayList<Asignatura> asignaturasList = getAsignaturasParaInscripcion(estudiante.getCarrera().getId());

        if (asignaturasList != null) {
            return new InscripcionInfo(estudiante, asignaturasList);
        } else {
            return null;
        }
    }

    public ArrayList<Seccion> getSecciones(String idAsignatura) {
        try {
            String query = String.format("SELECT s.id_seccion, s.numero_seccion, s.limite_estudiantes FROM public.\"Secciones\" s INNER JOIN public.\"Profesor_asignatura_seccion\" psa ON s.id_seccion = psa.id_seccion WHERE psa.id_asignatura = '%s'", idAsignatura);
            ResultSet seccionesSet = statement.executeQuery(query);
            
            ArrayList<Seccion> secciones = new ArrayList<>();
                while (seccionesSet.next()) {
                    String id = seccionesSet.getString("id_seccion");
                    int cupos = seccionesSet.getInt("limite_estudiantes");
                    int numeroSeccion = seccionesSet.getInt("numero_seccion");

//                    System.out.println("seccion: " + id + numeroSeccion);
                    secciones.add(new Seccion(id, cupos, numeroSeccion));
                }
                return secciones;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public Profesor getProfesor(String idAsignatura, String idSeccion) {
        try {
            String query = String.format("SELECT p.id_profesor, p.nombre_completo FROM public.\"Profesor\" AS p, public.\"Profesor_asignatura_seccion\" AS pas WHERE p.id_profesor = pas.id_profesor AND pas.id_asignatura = '%s' AND pas.id_seccion = '%s'", idAsignatura, idSeccion);
            ResultSet profesorSet = statement.executeQuery(query);
            Profesor profesor = null;
            
            while (profesorSet.next()) {
                String cedula = profesorSet.getString("id_profesor");
                String nombre = profesorSet.getString("nombre_completo");
                profesor = new Profesor(cedula, nombre);
            }
            return profesor;
        } catch (SQLException e) {
            return null;
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
