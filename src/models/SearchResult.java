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
import java.util.ArrayList;

public class SearchResult {
    private Estudiante estudiante;
    private ArrayList<Asignatura> asignaturas;

    public SearchResult(Estudiante estudiante, ArrayList<Asignatura> asignaturas) {
        this.estudiante = estudiante;
        this.asignaturas = asignaturas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    
    public boolean hasAllInfo() {
        return estudiante != null && asignaturas != null && !asignaturas.isEmpty();
    }
}
