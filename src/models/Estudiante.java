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

//import java.util.Arrays;

/**
 *
 * @author 58412
 */
public class Estudiante extends Persona {
    private String idCarrera;

    public Estudiante(String idCarrera, String cedula, String nombre, String apellido, String correo, int edad, String sexo) {
        super(cedula, nombre, apellido, correo, edad, sexo);
        this.idCarrera = idCarrera;
    }
    
    
    
//    public void retirarMateria(Asignatura asignatura){
//        
//        // Iterar sobre el arreglo de asignaturas del estudiante
//        for (int i = 0; i < asignaturas.length; i++) {
//            // Verificar si la asignatura actual coincide con la asignatura que se desea retirar
//            if (asignaturas[i].equals(asignatura)) {
//                // Si coincide, eliminar la asignatura del arreglo
//                // Esto lo puedes hacer moviendo todos los elementos posteriores una posición hacia adelante
//                for (int j = i; j < asignaturas.length - 1; j++) {
//                    asignaturas[j] = asignaturas[j + 1];
//                }
//                // Reducir el tamaño del arreglo en 1
//                asignaturas = Arrays.copyOf(asignaturas, asignaturas.length - 1);
//
//                // Salir del bucle una vez que se ha encontrado y retirado la asignatura
//                break;
//            }
//        }  
//    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }
}
