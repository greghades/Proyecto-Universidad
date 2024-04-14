/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethod;

import java.util.ArrayList;
import models.TresColumnasModel;

/**
 *
 * @author User
 */
public class ListadoCarrera implements DataFetcher {
    @Override
    public ArrayList obtenerDatos() {
        ArrayList<TresColumnasModel> datasourceCarrera = connection.getEstudiantesTres("carrera");
        return datasourceCarrera;
    }
}
