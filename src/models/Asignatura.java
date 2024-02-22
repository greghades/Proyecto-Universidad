/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 58412
 */
public class Asignatura {
    private int id;
    private float nota;
    private boolean esRetirada;
    private Seccion[] secciones;
    private PeriodoAcademico periodoAcademico;
    private Profesor profesor;

    public Asignatura(int id, float nota, boolean esRetirada, Seccion[] secciones, PeriodoAcademico periodoAcademico, Profesor profesor) {
        this.id = id;
        this.nota = nota;
        this.esRetirada = esRetirada;
        this.secciones = secciones;
        this.periodoAcademico = periodoAcademico;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isEsRetirada() {
        return esRetirada;
    }

    public void setEsRetirada(boolean esRetirada) {
        this.esRetirada = esRetirada;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public PeriodoAcademico getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    
}
