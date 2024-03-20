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
import java.util.List;
import models.*;

public class ConexionSQL {

    private static ConexionSQL instance = null;
    private Connection conn = null;
    private Statement statement;
    private final String db = "uni";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String user = "postgres";
    private final String pass = "gr3g0r1j053y3p3z4rt34g4";

    public ConexionSQL() {
        conectar();
    }

    public static ConexionSQL getInstance() {
        if (instance == null) {
            instance = new ConexionSQL();
        }
        return instance;
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
    
    public boolean getInscripcion(String id) {
        try {
            String query = String.format("SELECT i.id_estudiante FROM public.\"Inscripcion\" AS i WHERE i.id_estudiante = '%s'", id);
            ResultSet inscripcionSet = statement.executeQuery(query);
            boolean estaInscrito = false;

            while (inscripcionSet.next()) {
                String cedula = inscripcionSet.getString("id_estudiante");
                
                estaInscrito = cedula.equals(id);
            }

            return estaInscrito;
        } catch (SQLException e) {
            return false;
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

    public int inscribirEstudiante(ArrayList<InscripcionData> inscripciones) {
        try {
            int totalRowsAffected = 0;
            for (int index = 0; index < inscripciones.size(); index++) {
                InscripcionData inscripcion = inscripciones.get(index);

                String estudiante_id = inscripcion.getId_estudiante();
                String asignatura_id = inscripcion.getId_asignatura();
                String periodo_id = inscripcion.getId_periodo();
                String seccion_id = inscripcion.getId_seccion();

                String query = String.format("INSERT INTO public.\"Inscripcion\"(id_estudiante, id_asignatura, id_periodo, id_seccion,estado) VALUES ('%s', '%s', '%s', '%s', false);", estudiante_id, asignatura_id, periodo_id, seccion_id);
                int rowsAffected = statement.executeUpdate(query);
                totalRowsAffected += rowsAffected;
            }
            return totalRowsAffected;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.inscribirEstudiante() error: " + e);
            return -1;
        }
    }
    public List<ListadoSeccionModel> listaSecion() {
        
        try {
            
            String seccionesQuery = String.format("WITH Promedio_Seccion AS (SELECT ne.id_seccion, ROUND(AVG(ne.nota), 2) AS promedio_seccion FROM public.\"Nota_estudiante\" ne GROUP BY ne.id_seccion) SELECT s.numero_seccion, a.nombre_asignatura, p.nombre_completo, c.nombre_carrera, d.nombre_decanato, ROUND(PS.promedio_seccion, 2) AS promedio_seccion, SUM(CASE WHEN ne.nota >= 10 THEN 1 ELSE 0 END) AS numero_aprobados, SUM(CASE WHEN ne.nota < 10 THEN 1 ELSE 0 END) AS numero_reprobados, ARRAY_AGG(CASE WHEN ne.nota >= PS.promedio_seccion THEN e.nombre_completo END) AS e_encimaP, ARRAY_AGG(CASE WHEN ne.nota < PS.promedio_seccion THEN e.nombre_completo END) AS e_debajoP FROM public.\"Nota_estudiante\" ne JOIN public.\"Estudiantes\" e ON ne.id_estudiante = e.id_estudiante JOIN public.\"Asignaturas_carrera\" ac ON ne.id_asignatura = ac.id_asignatura JOIN public.\"Carreras\" c ON ac.id_carrera = c.id_carrera JOIN public.\"Decanatos\" d ON c.id_decanato = d.id_decanato JOIN public.\"Asignaturas\" a ON ne.id_asignatura = a.id_asignatura JOIN public.\"Secciones\" s ON ne.id_seccion = s.id_seccion JOIN public.\"Profesor_asignatura_seccion\" pas ON ne.id_seccion = pas.id_seccion AND ne.id_asignatura = pas.id_asignatura JOIN public.\"Profesor\" p ON pas.id_profesor = p.id_profesor JOIN Promedio_Seccion PS ON ne.id_seccion = PS.id_seccion GROUP BY d.nombre_decanato, c.nombre_carrera, a.nombre_asignatura, s.numero_seccion, p.nombre_completo, PS.promedio_seccion;");

            ResultSet seccionesResultSet = statement.executeQuery(seccionesQuery);

            ArrayList<ListadoSeccionModel> secciones = new ArrayList<>();

            while (seccionesResultSet.next()) {
                String numeroSeccion = seccionesResultSet.getString("numero_seccion");
                String nombreAsignatura = seccionesResultSet.getString("nombre_asignatura");
                String nombreCompleto = seccionesResultSet.getString("nombre_completo");
                String nombreCarrera = seccionesResultSet.getString("nombre_carrera");
                String nombreDecanato = seccionesResultSet.getString("nombre_decanato");
                float promedioSeccion = seccionesResultSet.getFloat("promedio_seccion");
                int numeroAprobados = seccionesResultSet.getInt("numero_aprobados");
                int numeroReprobados = seccionesResultSet.getInt("numero_reprobados");
                Array estudiantesEncimaPromedioArray = seccionesResultSet.getArray("e_encimaP");
                Array estudiantesDebajoPromedioArray = seccionesResultSet.getArray("e_debajoP");

                // Obtener los estudiantes encima del promedio sin valores nulos
                String[] estudiantesEncimaPromedio = filterNullValues(estudiantesEncimaPromedioArray);

                // Obtener los estudiantes debajo del promedio sin valores nulos
                String[] estudiantesDebajoPromedio = filterNullValues(estudiantesDebajoPromedioArray);


    
                ListadoSeccionModel seccion = new ListadoSeccionModel(numeroSeccion, nombreAsignatura, nombreCompleto, nombreCarrera, nombreDecanato, promedioSeccion, numeroAprobados, numeroReprobados, estudiantesEncimaPromedio, estudiantesDebajoPromedio);

                secciones.add(seccion);
            }
            return secciones;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        
        
    }
    
    // Método para filtrar los valores nulos de un Array y devolver un arreglo de String sin nulos
    private String[] filterNullValues(Array array) throws SQLException {
        if (array == null) {
            return new String[0]; // Retorna un arreglo vacío si el Array es nulo
        }

        // Obtiene el arreglo de Object y filtra los valores nulos
        Object[] arrayData = (Object[]) array.getArray();
        List<String> filteredList = new ArrayList<>();
        for (Object obj : arrayData) {
            if (obj != null) {
                filteredList.add(obj.toString());
            }
        }

        // Convierte la lista filtrada de vuelta a un arreglo de String
        return filteredList.toArray(new String[0]);
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
