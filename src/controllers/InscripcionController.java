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
import views.InscripcionFrame;

public class InscripcionController {
    
    private static InscripcionController instance; // Singleton instance
    public ConexionSQL connection;
    public InscripcionFrame inscripcionFrame;
    public InicioController inicioController; // Reference to InicioController

  private InscripcionController() {
    inscripcionFrame = new InscripcionFrame(this);
    inscripcionFrame.setVisible(false); // Initially hide InscripcionFrame
  }

  public static InscripcionController getInstance() {
    if (instance == null) {
      instance = new InscripcionController();
    }
    return instance;
  }

  public void showInscripcionFrame() {
    inscripcionFrame.setVisible(true); // Show InscripcionFrame
  }

  public void showInicioFrame() {
    inscripcionFrame.setVisible(false); // Hide InscripcionFrame
    inicioController.showInicioFrame(); // Delegate to InicioController
  }

  public void setInicioController(InicioController inicioController) {
    this.inicioController = inicioController; // Set reference
  }
  
  public void setConnection(ConexionSQL conexion) {
    this.connection = conexion; // Set reference
  }
}
