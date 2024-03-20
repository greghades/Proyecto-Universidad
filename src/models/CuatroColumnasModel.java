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
