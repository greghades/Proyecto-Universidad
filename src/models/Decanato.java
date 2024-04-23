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
    private List<ComponenteUniversitario> componentes;

    public Decanato(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

     public void agregarComponente(ComponenteUniversitario componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(ComponenteUniversitario componente) {
        componentes.remove(componente);
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



