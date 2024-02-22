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

    public Profesor(Asignatura[] asignaturas, Seccion[] secciones, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
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

    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void calificarEstudiante(float nota, Estudiante estudiante){
        
    
    }
    public void listarPromedios(Seccion[] secciones){
        
        
    
    }
}
