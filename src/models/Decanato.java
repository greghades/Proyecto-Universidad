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
 * @author User
 */
public class Decanato implements ComponenteUniversitario{
    private String id;
    private String nombre;
    private String nombre_universidad;
    private String id_universidad;
    private String direccion;
    private List<ComponenteUniversitario> componentes;

    public Decanato(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }
    
    public Decanato(String id, String nombre, String id_universidad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.id_universidad = id_universidad;
        this.direccion = direccion;
        this.componentes = new ArrayList<>();
    }

     public void agregarComponente(ComponenteUniversitario componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(ComponenteUniversitario componente) {
        componentes.remove(componente);
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    public void setId_universidad(String id_universidad) {
        this.id_universidad = id_universidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public String getId_universidad() {
        return id_universidad;
    }

    public String getDireccion() {
        return direccion;
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public  Estudiante[] listarMejoresEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[0];
        return estudiantes;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}



