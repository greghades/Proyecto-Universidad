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


public class Profesor extends Persona {
    
    private  Asignatura[] asignaturas;
    private  Seccion[] secciones;

    public Profesor(Asignatura[] asignaturas, Seccion[] secciones, String cedula, String nombre, String apellido, String correo, int edad, String sexo) {
        super(cedula, nombre, apellido, correo, edad, sexo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public void calificarEstudiante(float nota, Estudiante estudiante){
        
    
    }
    public void listarPromedios(Seccion[] secciones){
        
        
    
    }
}
