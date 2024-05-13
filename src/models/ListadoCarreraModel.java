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

import compose.ComponenteUniversitario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 58412
 */
public class ListadoCarreraModel implements ComponenteUniversitario{
    private String id;
    private String nombre;
    private String modalidad;
    private int duracion;
    private List<ComponenteUniversitario> componentes;

    public ListadoCarreraModel(String id, String nombre, String modalidad, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.duracion = duracion;
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

    public List<ComponenteUniversitario> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<ComponenteUniversitario> componentes) {
        this.componentes = componentes;
    }

    

    public void agregarComponente(ComponenteUniversitario componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(ComponenteUniversitario componente) {
        componentes.remove(componente);
    }
    public void limpiarComponentes() {
        this.componentes.clear();
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  

   

 
    
    
}
