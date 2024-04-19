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

import com.sun.jdi.request.ClassPrepareRequest;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    private Carrera carrera;
    private String id_carrera;

    public Estudiante(Carrera carrera, String cedula, String nombre, String apellido, String correo, int edad, String sexo) {
        super(cedula, nombre, apellido, correo, edad, sexo);
        this.carrera = carrera;
    }

    public Estudiante(String id_carrera, String cedula, String nombre, String apellido, String correo, int edad, String sexo) {
        super(cedula, nombre, apellido, correo, edad, sexo);
        this.id_carrera = id_carrera;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
