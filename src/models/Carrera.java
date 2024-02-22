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
public class Carrera {
    
    private final int id;
    private final String nombre;
    private final Seccion[] secciones;
    private final PeriodoAcademico[] periodos;

    public Carrera(int id, String nombre, Seccion[] secciones, PeriodoAcademico[] periodos) {
        this.id = id;
        this.nombre = nombre;
        this.secciones = secciones;
        this.periodos = periodos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public PeriodoAcademico[] getPeriodos() {
        return periodos;
    }
    
    /*public Estudiante[] listarMejoresEstudiantes() {
        
    }
    
    public Estudiante[] listarEstudiantesPromedio() {
        
    }*/
    
}
