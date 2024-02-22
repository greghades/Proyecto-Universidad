/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 58412
 */
public class Estudiante extends Persona {
    private Asignatura[] asignaturas;
    private Seccion[] secciones;
    private Periodo PeriodoAcademico; 

    public Estudiante(Asignatura[] asignaturas, Seccion[] secciones, Periodo PeriodoAcademico, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
        this.PeriodoAcademico = PeriodoAcademico;
    }

  
    
    public void retirarMateria(Asignatura[] asignaturas){
        
    }
    
    public void inscribirMateria(Inscripcion inscripcion){
        
    }
    
}
