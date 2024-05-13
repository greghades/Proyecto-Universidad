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
public class ListadoDecanatoModel implements ComponenteUniversitario {

    private String id_decanato;
    private String nombre_decanato;
    private String direccion;
    private List<ComponenteUniversitario> componentes;

    public ListadoDecanatoModel(String id_decanato, String nombre_decanato, String direccion) {
        this.id_decanato = id_decanato;
        this.nombre_decanato = nombre_decanato;
        this.direccion = direccion;
        this.componentes = new ArrayList<>();
    }

    public String getId_decanato() {
        return id_decanato;
    }

    public void setId_decanato(String id_decanato) {
        this.id_decanato = id_decanato;
    }

    public String getNombre_decanato() {
        return nombre_decanato;
    }

    public void setNombre_decanato(String nombre_decanato) {
        this.nombre_decanato = nombre_decanato;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public List<ComponenteUniversitario> obtenerComponentes() {
        return componentes;
    }

    @Override
    public String getId() {
        return id_decanato;
    }

    @Override
    public String getNombre() {
        return nombre_decanato;
    }

    @Override
    public String getModalidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getDuracion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
