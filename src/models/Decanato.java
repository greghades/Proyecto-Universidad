/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Decanato {
    private final int id;
    private final String nombre;
    private final Carrera[] carreras;

    public Decanato(int id, String nombre, Carrera[] carreras) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }
    
    public  Estudiante[] listarMejoresEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[0];
        return estudiantes;
    }
}
