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
public class Inscripcion {
    private  Date fecha;
    private final Estudiante estudiante;
    private final Carrera carrera;
    private final PeriodoAcademico periodo;
    private final Asignatura[] asignaturas;
    private final Seccion seccion;

    public Inscripcion(Date fecha, Estudiante estudiante, Carrera carrera,PeriodoAcademico periodo, Asignatura[] asignaturas, Seccion seccion) {
        this.fecha= fecha;
        this.estudiante=estudiante;
        this.carrera=carrera;
    	this.periodo = periodo;
        this.asignaturas = asignaturas;
        this.seccion = seccion;
    }
    public void setDate(Date fecha) {
    	this.fecha= fecha;
    }
    public Date getDate() {
    	return fecha;
    }
    
    public PeriodoAcademico getPeriodo() {
        return periodo;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public Seccion getSeccion() {
        return seccion;
    }
    
}
