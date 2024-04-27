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
public class Universidad implements ComponenteUniversitario{
    
    private String id;
    private String nombre;
    private String direccion;

    private List<ComponenteUniversitario> componentes;
    
    public Universidad(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.componentes = new ArrayList<>();
   }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
   
}
