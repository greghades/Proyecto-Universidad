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
    private final Asignatura asignatura;

    public Carrera(int id, String nombre,Asignatura asignatura){
        this.id = id;
        this.nombre = nombre;
        this.asignatura= asignatura;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

   
    
    /*public Estudiante[] listarMejoresEstudiantes() {
        
    }
    
    public Estudiante[] listarEstudiantesPromedio() {
        
    }*/
    
}
