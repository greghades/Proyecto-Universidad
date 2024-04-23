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

/**
 *
 * @author User
 */
public class Universidad {
    
    private String id;
    private String nombre;
    private String direccion;

    
  

    public Universidad(String id, String nombre, String direccion/*, Decanato[] decanatos*/) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
   }

    public String getId() {
        return id;
    }

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
  
   
}
