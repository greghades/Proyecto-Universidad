/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factoryMethod;

import java.util.ArrayList;
import sql.ConexionSQL;

/**
 *
 * @author User
 */
public interface DataFetcher {    
    public ArrayList obtenerDatos(ConexionSQL conexionSQL);
}
