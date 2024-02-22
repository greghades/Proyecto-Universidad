/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Inscripcion {
    
    private final PeriodoAcademico periodo;
    private final Asignatura[] asignaturas;
    private final Seccion seccion;

    public Inscripcion(PeriodoAcademico periodo, Asignatura[] asignaturas, Seccion seccion) {
        this.periodo = periodo;
        this.asignaturas = asignaturas;
        this.seccion = seccion;
    }

    public PeriodoAcademico getPeriodo() {
        return periodo;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public Seccion getSeccion() {
        return seccion;
    }
    
}
