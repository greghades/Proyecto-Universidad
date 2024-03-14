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
    
    private String id;
    private String nombre;
    private Seccion[] secciones;
    private PeriodoAcademico[] periodos;

    public Carrera(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Carrera(String id, String nombre, Seccion[] secciones, PeriodoAcademico[] periodos) {
        this.id = id;
        this.nombre = nombre;
        this.secciones = secciones;
        this.periodos = periodos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public PeriodoAcademico[] getPeriodos() {
        return periodos;
    }

    public void setPeriodos(PeriodoAcademico[] periodos) {
        this.periodos = periodos;
    }

    
}
