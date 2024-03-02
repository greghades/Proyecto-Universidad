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
public class Asignatura {
    private int id;
    private float nota;
    private boolean esRetirada;
   
    private PeriodoAcademico periodoAcademico;
    private Profesor profesor;

    public Asignatura(int id, float nota, boolean esRetirada,  PeriodoAcademico periodoAcademico, Profesor profesor) {
        this.id = id;
        this.nota = nota;
        this.esRetirada = esRetirada;
        
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
