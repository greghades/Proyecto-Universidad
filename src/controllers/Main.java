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

package controllers;

import sql.ConexionSQL;

public class Main {
    
     public static void main(String[] args) {
    InicioController inicioController = InicioController.getInstance();
    InscripcionController inscripcionController = InscripcionController.getInstance();
    
    ConexionSQL connection = new ConexionSQL();
    inicioController.setInscripcionController(inscripcionController);
    inscripcionController.setInicioController(inicioController);// Establish references between controllers
    inscripcionController.setConnection(connection);
  }
}
