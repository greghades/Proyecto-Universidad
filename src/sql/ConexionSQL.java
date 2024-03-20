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
import java.text.DecimalFormat;
import java.util.ArrayList;
import models.*;

public class ConexionSQL {

    private static ConexionSQL instance = null;
    private Connection conn = null;
    private Statement statement;
    private final String db = "universidad";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String user = "postgres";
    private final String pass = "";

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

    public ArrayList<TresColumnasModel> getEstudiantesTres(String filtro) {
        try {
            String estudiantesQuery;

            if (filtro.equals("carrera")) {
                estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, c.nombre_carrera FROM public.\"Inscripcion\" i JOIN public.\"Estudiantes\" e ON i.id_estudiante = e.id_estudiante JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera GROUP BY e.id_estudiante, e.nombre_completo, c.nombre_carrera ORDER BY c.nombre_carrera";
            } else if (filtro.equals("16 promedios")) {
                estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, AVG(ne.nota) AS promedio_notas FROM public.\"Estudiantes\" e JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera JOIN public.\"Inscripcion\" i ON e.id_estudiante = i.id_estudiante JOIN public.\"Nota_estudiante\" ne ON i.id_estudiante = ne.id_estudiante AND i.id_asignatura = ne.id_asignatura AND i.id_seccion = ne.id_seccion GROUP BY e.id_estudiante, e.nombre_completo HAVING AVG(ne.nota) >= 16 ORDER BY promedio_notas DESC";
            } else {
                estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, min(s.numero_semestre) as numSem FROM public.\"Inscripcion\" i JOIN public.\"Estudiantes\" e ON i.id_estudiante = e.id_estudiante  JOIN public.\"Semestre_Asignatura\" sa ON i.id_asignatura = sa.id_asignatura  JOIN public.\"Semestre\" s ON sa.id_semestre = s.id_semestre GROUP BY e.id_estudiante, e.nombre_completo ORDER BY numSem";
            }
            ResultSet estudiantesSet = statement.executeQuery(estudiantesQuery);

            ArrayList<TresColumnasModel> estudiantesList = new ArrayList<>();
            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombreEstudiante = estudiantesSet.getString("nombre_completo");

                String extra;
                if (filtro.equals("carrera")) {
                    extra = estudiantesSet.getString("nombre_carrera");
                } else if (filtro.equals("16 promedios")) {
                    float promedio = estudiantesSet.getFloat("promedio_notas");
                    DecimalFormat df = new DecimalFormat("#.##");
                    extra = df.format(promedio);
                } else {
                    int semestre = estudiantesSet.getInt("numsem");
                    extra = String.format("Semestre %s", semestre);
                }

                TresColumnasModel model = new TresColumnasModel(cedula, nombreEstudiante, extra);
                estudiantesList.add(model);
            }
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<CuatroColumnasModel> getEstudiantesCuatro(String filtro) {
        try {
            String estudiantesQuery;

            if (filtro.equals("20 promedios carrera")) {
                estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, c.nombre_carrera, AVG(ne.nota) AS promedio_notas FROM public.\"Estudiantes\" e JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera JOIN public.\"Inscripcion\" i ON e.id_estudiante = i.id_estudiante JOIN public.\"Nota_estudiante\" ne ON i.id_estudiante = ne.id_estudiante AND i.id_asignatura = ne.id_asignatura AND i.id_seccion = ne.id_seccion GROUP BY e.id_estudiante, e.nombre_completo, c.nombre_carrera ORDER BY promedio_notas DESC LIMIT 20";
            } else {
                estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, d.nombre_decanato, AVG(ne.nota) AS promedio_notas FROM public.\"Estudiantes\" e JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera JOIN public.\"Decanatos\" d ON c.id_decanato = d.id_decanato JOIN public.\"Inscripcion\" i ON e.id_estudiante = i.id_estudiante JOIN public.\"Nota_estudiante\" ne ON i.id_estudiante = ne.id_estudiante AND i.id_asignatura = ne.id_asignatura AND i.id_seccion = ne.id_seccion GROUP BY e.id_estudiante, e.nombre_completo, d.nombre_decanato ORDER BY promedio_notas DESC LIMIT 20";
            }
            ResultSet estudiantesSet = statement.executeQuery(estudiantesQuery);

            ArrayList<CuatroColumnasModel> estudiantesList = new ArrayList<>();
            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombreEstudiante = estudiantesSet.getString("nombre_completo");
                float promedio = estudiantesSet.getFloat("promedio_notas");
                DecimalFormat df = new DecimalFormat("#.##");
                String promedioText = df.format(promedio);
                
                String extra;
                if (filtro.equals("20 promedios carrera")) {
                    extra = estudiantesSet.getString("nombre_carrera");
                } else {
                    extra = estudiantesSet.getString("nombre_decanato");
                }

                CuatroColumnasModel model = new CuatroColumnasModel(cedula, nombreEstudiante, extra, promedioText);
                estudiantesList.add(model);
            }
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<CincoColumnasModel> getEstudiantesCinco() {
        try {
            String estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, e.sexo, d.nombre_decanato, c.nombre_carrera FROM public.\"Estudiantes\" e JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera JOIN public.\"Decanatos\" d ON c.id_decanato = d.id_decanato JOIN public.\"Inscripcion\" i ON e.id_estudiante = i.id_estudiante GROUP BY e.id_estudiante, e.nombre_completo, d.nombre_decanato, c.nombre_carrera";
            ResultSet estudiantesSet = statement.executeQuery(estudiantesQuery);

            ArrayList<CincoColumnasModel> estudiantesList = new ArrayList<>();
            
            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombreEstudiante = estudiantesSet.getString("nombre_completo");
                String sexo = estudiantesSet.getString("sexo");
                String carrera = estudiantesSet.getString("nombre_carrera");
                String decanato = estudiantesSet.getString("nombre_decanato");

                CincoColumnasModel model = new CincoColumnasModel(cedula, nombreEstudiante, sexo, decanato, carrera);
                estudiantesList.add(model);
            }
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

    public void cerrar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa", "desconexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida" + e, "desconexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
