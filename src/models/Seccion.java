/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
