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
import java.io.Serializable;

public class InscripcionInfo implements Serializable{
    private Estudiante estudiante;
    private ArrayList<Asignatura> asignaturas;

    public InscripcionInfo(Estudiante estudiante, ArrayList<Asignatura> asignaturas) {
        this.estudiante = estudiante;
        this.asignaturas = asignaturas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    
    public void setAsignatura(int index, Asignatura value) {
        this.asignaturas.set(index, value);
    }
    
    public boolean hasAllInfo() {
        return estudiante != null && asignaturas != null && !asignaturas.isEmpty();
    }
}
