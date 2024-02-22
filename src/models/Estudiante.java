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
    private Seccion[] secciones;
    private PeriodoAcademico periodoAcademico; 

    public Estudiante(Asignatura[] asignaturas, Seccion[] secciones, PeriodoAcademico periodoAcademico, int cedula, String nombre, String apellido, String correo) {
        super(cedula, nombre, apellido, correo);
        this.asignaturas = asignaturas;
        this.secciones = secciones;
        this.periodoAcademico = periodoAcademico;
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

  
    
    public void retirarMateria(Asignatura[] asignatura){
        
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
