/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 58412
 */
public class ListadoSeccionModel {
    private String seccion;
    private String asignatura;
    private String docente;
    private String carrera;
    private String decanato;
    private float promedio_seccion;
    private int numero_aprobados;
    private int numero_aplazados;
    private String[] estudiantesPorEncimaPromedio;
    private String[] estudiantesPorDebajoPromedio;

    public ListadoSeccionModel(String seccion, String asignatura, String docente, String carrera, String decanato, float promedio_seccion, int numero_aprobados, int numero_aplazados, String[] estudiantesPorEncimaPromedio, String[] estudiantesPorDebajoPromedio) {
        this.seccion = seccion;
        this.asignatura = asignatura;
        this.docente = docente;
        this.carrera = carrera;
        this.decanato = decanato;
        this.promedio_seccion = promedio_seccion;
        this.numero_aprobados = numero_aprobados;
        this.numero_aplazados = numero_aplazados;
        this.estudiantesPorEncimaPromedio = estudiantesPorEncimaPromedio;
        this.estudiantesPorDebajoPromedio = estudiantesPorDebajoPromedio;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDecanato() {
        return decanato;
    }

    public void setDecanato(String decanato) {
        this.decanato = decanato;
    }

    public float getPromedio_seccion() {
        return promedio_seccion;
    }

    public void setPromedio_seccion(float promedio_seccion) {
        this.promedio_seccion = promedio_seccion;
    }

    public int getNumero_aprobados() {
        return numero_aprobados;
    }

    public void setNumero_aprobados(int numero_aprobados) {
        this.numero_aprobados = numero_aprobados;
    }

    public int getNumero_aplazados() {
        return numero_aplazados;
    }

    public void setNumero_aplazados(int numero_aplazados) {
        this.numero_aplazados = numero_aplazados;
    }

    public String[] getEstudiantesPorEncimaPromedio() {
        return estudiantesPorEncimaPromedio;
    }

    public void setEstudiantesPorEncimaPromedio(String[] estudiantesPorEncimaPromedio) {
        this.estudiantesPorEncimaPromedio = estudiantesPorEncimaPromedio;
    }

    public String[] getEstudiantesPorDebajoPromedio() {
        return estudiantesPorDebajoPromedio;
    }

    public void setEstudiantesPorDebajoPromedio(String[] estudiantesPorDebajoPromedio) {
        this.estudiantesPorDebajoPromedio = estudiantesPorDebajoPromedio;
    }

    
    
}
