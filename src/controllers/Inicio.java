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
import views.JFrame_Inscripcion;

/**
 *
 * @author User
 */
public class Inicio {
    
public static void main(String[] args) {
    // Perform any pre-initialization tasks here (optional)
     
    ConexionSQL conn = new ConexionSQL();
    conn.conectar();
    JFrame_Inscripcion frame = new JFrame_Inscripcion();
    frame.setVisible(true);
  }
}
