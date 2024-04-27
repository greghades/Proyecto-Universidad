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

import java.util.List;
import compose.ComponenteUniversitario;
/**
 *
 * @author User
 */
public class Carrera implements ComponenteUniversitario{
    
    private String id;
    private String nombre;
    private Decanato decanato;
    private String id_decanato;
   private String modalidad;
   private int duracion;
//    private Seccion[] secciones;
//    private PeriodoAcademico[] periodos;
    
    public Carrera(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public Carrera(String id, Decanato decanato, String nombre, String modalidad, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.duracion = duracion;
        this.decanato = decanato;

    }
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    

    public Decanato getDecanato() {
        return decanato;
    }

    public void setDecanato(Decanato decanato) {
        this.decanato = decanato;
    }

    public String getId_decanato() {
        return id_decanato;
    }

    public void setId_decanato(String id_decanato) {
        this.id_decanato = id_decanato;
    }
    

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
