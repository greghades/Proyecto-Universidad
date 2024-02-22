/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Universidad {
    
    private final int id;
    private final String name;
    private final String direccion;
    private final Decanato[] decanatos;
    private Inscripcion[] inscripcion;

    public Universidad(int id, String name, String direccion, Decanato[] decanatos) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.decanatos = decanatos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDireccion() {
        return direccion;
    }

    public Decanato[] getDecanatos() {
        return decanatos;
    }

    public Inscripcion[] getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion[] inscripcion) {
        this.inscripcion = inscripcion;
    }
    
}
