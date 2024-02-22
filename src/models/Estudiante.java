/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Arrays;

/**
 *
 * @author 58412
 */
public class Estudiante extends Persona {

    private Asignatura[] asignaturas;
    private final Seccion[] secciones;
    private final PeriodoAcademico periodo; 

    public Estudiante(Asignatura[] asignaturas, Seccion[] secciones, PeriodoAcademico periodo, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
        this.periodo = periodo;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public PeriodoAcademico getPeriodo() {
        return periodo;
    }

    public void retirarMateria(Asignatura asignatura){
        
        // Iterar sobre el arreglo de asignaturas del estudiante
        for (int i = 0; i < asignaturas.length; i++) {
            // Verificar si la asignatura actual coincide con la asignatura que se desea retirar
            if (asignaturas[i].equals(asignatura)) {
                // Si coincide, eliminar la asignatura del arreglo
                // Esto lo puedes hacer moviendo todos los elementos posteriores una posición hacia adelante
                for (int j = i; j < asignaturas.length - 1; j++) {
                    asignaturas[j] = asignaturas[j + 1];
                }
                // Reducir el tamaño del arreglo en 1
                asignaturas = Arrays.copyOf(asignaturas, asignaturas.length - 1);

                // Salir del bucle una vez que se ha encontrado y retirado la asignatura
                break;
            }
        }  
    }
    
    public void inscribirMateria(Inscripcion inscripcion){
    }
}
