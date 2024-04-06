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
import java.io.Serializable;
/**
 *
 * @author User
 */
public class NotaEstudianteListModel implements Serializable {

    private String cedula;
    private String nombre;
    private String correo;
    private String carrera;
    private String seccion;
    private String id_seccion;
    private Float nota;
    private boolean tieneNota;

    public NotaEstudianteListModel(String cedula, String nombre, String correo, String carrera, String seccion, String id_seccion, Float nota) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.carrera = carrera;
        this.seccion = seccion;
        this.id_seccion = id_seccion;
        this.nota = nota;
        this.tieneNota = nota != null && nota != 0;
    }

    public boolean isTieneNota() {
        return tieneNota;
    }

    public void setTieneNota(boolean tieneNota) {
        this.tieneNota = tieneNota;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(String id_seccion) {
        this.id_seccion = id_seccion;
    }

}
