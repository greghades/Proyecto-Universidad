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
    
    private final int id;
    private final String nombre;
    private final String direccion;
    private final Decanato[] decanatos;
    private Inscripcion[] inscripcion;

    public Universidad(int id, String nombre, String direccion, Decanato[] decanatos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.decanatos = decanatos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Decanato[] getDecanatos() {
        return decanatos;
    }

    public Inscripcion[] getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion[] inscripcion) {
        this.inscripcion = inscripcion;
    }
}
