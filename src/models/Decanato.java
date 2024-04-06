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
public class Decanato implements Serializable {
    private final int id;
    private final String nombre;
    private final Carrera[] carreras;

    public Decanato(int id, String nombre, Carrera[] carreras) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }
    
    public  Estudiante[] listarMejoresEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[0];
        return estudiantes;
    }
}
