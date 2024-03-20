/*
 Ernesto Contreras
28245373

Albani barragán
28268078

Luis Carrillo
27539960

Gregori Yepez 
28047103

Yaslin Vreugdenhil.
29561929
 */

package models;

public class CincoColumnasModel {
    
    private String cedula;
    private String nombre;
    private String genero;
    private String decanato;
    private String carrera;

    public CincoColumnasModel(String cedula, String nombre, String genero, String decanato, String carrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.decanato = decanato;
        this.carrera = carrera;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDecanato() {
        return decanato;
    }

    public void setDecanato(String decanato) {
        this.decanato = decanato;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
