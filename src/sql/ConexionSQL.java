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
import java.util.List;
import models.*;

public class ConexionSQL {

    private static ConexionSQL instance = null;
    private Connection conn = null;
    private Statement statement;
    private final String db = "universidad";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String user = "postgres";
    private final String pass = "123456789";

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

    public boolean validarInscripcion(String id) {
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

    public PeriodoAcademico obtenerPeriodoAcademico(String id) {
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

    private ArrayList<Asignatura> obtenerAsignaturasParaInscripcion(String id) {
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
                    Seccion seccion = new Seccion(asignaturasSet.getString("id_seccion"), 32, asignaturasSet.getInt("numero_seccion"));
                    asignatura = new Asignatura(idAsignatura, nombreAsignatura, cargaAcademica, seccion);
                }
                asignaturasList.add(asignatura);
            }
            return asignaturasList;
        } catch (SQLException e) {
            return null;
        }
    }

    public Estudiante obtenerEstudiante(String id, boolean esRetiro) {
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
        Estudiante estudiante = ConexionSQL.this.obtenerEstudiante(id, esRetiro);
        if (estudiante == null) {
            return null;
        }
        ArrayList<Asignatura> asignaturasList = obtenerAsignaturasParaInscripcion(esRetiro ? id : estudiante.getCarrera().getId());

        if (asignaturasList != null) {
            return new InscripcionInfo(estudiante, asignaturasList);
        } else {
            return null;
        }
    }

    public ArrayList<TresColumnasModel> obtenerEstudiantesParaListadoTresColumnas(String filtro) {
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

            System.out.println("query: " + estudiantesQuery + " filtro: " + filtro);
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

                System.out.println("resultado listado estudiantes:" + cedula + " nombre: " + nombreEstudiante);
                TresColumnasModel model = new TresColumnasModel(cedula, nombreEstudiante, extra);
                estudiantesList.add(model);
            }
            System.out.println("total estudiantes: " + estudiantesList.size() + " filtro: " + filtro);
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<CuatroColumnasModel> obtenerEstudiantesConMateriasRetiradas() {
        try {
            String estudiantesQuery = "SELECT e.id_estudiante, e.nombre_completo, a.id_asignatura, a.nombre_asignatura, s.id_semestre, s.numero_semestre FROM public.\"Retiro_materia_estudiante\" r JOIN public.\"Estudiantes\" e ON r.id_estudiante = e.id_estudiante JOIN public.\"Asignaturas\" a ON r.id_asignatura = a.id_asignatura JOIN public.\"Semestre_Asignatura\" sa ON r.id_asignatura = sa.id_asignatura JOIN public.\"Semestre\" s ON sa.id_semestre = s.id_semestre";
            ResultSet estudiantesSet = statement.executeQuery(estudiantesQuery);

            ArrayList<CuatroColumnasModel> estudiantesList = new ArrayList<>();
            while (estudiantesSet.next()) {
                String cedula = estudiantesSet.getString("id_estudiante");
                String nombreEstudiante = estudiantesSet.getString("nombre_completo");
                String nombreAsignatura = estudiantesSet.getString("nombre_asignatura");
                CuatroColumnasModel model = new CuatroColumnasModel(cedula, nombreEstudiante, nombreAsignatura, "Primer Periodo 2024");
                estudiantesList.add(model);
            }
            return estudiantesList;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<CuatroColumnasModel> obtenerEstudiantesParaListadoCuatroColumnas(String filtro) {
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

    public ArrayList<CincoColumnasModel> obtenerEstudiantesParaListadoCincoColumnas() {
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

    public ArrayList<Seccion> obtenerSecciones(String idAsignatura) {
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

    public Profesor obtenerProfesorPorAsignaturaYSeccion(String idAsignatura, String idSeccion) {
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

    public Universidad obtenerUniversidad(String id) {
        String query;
        try {
            query = String.format("SELECT * FROM public.\"Universidad\" WHERE id_universidad = '%s'", id);
            ResultSet bigSet = statement.executeQuery(query);
            Universidad universidad = null;

            while (bigSet.next()) {
                String idUni = bigSet.getString("id_universidad");
                String nombreUni = bigSet.getString("nombre_universidad");
                String direccion = bigSet.getString("direccion");

                universidad = new Universidad(idUni, nombreUni, direccion);
            }

            return universidad;
        } catch (SQLException e) {
            return null;
        }
    }

    public int agregarUniversidad(Universidad universidad) {
        try {
            //obtener valores del formulario 
            String idUni = universidad.getId();
            String nombre = universidad.getNombre();
            String direccion = universidad.getDireccion();

            String query = String.format("INSERT INTO public.\"Universidad\" (id_universidad, nombre_universidad, direccion) VALUES ('%s', '%s', '%s');", idUni, nombre, direccion);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.agregarProfesor() error: " + e);
            return -1;
        }
    }
    
    
        public Carrera obtenerCarrera(String id) {
        String query;
        try {
            query = String.format("SELECT c.id_carrera, c.nombre_carrera, c.modalidad, c.duracion, c.estado, d.id_decanato, d.nombre_decanato FROM public.\"Carreras\" AS c INNER JOIN public.\"Decanatos\" AS d ON c.id_decanato = d.id_decanato WHERE c.id_carrera = '%s'", id);
            ResultSet bigSet = statement.executeQuery(query);
            System.out.println("query" + query);
            Carrera carrera = null;

            while (bigSet.next()) {
                String idCarrera = bigSet.getString("id_carrera");
                String nombreCar = bigSet.getString("nombre_carrera");
                String modalidad = bigSet.getString("modalidad");
                int duracion = bigSet.getInt("duracion");
                String nombre_decanato = bigSet.getString("nombre_decanato");
                String id_decanato = bigSet.getString("id_decanato");
                Decanato decanato = new Decanato(id_decanato, nombre_decanato);
                System.out.println("decanatoooo " + decanato.getNombre());
               
                carrera = new Carrera(idCarrera, decanato, nombreCar, modalidad, duracion);
                 System.out.println("carrertita" + carrera);
            }

            return carrera;
        } catch (SQLException e) {
            return null;
        }
    }
        public int agregarCarrera(Carrera carrera) {
        try {
            //obtener valores del formulario 
            String idCarrera = carrera.getId();
            String nombre = carrera.getNombre();
            String id_decanato = carrera.getDecanato().getId();
            String modalidad = carrera.getModalidad();
            int duracion = carrera.getDuracion();

            String query = String.format("INSERT INTO public.\"Carreras\" (id_carrera,id_decanato,nombre_carrera,modalidad,estado,duracion) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');", idCarrera, id_decanato, nombre, modalidad,true, duracion);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.agregarCarrera() error: " + e);
            return -1;
        }
    }

    //ver profesor por asignatura 
    public Profesor obtenerProfesorPorAsignatura(String idProfesor) {
        try {
            String query = String.format("SELECT DISTINCT a.id_asignatura, a.nombre_asignatura, a.carga_academica, p.id_profesor, p.nombre_completo, p.correo, p.especialidad FROM public.\"Asignaturas\" a JOIN public.\"Profesor_asignatura_seccion\" pas ON a.id_asignatura = pas.id_asignatura JOIN public.\"Profesor\" p ON pas.id_profesor = p.id_profesor WHERE pas.id_profesor = '%s'", idProfesor);
            ResultSet profesorSet = statement.executeQuery(query);
            Profesor profesor = null;

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

    public int agregarProfesor(Profesor profesor) {
        try {
            //obtener valores del formulario 
            String cedula = profesor.getCedula();
            String nombre_completo = profesor.getNombre();
            int edad = profesor.getEdad();
            String correo = profesor.getCorreo();
            String sexo = profesor.getSexo();
            String especialidad = profesor.getEspecialidad();

            String query = String.format("INSERT INTO public.\"Profesor\" (id_profesor, nombre_completo, edad, correo, sexo, especialidad, estado) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');", cedula, nombre_completo, edad, correo, sexo, especialidad, true);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.agregarProfesor() error: " + e);
            return -1;
        }
    }

    public int eliminarProfesor(String id) {
        try {
            String querySecundario = String.format("DELETE FROM public.\"Profesor_asignatura_seccion\" WHERE id_profesor = '%s'", id);
            int contadorSecundario = statement.executeUpdate(querySecundario);
            String queryPrincipal = String.format("DELETE FROM public.\"Profesor\" WHERE id_profesor = '%s'", id);
            int contadorPrincipal = statement.executeUpdate(queryPrincipal);

            boolean validacionDoble = contadorSecundario > 0 && contadorPrincipal > 0;
            if (contadorSecundario > 0 ? validacionDoble : contadorPrincipal > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.eliminarProfesor() error: " + e);
            return -1;
        }
    }

    //eliminar Universidad a partir de un id 
    public int eliminarUniversidad(String id) {
        try {

            String queryDelete = String.format("DELETE FROM public.\"Universidad\" WHERE id_universidad = '%s'", id);

            statement.executeUpdate(queryDelete);

            return 1;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.eliminarProfesor() error: " + e);
            return -1;
        }
    }
    
        //eliminar carrera a partir de un id 
    public int eliminarCarrera(String id) {
        try {
            String query5= String.format("DELETE FROM public.\"Inscripcion\" WHERE id_estudiante IN (SELECT id_estudiante FROM public.\"Estudiantes\" WHERE id_carrera = '%s');", id);
            String query4 = String.format("DELETE FROM public.\"Nota_estudiante\" WHERE id_estudiante IN ( SELECT id_estudiante FROM public.\"Estudiantes\" WHERE id_carrera = '%s');", id);
            String query3 = String.format("DELETE FROM public.\"Asignaturas_carrera\" WHERE id_carrera = '%s';", id);
            String query2 = String.format("DELETE FROM public.\"Estudiantes\" WHERE id_carrera = '%s'", id);
            String query1 = String.format("DELETE FROM public.\"Carreras\" WHERE id_carrera = '%s'", id);
            
            int contador1 = statement.executeUpdate(query1);
            int contador2 = statement.executeUpdate(query2);
            int contador3 = statement.executeUpdate(query3);
            int contador4 = statement.executeUpdate(query4);
            int contador5 = statement.executeUpdate(query5);
            
            boolean validacion1 = contador1 > 0;
            boolean validacion2 = contador1 > 0 && contador2 > 0;
            boolean validacion3 = contador1 > 0 && contador2 > 0 && contador3 > 0;
            boolean validacion4 = contador1 > 0 && contador2 > 0 && contador3 > 0 && contador4 > 0;
            boolean validacion5 = contador1 > 0 && contador2 > 0 && contador3 > 0 && contador4 > 0 && contador5 > 0;
            
            if(validacion5){
                return 1;
            }
             else if (validacion4) {
                return 1;
            }
            else if (validacion3) {
                return 1;
            } else if (validacion2) {
                return 1;
            } else if (validacion1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.eliminarCarrera() error: " + e);
            return -1;
        }
    }

    public int modificarProfesor(Profesor profesor, String id) {
        try {
            String nombre_completo = profesor.getNombre();
            int edad = profesor.getEdad();
            String correo = profesor.getCorreo();
            String sexo = profesor.getSexo();
            String especialidad = profesor.getEspecialidad();

            String query = String.format("UPDATE public.\"Profesor\" SET nombre_completo = '%s', edad = '%s', correo = '%s', sexo = '%s', especialidad = '%s', estado = '%s' WHERE id_profesor = '%s'", nombre_completo, edad, correo, sexo, especialidad, true, id);

            System.out.println("cedula profesor : " + id + "nombre completo: " + nombre_completo + "Edad " + edad + "correo: " + correo + "sexo: " + sexo + "especialidad: " + especialidad + "query: " + query);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.modificarProfesor() error: " + e);
            return -1;
        }
    }

    public Profesor obtenerProfesor(String id) {
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

    public int modificarUniversidad(Universidad universidad, String id) {
        try {
            //obtener valores del formulario 
            String nombre = universidad.getNombre();
            String direccion = universidad.getDireccion();

            String query = String.format("UPDATE public.\"Universidad\" SET nombre_universidad = '%s', direccion = '%s' WHERE id_universidad = '%s'", nombre, direccion, id);

            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.modificarProfesor() error: " + e);
            return -1;
        }
    }
    
    public int modificarCarrera(Carrera carrera, String id) {
        try {
            //obtener valores del formulario 
            String nombre = carrera.getNombre();
            String id_decanato = carrera.getDecanato().getId();
            String modalidad = carrera.getModalidad();
            int duracion = carrera.getDuracion();

            String query = String.format("UPDATE public.\"Carreras\" SET nombre_carrera = '%s', id_decanato = '%s', modalidad = '%s', duracion = '%s',  estado = '%s' WHERE id_carrera = '%s';", nombre, id_decanato, modalidad, duracion, true, id);
            System.out.println("query carrera" + query);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.modificarCarrera() error: " + e);
            return -1;
        }
    }

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

    public ArrayList<Carrera> obtenerCarreras() {
        try {
            String query = "SELECT c.id_carrera, c.nombre_carrera FROM public.\"Carreras\" c";
            ResultSet carreraSet = statement.executeQuery(query);

            ArrayList<Carrera> carreras = new ArrayList<>();
            while (carreraSet.next()) {
                String id_carrera = carreraSet.getString("id_carrera");
                String nombre = carreraSet.getString("nombre_carrera");
                carreras.add(new Carrera(id_carrera, nombre));
            }
            return carreras;

        } catch (SQLException e) {
            return null;
        }
    }
    
     public ArrayList<Decanato> obtenerDecanatos() {
        try {
            String query = "SELECT d.id_decanato, d.nombre_decanato FROM public.\"Decanatos\" d;";
            System.out.println("query " + query);
            ResultSet decanatoSet = statement.executeQuery(query);
            
            ArrayList<Decanato> decanatos = new ArrayList<>();
            while (decanatoSet.next()) {
                String id_decanato= decanatoSet.getString("id_decanato");
                String nombre = decanatoSet.getString("nombre_decanato");
                decanatos.add(new Decanato(id_decanato, nombre));
            }
            System.out.println("decanato " + decanatos);
            return decanatos;

        } catch (SQLException e) {
            return null;
        }
    }

    public int agregarEstudiante(Estudiante estudiante) {
        try {
            String id_estudiante = estudiante.getCedula();
            String id_carrera = estudiante.getCarrera().getId();
            String nombre = estudiante.getNombre();
            int edad = estudiante.getEdad();
            String correo = estudiante.getCorreo();
            String sexo = estudiante.getSexo();

            String query = String.format("INSERT INTO public.\"Estudiantes\" (id_estudiante, id_carrera, nombre_completo, edad, correo, direccion, sexo, estado) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", id_estudiante, id_carrera, nombre, edad, correo, " ", sexo, true);

            int row = statement.executeUpdate(query);
            System.out.println("query: " + query + " row: " + row);
            return row;
        } catch (SQLException e) {
            System.err.println("sql.ConexionSQL.agregarEstudiante() error: " + e);
            return -1;
        }
    }

    //modificar
    public int modificarEstudiante(Estudiante estudiante, String id) {
        try {
            String id_carrera = estudiante.getCarrera().getId();
            String nombre = estudiante.getNombre();
            int edad = estudiante.getEdad();
            String correo = estudiante.getCorreo();
            String sexo = estudiante.getSexo();

            String query = String.format("UPDATE public.\"Estudiantes\" SET id_carrera = '%s', nombre_completo = '%s', edad = '%s', correo = '%s', direccion = '%s', sexo = '%s', estado = '%s' WHERE id_estudiante = '%s'", id_carrera, nombre, edad, correo, " ", sexo, true, id);

            System.out.println("query modificar" + query);
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.modificarEstudiante() error: " + e);
            return -1;
        }
    }

    public int eliminarEstudiante(String id) {
        try {
            String query4 = String.format("DELETE FROM public.\"Retiro_materia_estudiante\" WHERE id_estudiante = '%s';", id);
            String query3 = String.format("DELETE FROM public.\"Nota_estudiante\" WHERE id_estudiante = '%s';", id);
            String query2 = String.format("DELETE FROM public.\"Inscripcion\" WHERE id_estudiante = '%s';", id);
            String query1 = String.format("DELETE FROM public.\"Estudiantes\" WHERE id_estudiante = '%s';", id);

            int contador1 = statement.executeUpdate(query1);
            int contador2 = statement.executeUpdate(query2);
            int contador3 = statement.executeUpdate(query3);
            int contador4 = statement.executeUpdate(query4);

            boolean validacion1 = contador1 > 0;
            boolean validacion2 = contador1 > 0 && contador2 > 0;
            boolean validacion3 = contador1 > 0 && contador2 > 0 && contador3 > 0;
            boolean validacion4 = contador1 > 0 && contador2 > 0 && contador3 > 0 && contador4 > 0;

            if (validacion4) {
                return 1;
            } else if (validacion3) {
                return 1;
            } else if (validacion2) {
                return 1;
            } else if (validacion1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.inscribirEstudiante() error: " + e);
            return -1;
        }
    }

    //buscar Estudiante
    public Estudiante obtenerEstudiante(String id) {
        try {
            System.out.println("cedulita" + id);
            String query = String.format("SELECT e.id_estudiante, e.nombre_completo, e.edad, e.sexo, e.correo, c.id_carrera, c.nombre_carrera FROM public.\"Estudiantes\" AS e INNER JOIN public.\"Carreras\" AS c ON e.id_carrera = c.id_carrera WHERE e.id_estudiante = '%s'", id);
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

    public List<NotaEstudianteListModel> obtenerEstudiantesParaAsignarNota(String idProfesor, String idAsignatura) {
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

                String query = String.format("INSERT INTO public.\"Inscripcion\"(id_estudiante, id_asignatura, id_periodo, id_seccion,estado) VALUES ('%s', '%s', '%s', '%s', false)", estudiante_id, asignatura_id, periodo_id, seccion_id);
                int rowsAffected = statement.executeUpdate(query);
                totalRowsAffected += rowsAffected;
            }
            return totalRowsAffected;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.inscribirEstudiante() error: " + e);
            return -1;
        }
    }

    public String revisarRetiroMateria(String id) {
        try {
            String query = String.format("SELECT rme.id_estudiante FROM public.\"Retiro_materia_estudiante\" AS rme WHERE rme.id_estudiante = '%s'", id);
            ResultSet retiroMateriaEstudianteSet = statement.executeQuery(query);

            String cedulaString = "";

            while (retiroMateriaEstudianteSet.next()) {
                String cedula = retiroMateriaEstudianteSet.getString("id_estudiante");
                cedulaString = cedula;
            }
            return cedulaString;
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.retirarAsignatura() error: " + e);
            return null;
        }
    }

    public String retirarAsignatura(InscripcionData retiro) {
        try {
            String estudiante_id = retiro.getId_estudiante();
            String asignatura_id = retiro.getId_asignatura();
            String periodo_id = retiro.getId_periodo();
            String seccion_id = retiro.getId_seccion();

            System.out.print("\ncedula: " + estudiante_id + " asignatura: " + asignatura_id + " seccion: " + seccion_id + " periodo: " + periodo_id);
            String borrarInscripcionQuery = String.format("DELETE FROM public.\"Inscripcion\" WHERE id_estudiante = '%s' AND id_asignatura = '%s' AND id_periodo = '%s' AND id_seccion = '%s'", estudiante_id, asignatura_id, periodo_id, seccion_id);
            int borrarInscripcionCodigo = statement.executeUpdate(borrarInscripcionQuery);
            System.out.print("\ncodigo: " + borrarInscripcionCodigo);
            System.out.print("\nquery: " + borrarInscripcionQuery);

            if (borrarInscripcionCodigo == 0) {
                return "No se pudo llevar a cabo el retiro de la asignatura correctamente";
            } else {
                String id_estudiante = retiro.getId_estudiante();
                String id_asignatura = retiro.getId_asignatura();
                String retiroQuery = String.format("INSERT INTO public.\"Retiro_materia_estudiante\" (id_estudiante, id_asignatura) VALUES ('%s', '%s')", id_estudiante, id_asignatura);
                int retiroCodigo = statement.executeUpdate(retiroQuery);
                System.out.print("Codigo de retiroQuery: " + retiroCodigo);
                if (retiroCodigo == 0) {
                    return "No se pudo actualizar la base de datos con las materias a retirar.";
                } else {
                    System.out.print("\nSe creo exitosamente la entrada a Retiro_materia_estudiante");
                }
                return "La asignatura fue retirada de manera exitosa";
            }
        } catch (SQLException e) {
            System.out.println("sql.ConexionSQL.retirarAsignatura() error: " + e);
            return "No se pudo eliminar el registro de inscripcion de la materia a retirar.";
        }
    }

    public List<ListadoSeccionModel> obtenerListadoSeccion() {

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
    
    public List<Asignatura> obtenerAsignaturas() {
        try {
            String query = "SELECT * FROM public.\"Asignaturas\"";
            ResultSet asignaturasResultSet = statement.executeQuery(query);
            
            ArrayList<Asignatura> asignaturas = new ArrayList<>();
            
            while(asignaturasResultSet.next()) {
                String id_asignatura = asignaturasResultSet.getString("id_asignatura");
                String nombre_asignatura = asignaturasResultSet.getString("nombre_asignatura");
                int carga_academica = asignaturasResultSet.getInt("carga_academica");
                
                Asignatura asignatura = new Asignatura(id_asignatura, nombre_asignatura, carga_academica);
                asignaturas.add(asignatura);
            }
            
            return asignaturas;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public List<Profesor> obtenerProfesoresSinSeccion() {
        try {
            String query = "SELECT * FROM public.\"Profesor\" WHERE id_profesor NOT IN (SELECT id_profesor FROM public.\"Profesor_asignatura_seccion\" GROUP BY id_profesor HAVING COUNT(*) > 1)";
            ResultSet profesoresResultSet = statement.executeQuery(query);
            
            ArrayList<Profesor> profesores = new ArrayList<>();
            
            while(profesoresResultSet.next()) {
                String id_profesor = profesoresResultSet.getString("id_profesor");
                int edad = profesoresResultSet.getInt("edad");
                String nombre_completo = profesoresResultSet.getString("nombre_completo");
                String correo = profesoresResultSet.getString("correo");
                String sexo = profesoresResultSet.getString("sexo");
                String especialidad = profesoresResultSet.getString("especialidad");
                
                Profesor profesor = new Profesor(id_profesor, nombre_completo, "", correo, edad, sexo, especialidad);
                profesores.add(profesor);
            }
            
            return profesores;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public String obtenerNuevoID(String tipo) {

        String prefijo = null;
        String id = null;
        String tabla = null;

        switch (tipo) {
            case "profesor" -> {
                prefijo = "PRO";
                id = "id_profesor";
                tabla = "Profesor";
            }
            case "universidad" -> {
                prefijo = "UNI";
                id = "id_universidad";
                tabla = "Universidad";
            }
            case "profesor_asignatura_seccion" -> {
                prefijo = "PAS";
                id = "id_profesor_asignatura";
                tabla = "Profesor_asignatura_seccion";
            }
             case "carrera" -> {
                prefijo = "CAR";
                id = "id_carrera";
                tabla = "Carreras";
            }
        }

        if (prefijo == null || id == null || tabla == null) {
            return null;
        }

        try {
            String idQuery = String.format("SELECT '%s-' || LPAD((MAX(CAST(SUBSTRING(%s, 5) AS INTEGER)) + 1)::VARCHAR, 3, '0') AS nuevo_id FROM public.\"%s\"", prefijo, id, tabla);
            ResultSet nuevoIDResultSet = statement.executeQuery(idQuery);

            String nuevoID = "";

            while (nuevoIDResultSet.next()) {
                String db_id = nuevoIDResultSet.getString("nuevo_id");
                nuevoID = db_id;
            }

            return nuevoID;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public int asignarSeccion(String prof_id, String asig_id, String sec_id) {
        try {
            String pasID = obtenerNuevoID("profesor_asignatura_seccion");
            
            String query = String.format("INSERT INTO public.\"Profesor_asignatura_seccion\" (id_profesor_asignatura, id_profesor, id_asignatura, id_seccion) VALUES ('%s', '%s', '%s', '%s');", pasID, prof_id, asig_id, sec_id);
            int asignarSeccionCodigo = statement.executeUpdate(query);
            System.out.println("asignar codigo: " + asignarSeccionCodigo + " query: " + query);
            return asignarSeccionCodigo;
        } catch (SQLException e) {
            System.err.println(e);
            return -1;
        }
    }

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

    public void cerrar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "desconexion exitosa", "desconexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida" + e, "desconexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
