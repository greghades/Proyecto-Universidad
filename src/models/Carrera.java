/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Carrera {
    
    private final int id;
    private final String nombre;
    private final Seccion[] secciones;
    private final PeriodoAcademico[] periodos;

    public Carrera(int id, String nombre, Seccion[] secciones, PeriodoAcademico[] periodos) {
        this.id = id;
        this.nombre = nombre;
        this.secciones = secciones;
        this.periodos = periodos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public PeriodoAcademico[] getPeriodos() {
        return periodos;
    }
    
    /*public Estudiante[] listarMejoresEstudiantes() {
        
    }
    
    public Estudiante[] listarEstudiantesPromedio() {
        
    }*/
    
}
