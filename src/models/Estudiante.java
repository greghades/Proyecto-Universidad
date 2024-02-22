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
    private final Asignatura[] asignaturas;
    private final Seccion[] secciones;
    private final PeriodoAcademico periodo; 

    public Estudiante(Asignatura[] asignaturas, Seccion[] secciones, PeriodoAcademico periodo, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
        this.periodo = periodo;
    }

  
    
    public void retirarMateria(Asignatura[] asignaturas){
        
    }
    
    public void inscribirMateria(Inscripcion inscripcion){
        
    }
    
}
