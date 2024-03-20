/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class CuatroColumnasModel {
    
    private String cedula;
    private String nombre;
    private String extra;
    private String promedio;

    public CuatroColumnasModel(String cedula, String nombre, String extra, String promedio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.extra = extra;
        this.promedio = promedio;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    
    
}
