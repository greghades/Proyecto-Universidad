/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethod;

import java.util.ArrayList;
import models.CuatroColumnasModel;
import sql.ConexionSQL;

/**
 *
 * @author User
 */
public class ListadoPromedioDecanato implements DataFetcher {
    @Override
    public ArrayList obtenerDatos(ConexionSQL connection) {
        ArrayList<CuatroColumnasModel> datasource20Decanato = connection.getEstudiantesCuatro("20 promedios decanato");
        return datasource20Decanato;
    }
}
