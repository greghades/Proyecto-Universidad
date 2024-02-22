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

/**
 *
 * @author User
 */
public class Inscripcion {
    
    private final PeriodoAcademico periodo;
    private final Asignatura[] asignaturas;
    private final Seccion seccion;

    public Inscripcion(PeriodoAcademico periodo, Asignatura[] asignaturas, Seccion seccion) {
        this.periodo = periodo;
        this.asignaturas = asignaturas;
        this.seccion = seccion;
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
