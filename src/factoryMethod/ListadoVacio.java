/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethod;

import java.util.ArrayList;
import sql.ConexionSQL;

/**
 *
 * @author User
 */
public class ListadoVacio implements DataFetcher {

    @Override
    public ArrayList obtenerDatos(ConexionSQL connection) {
        return new ArrayList();
    }
    
}
