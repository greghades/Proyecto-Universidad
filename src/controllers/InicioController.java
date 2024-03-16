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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.InicioFrame;

public class InicioController implements ActionListener {

    private static InicioController instance; // Singleton instance
    public InicioFrame inicioFrame;
    public InscripcionController inscripcionController;

    public InicioController() {
        inicioFrame = new InicioFrame(this); // Create InicioFrame with reference to this controller
        inicioFrame.setVisible(true);
    }

    public static InicioController getInstance() {
        if (instance == null) {
            instance = new InicioController();
        }

//    System.out.println("InicioController getInstance");
        return instance;
    }

    public void showInicioFrame() {
        inicioFrame.setVisible(true); // Show InscripcionFrame
    }

    private void showInscripcionFrame() {
        inicioFrame.setVisible(false); // Hide InicioFrame
        inscripcionController.showInscripcionFrame(); // Delegate to InscripcionController
    }

    public void setInscripcionController(InscripcionController inscripcionController) {
        this.inscripcionController = inscripcionController; // Set reference
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        showInscripcionFrame();
    }
}
