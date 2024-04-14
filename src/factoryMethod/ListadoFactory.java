package factoryMethod;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ListadoFactory {
    public static DataFetcher create(String type) {
        switch (type) {
        case "Por carrera" -> {
            return new ListadoCarrera();
            }
            case "Por semestre" -> {
                return new ListadoSemestre();
            }
            case "20 mejores promedios por carrera" -> {
                return new ListadoPromedioCarrera();
            }
            case "Genero de carrera y decanato" -> {
                return new ListadoGenero();
            }
            case "20 mejores promedios por decanato" -> {
                return new ListadoPromedioDecanato();
            } 
            case "Promedios por encima de 16 puntos" -> {
                return new ListadoPromedio16();
            }
            case "Con materia retirada" -> {
                return new ListadoMateriaRetirada();
            }
            case "Seleccione listado" -> {
                return new ListadoVacio();
            }
            default -> throw new IllegalArgumentException("Tipo de estudiante desconocido: " + type);
        }
    }
}
