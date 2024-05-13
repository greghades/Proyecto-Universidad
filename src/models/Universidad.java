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
import sql.ConexionSQL;
/**
 *
 * @author User
 */
public class Universidad implements ComponenteUniversitario{
    
    private String id;
    private String nombre;
    private String direccion;

    private List<ComponenteUniversitario> componentes;
    public ConexionSQL connection = ConexionSQL.getInstance();
    
    public Universidad(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.componentes = new ArrayList<>();
   }
    
    public Universidad(String id) {
        this.id = id;
  
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
   public List<ListadoDecanatoModel> cargarDecanatosDesdeBD(Universidad universidad) {
        // Realizar la consulta a la base de datos para obtener las carreras asociadas al decanato
        List<ListadoDecanatoModel> decanatos = connection.obtenerDecanatosPorUniversidad(universidad);

        // Agregar las carreras al decanato
        for (ListadoDecanatoModel decanato : decanatos) {
            agregarComponente(decanato);
        }

        // Mostrar mensaje de éxito o error
        if (!decanatos.isEmpty()) {
            System.out.println("Se han cargado " + decanatos.size() + " carreras asociadas al decanato desde la base de datos.");
        } else {
            System.out.println("No se encontraron carreras asociadas al decanato en la base de datos.");
        }
        for (ComponenteUniversitario componente : componentes) {
            System.out.println("- " + componente.getDireccion());
            System.out.println("- " + componente.getDireccion());
        }
        return decanatos;
   }
    public void mostrarComponentes() {
        System.out.println("Componentes del decanato " + nombre + ":");
        for (ComponenteUniversitario componente : componentes) {
            System.out.println("- " + componente.getDireccion());
        }
    }
    public void limpiarComponentes() {
        this.componentes.clear();
    }

    @Override
    public String getModalidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getDuracion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public List<ComponenteUniversitario> obtenerComponentes() {
        return componentes;
    }
}
