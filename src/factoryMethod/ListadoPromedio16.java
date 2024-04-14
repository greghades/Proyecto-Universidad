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
public class ListadoPromedio16 implements DataFetcher {
    @Override
    public ArrayList obtenerDatos() {
        ArrayList<TresColumnasModel> datasource16promedios = connection.getEstudiantesTres("16 promedios");
        return datasource16promedios;
    }
}
