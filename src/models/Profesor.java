
package models;


public class Profesor extends Persona {
    
    private Asignatura[] asignaturas;
    private Seccion[] secciones;

    public Profesor(Asignatura[] asignaturas, Seccion[] secciones, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
    }
    
}
