/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethod;

import java.util.ArrayList;
import models.CincoColumnasModel;

/**
 *
 * @author User
 */
public class ListadoGenero implements DataFetcher {
    @Override
    public ArrayList obtenerDatos() {
        ArrayList<CincoColumnasModel> datasourcegenero = connection.getEstudiantesCinco();
        return datasourcegenero;
    }
}
