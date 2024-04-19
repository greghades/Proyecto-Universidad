package factoryMethod;

import java.util.ArrayList;
import models.TresColumnasModel;
import sql.ConexionSQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class ListadoSemestre implements DataFetcher {
    @Override
    public ArrayList obtenerDatos(ConexionSQL connection) {
        ArrayList<TresColumnasModel> datasourceSemestre = connection.getEstudiantesTres("semestre");
        return datasourceSemestre;
    }
}
