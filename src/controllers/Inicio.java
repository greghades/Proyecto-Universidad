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

import static controllers.Inscripcion.inscripcionJF;
import javax.swing.JFrame;
import sql.ConexionSQL;
import views.JFrame_Inicio;
import views.JFrame_Inscripcion;

/**
 *
 * @author User
 */
public class Inicio {
    
    public static JFrame_Inicio inicioJF;
    
    public static void main(String[] args) {
        // Perform any pre-initialization tasks here (optional)

        ConexionSQL conn = new ConexionSQL();
        conn.conectar();
        inicioJF = new JFrame_Inicio();
        inicioJF.setVisible(true);
      }

    public void openInscripcionFrame() {
        if (inscripcionJF == null) {
            inscripcionJF = new JFrame_Inscripcion();
        }
        inicioJF.setVisible(false);
        inscripcionJF.setVisible(true);
    }
}
