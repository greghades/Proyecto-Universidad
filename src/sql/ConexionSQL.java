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
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class ConexionSQL {

    private static ConexionSQL instance = null;
    private Connection conn = null;
    private Statement statement;
    private final String db = "universidad";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String user = "postgres";
    private final String pass = "1234";

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

    private ArrayList<Asignatura> getAsignaturasParaInscripcion(String id) {
        try {
            String asignaturasQuery;
            if (id.startsWith("CAR")) {
                asignaturasQuery = String.format("SELECT a.id_asignatura, a.nombre_asignatura, a.carga_academica FROM public.\"Asignaturas\" AS a INNER JOIN public.\"Asignaturas_carrera\" AS ac ON a.id_asignatura = ac.id_asignatura WHERE ac.id_carrera = '%s'", id);
            } else {
                asignaturasQuery = String.format("SELECT i.id_asignatura, a.nombre_asignatura, a.carga_academica, s.id_seccion, s.numero_seccion FROM public.\"Inscripcion\" i JOIN public.\"Estudiantes\" e ON i.id_estudiante = e.id_estudiante JOIN public.\"Asignaturas\" a ON i.id_asignatura = a.id_asignatura JOIN public.\"Secciones\" s ON i.id_seccion = s.id_seccion WHERE e.id_estudiante = '%s'", id);
            }
            ResultSet asignaturasSet = statement.executeQuery(asignaturasQuery);
            ArrayList<Asignatura> asignaturasList = new ArrayList<>();

            while (asignaturasSet.next()) {
                String idAsignatura = asignaturasSet.getString("id_asignatura");
                String nombreAsignatura = asignaturasSet.getString("nombre_asignatura");
                int cargaAcademica = asignaturasSet.getInt("carga_academica");

                Asignatura asignatura;
                if (id.startsWith("CAR")) {
                    asignatura = new Asignatura(idAsignatura, nombreAsignatura, cargaAcademica);
                } else {
                    int seccion = asignaturasSet.getInt("numero_seccion");
                    asignatura = new Asignatura(idAsignatura, nombreAsignatura, cargaAcademica, seccion);
                }
                asignaturasList.add(asignatura);
            }
            return asignaturasList;
        } catch (SQLException e) {
            return null;
        }
    }
    
        public Estudiante getEstudiante(String id, boolean esRetiro) {
        try {
            String query;
            if (esRetiro) {
             query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.id_carrera, c.nombre_carrera FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera INNER JOIN public.\"Inscripcion\" AS i ON e.id_estudiante = i.id_estudiante WHERE e.id_estudiante = '%s' GROUP BY e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.id_carrera, c.nombre_carrera", id);
            } else {
             query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.id_carrera, c.nombre_carrera FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera WHERE e.id_estudiante = '%s'", id);
            }
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

    public InscripcionInfo obtenerEstudianteConAsignaturas(String id, boolean esRetiro) {
        Estudiante estudiante = getEstudiante(id, esRetiro);
        if (estudiante == null) {
            return null;
        }
        System.out.println("cedula:" + estudiante.getCedula() + "nombre: " + estudiante.getNombre());
        ArrayList<Asignatura> asignaturasList = getAsignaturasParaInscripcion(esRetiro ? id : estudiante.getCarrera().getId());

        if (asignaturasList != null) {
            return new InscripcionInfo(estudiante, asignaturasList);
        } else {
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

    //ver profesor por asignatura y seccion
    public Profesor getProfesor(String idAsignatura, String idSeccion) {
        try {
            String query = String.format("SELECT p.id_profesor, p.nombre_completo, p.especialidad FROM public.\"Profesor\" AS p, public.\"Profesor_asignatura_seccion\" AS pas WHERE p.id_profesor = pas.id_profesor AND pas.id_asignatura = '%s' AND pas.id_seccion = '%s'", idAsignatura, idSeccion);
            ResultSet profesorSet = statement.executeQuery(query);
            Profesor profesor = null;

            while (profesorSet.next()) {
                String cedula = profesorSet.getString("id_profesor");
                String nombre = profesorSet.getString("nombre_completo");
                String especialidad = profesorSet.getString("especialidad");
                profesor = new Profesor(cedula, nombre, especialidad);
            }
            return profesor;
        } catch (SQLException e) {
            return null;
        }
    }

    
    //ver profesor por asignatura 
    public Profesor getDatosProfesor(String idProfesor) {
        try {
            String query = String.format("SELECT DISTINCT a.id_asignatura, a.nombre_asignatura, a.carga_academica, p.id_profesor, p.nombre_completo, p.correo, p.especialidad FROM public.\"Asignaturas\" a JOIN public.\"Profesor_asignatura_seccion\" pas ON a.id_asignatura = pas.id_asignatura JOIN public.\"Profesor\" p ON pas.id_profesor = p.id_profesor WHERE pas.id_profesor = '%s'", idProfesor);
            ResultSet profesorSet = statement.executeQuery(query);
            Profesor profesor = null;

            System.out.println("id: " + idProfesor);
            System.out.println("query: " + query);

            while (profesorSet.next()) {
                String cedula = profesorSet.getString("id_profesor");
                String nombre = profesorSet.getString("nombre_completo");
                String especialidad = profesorSet.getString("especialidad");

                if (profesor == null) {
                    profesor = new Profesor(cedula, nombre, especialidad);
                }

                String idAsignatura = profesorSet.getString("id_asignatura");
                String nombreAsignatura = profesorSet.getString("nombre_asignatura");
                int cargaAsignatura = profesorSet.getInt("carga_academica");

                Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, cargaAsignatura);
                profesor.setAsignatura(asignatura);
            }

            return profesor;
        } catch (SQLException e) {
            return null;
        }
    }
    
    //CRUD Profesor   
    //mostrar profesor
    public Profesor motrarDatosProfesor(String id) {
        try {
            String query;
             query = String.format("SELECT * FROM public.\"Profesor\" WHERE id_profesor = '%s'", id);
            
            ResultSet bigSet = statement.executeQuery(query);
            Profesor profesor = null;

            while (bigSet.next()) {
                String cedula = bigSet.getString("id_profesor");
                String nombreCompleto = bigSet.getString("nombre_completo");
                int edad = bigSet.getInt("edad");
                String correo = bigSet.getString("correo");
                String sexo = bigSet.getString("sexo");
                String especialidad = bigSet.getString("especialidad");
                
                profesor = new Profesor(cedula, nombreCompleto, sexo, correo, edad, sexo, especialidad);
                

            }

            return profesor;
        } catch (SQLException e) {
            return null;
        }
    }
    
    //CRUD Estudiante  
   public boolean insertarEstudiante(Estudiante estudiante) {
    PreparedStatement preparedStatement = null;
       try {
        String query = "INSERT INTO public.\"Estudiantes\" (id_estudiante, id_carrera, nombre_completo, edad, correo, direccion, sexo, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, estudiante.getCedula());
        preparedStatement.setString(2, String.valueOf(estudiante.getCarrera()));
        preparedStatement.setString(3, estudiante.getNombre());
        preparedStatement.setInt(4, estudiante.getEdad());
        preparedStatement.setString(5, estudiante.getCorreo());
        preparedStatement.setString(6, " "); 
        preparedStatement.setString(7, estudiante.getSexo());
        preparedStatement.setString(8, String.valueOf(true));
        preparedStatement.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.err.println("sql.ConexionSQL.agregarEstudiante() error: " + e);
    }
        return false;
}
   public void modificarEstudiante(Estudiante estudiante) {
       try {
        String query = "UPDATE public.\"Estudiantes\" SET id_estudiante = %s , id_carrera= %s , nombre_completo= %s , edad= %s , correo= %s , direccion= %s , sexo= %s , estado= %s  WHERE id_estudiante = '%s';";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, estudiante.getCedula());
        preparedStatement.setString(2, String.valueOf(estudiante.getCarrera()));
        preparedStatement.setString(3, estudiante.getNombre());
        preparedStatement.setInt(4, estudiante.getEdad());
        preparedStatement.setString(5, estudiante.getCorreo());
        preparedStatement.setString(6, " "); 
        preparedStatement.setString(7, estudiante.getSexo());
        preparedStatement.setString(8, String.valueOf(true));
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("sql.ConexionSQL.agregarEstudiante() error: " + e.getMessage());
    }

}
   //duda porque aqui esta es buscando inhabilitar estudiante 
  public void eliminarEstudiante(Estudiante estudiante) {
       try {
        String query = "UPDATE public.\"Estudiantes\" SET estado = %s  WHERE id_estudiante = '%s';";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, estudiante.getCedula());
        preparedStatement.setString(8, String.valueOf(false));
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("sql.ConexionSQL.agregarEstudiante() error: " + e.getMessage());
    }

}
   
    

    public List<NotaEstudianteListModel> getEstudiantesParaAsignarNota(String idProfesor, String idAsignatura) {
        try {
            String query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.correo, c.nombre_carrera, s.numero_seccion, i.id_seccion, ne.nota FROM public.\"Estudiantes\" e JOIN public.\"Inscripcion\" i ON e.id_estudiante = i.id_estudiante JOIN public.\"Secciones\" s ON i.id_seccion = s.id_seccion JOIN public.\"Carreras\" c ON e.id_carrera = c.id_carrera JOIN public.\"Profesor_asignatura_seccion\" pas ON i.id_asignatura = pas.id_asignatura AND i.id_seccion = pas.id_seccion LEFT JOIN public.\"Nota_estudiante\" ne ON ne.id_estudiante = e.id_estudiante AND ne.id_asignatura = i.id_asignatura AND ne.id_seccion = i.id_seccion WHERE pas.id_profesor = '%s' AND i.id_asignatura = '%s' ORDER BY s.numero_seccion", idProfesor, idAsignatura);
            ResultSet estudiantesSet = statement.executeQuery(query);
            List<NotaEstudianteListModel> estudiantesList = new ArrayList<>();

            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombre = estudiantesSet.getString("nombre_completo");
                String correo = estudiantesSet.getString("correo");
                String carrera = estudiantesSet.getString("nombre_carrera");
                int seccion = estudiantesSet.getInt("numero_seccion");
                String idSeccion = estudiantesSet.getString("id_seccion");
                Float nota = estudiantesSet.getFloat("nota");

                NotaEstudianteListModel model = new NotaEstudianteListModel(cedula, nombre, correo, carrera, String.format("Seccion %d", seccion), idSeccion, nota);

                estudiantesList.add(model);
            }
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public int actualizarNotasEstudiantes(List<NotaEstudianteListModel> notasEstudiantes, String idAsignatura) {
        try {
            int totalRowsAffected = 0;
            for (int index = 0; index < notasEstudiantes.size(); index++) {
                NotaEstudianteListModel notaEstudiante = notasEstudiantes.get(index);

                String estudiante_id = notaEstudiante.getCedula();
                String seccion_id = notaEstudiante.getId_seccion();
                Float nota = notaEstudiante.getNota();

                String query;
                if (notaEstudiante.isTieneNota()) {
                    query = String.format("UPDATE public.\"Nota_estudiante\" ne SET nota = %s WHERE ne.id_estudiante = '%s' AND ne.id_asignatura = '%s' AND ne.id_seccion = '%s'", nota, estudiante_id, idAsignatura, seccion_id);
                } else {
                    query = String.format("INSERT INTO public.\"Nota_estudiante\"(id_estudiante, id_asignatura, id_seccion, nota) VALUES ('%s', '%s', '%s', '%s')", estudiante_id, idAsignatura, seccion_id, String.valueOf(nota));
                }
                System.out.println("cedula: " + estudiante_id + " seccion: " + seccion_id + " tieneNota: " + notaEstudiante.isTieneNota() + " query: " + query);
                int rowsAffected = statement.executeUpdate(query);
                totalRowsAffected += rowsAffected;
            }
            return totalRowsAffected;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.inscribirEstudiante() error: " + e);
            return -1;
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

    public int retirarAsignatura(ArrayList<InscripcionData> retiros) {
        try {
            int totalRowsAffected = 0;
            for (int index = 0; index < retiros.size(); index++) {
                InscripcionData inscripcion = retiros.get(index);

                String estudiante_id = inscripcion.getId_estudiante();
                String asignatura_id = inscripcion.getId_asignatura();
                String periodo_id = inscripcion.getId_periodo();
                String seccion_id = inscripcion.getId_seccion();
                
                String query = String.format("DELETE FROM public.\"Inscripcion\" WHERE id_estudiante = '%s' AND id_asignatura = '%s' AND id_periodo = '%s' AND id_seccion = '%s'", estudiante_id, asignatura_id, periodo_id, seccion_id);
                int rowsAffected = statement.executeUpdate(query);
                totalRowsAffected += rowsAffected;
            }
            return totalRowsAffected;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.inscribirEstudiante() error: " + e);
            return -1;
        }
    }

    public List<ListadoSeccionModel> getListadoSeccion() {

        try {

            String seccionesQuery = String.format("WITH Promedio_Seccion AS (SELECT ne.id_seccion, ROUND(AVG(ne.nota)::numeric, 2) AS promedio_seccion FROM public.\"Nota_estudiante\" ne GROUP BY ne.id_seccion) SELECT s.numero_seccion, a.nombre_asignatura, p.nombre_completo, c.nombre_carrera, d.nombre_decanato, ROUND(PS.promedio_seccion, 2) AS promedio_seccion, SUM(CASE WHEN ne.nota >= 10 THEN 1 ELSE 0 END) AS numero_aprobados, SUM(CASE WHEN ne.nota < 10 THEN 1 ELSE 0 END) AS numero_reprobados, ARRAY_AGG(CASE WHEN ne.nota >= PS.promedio_seccion THEN e.nombre_completo END) AS e_encimaP, ARRAY_AGG(CASE WHEN ne.nota < PS.promedio_seccion THEN e.nombre_completo END) AS e_debajoP FROM public.\"Nota_estudiante\" ne JOIN public.\"Estudiantes\" e ON ne.id_estudiante = e.id_estudiante JOIN public.\"Asignaturas_carrera\" ac ON ne.id_asignatura = ac.id_asignatura JOIN public.\"Carreras\" c ON ac.id_carrera = c.id_carrera JOIN public.\"Decanatos\" d ON c.id_decanato = d.id_decanato JOIN public.\"Asignaturas\" a ON ne.id_asignatura = a.id_asignatura JOIN public.\"Secciones\" s ON ne.id_seccion = s.id_seccion JOIN public.\"Profesor_asignatura_seccion\" pas ON ne.id_seccion = pas.id_seccion AND ne.id_asignatura = pas.id_asignatura JOIN public.\"Profesor\" p ON pas.id_profesor = p.id_profesor JOIN Promedio_Seccion PS ON ne.id_seccion = PS.id_seccion GROUP BY d.nombre_decanato, c.nombre_carrera, a.nombre_asignatura, s.numero_seccion, p.nombre_completo, PS.promedio_seccion");

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

                Array estudiantesEncimaPromedioArray = seccionesResultSet.getArray("e_encimap");
                // Obtener los estudiantes encima del promedio sin valores nulos
                int estudiantesEncimaPromedio = getArrayLengthWithoutNulls(estudiantesEncimaPromedioArray);

                Array estudiantesDebajoPromedioArray = seccionesResultSet.getArray("e_debajop");
                // Obtener los estudiantes debajo del promedio sin valores nulos
                int estudiantesDebajoPromedio = getArrayLengthWithoutNulls(estudiantesDebajoPromedioArray);

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
    // Método para obtener la longitud del array sin valores nulos
    private int getArrayLengthWithoutNulls(Array array) throws SQLException {
        if (array == null) {
            return 0;
        } else {
            String[] estudiantes = (String[]) array.getArray();
            int count = 0;
            for (String estudiante : estudiantes) {
                if (estudiante != null) {
                    count++;
                }
            }
            return count;
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
