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


public class Profesor extends Persona {
    
    private  Asignatura[] asignaturas;
    private  ArrayList<Seccion> secciones;

    public Profesor(String cedula, String nombre, String apellido, String correo, int edad, String sexo) {
        super(cedula, nombre, apellido, correo, edad, sexo);
    }
    
    public Profesor(ArrayList<Seccion> secciones, String cedula, String nombre) {
        super(cedula, nombre);
        this.secciones = secciones;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }


    public void calificarEstudiante(float nota, Estudiante estudiante){
        
    
    }
    public void listarPromedios(Seccion[] secciones){
        
        
    
    }
}
