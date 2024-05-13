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
public class Decanato implements ComponenteUniversitario {

    private String id;
    private String nombre;
    private String nombre_universidad;
    private Universidad id_universidad;
    private String direccion;
    private List<ComponenteUniversitario> componentes;
    public ConexionSQL connection = ConexionSQL.getInstance();

    public Decanato(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public Decanato(String id, String nombre, Universidad id_universidad, String direccion) {
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

    public void setId_universidad(Universidad id_universidad) {
        this.id_universidad = id_universidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public Universidad getId_universidad() {
        return id_universidad;
    }

    public List<ComponenteUniversitario> obtenerComponentes() {
        return componentes;
    }

    @Override
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

    public Estudiante[] listarMejoresEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[0];
        return estudiantes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cargarCarrerasDesdeBD(Decanato decanato) {
        // Realizar la consulta a la base de datos para obtener las carreras asociadas al decanato
        List<ListadoCarreraModel> carreras = connection.obtenerCarrerasPorDecanato(decanato);

        // Agregar las carreras al decanato
        for (ListadoCarreraModel carrera : carreras) {
            agregarComponente(carrera);
        }

        // Mostrar mensaje de éxito o error
        if (!carreras.isEmpty()) {
            System.out.println("Se han cargado " + carreras.size() + " carreras asociadas al decanato desde la base de datos.");
        } else {
            System.out.println("No se encontraron carreras asociadas al decanato en la base de datos.");
        }
        for (ComponenteUniversitario componente : componentes) {
            System.out.println("- " + componente.getModalidad());
            System.out.println("- " + componente.getDuracion());
        }
    }

    public void mostrarComponentes() {
        System.out.println("Componentes del decanato " + nombre + ":");
        for (ComponenteUniversitario componente : componentes) {
            System.out.println("- " + componente.getNombre());
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
}
