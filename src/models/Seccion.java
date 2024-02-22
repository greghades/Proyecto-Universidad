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
 * @author 58412
 */
public class Seccion {
    private int id;
    private int cupo;
    private Estudiante estudiante;
    private Profesor profesor;

    public Seccion(int id, int cupo, Estudiante estudiante, Profesor profesor) {
        this.id = id;
        this.cupo = cupo;
        this.estudiante = estudiante;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public Estudiante listarEstudiantesPromedio(){
        
        return this.estudiante;
    }
}
