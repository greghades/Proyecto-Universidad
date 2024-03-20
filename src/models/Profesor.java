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
import java.util.List;

public class Profesor extends Persona {

    private String especialidad;
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Profesor(String cedula, String nombre, String especialidad) {
        super(cedula, nombre);
        this.especialidad = especialidad;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
