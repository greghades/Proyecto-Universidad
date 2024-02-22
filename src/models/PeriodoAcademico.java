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

package models;
import java.util.Date;

/**
 *
 * @author User
 */
public class PeriodoAcademico {
    
    private final int id;
    private final Date fechaInicio;
    private final Date fechaFin;
    private final Asignatura[] asignaturas;
    private Estudiante[] estudiantes;

    public PeriodoAcademico(int id, Date fechaInicio, Date fechaFin, Asignatura[] asignaturas) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.asignaturas = asignaturas;
    }

    public int getId() {
        return id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }
    
    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public Estudiante[] listarEstudiantesConMateriasRetiradas() {
        return estudiantes;
    }
    
}
