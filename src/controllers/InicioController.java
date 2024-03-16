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
import util.PantallaCompleta;
import views.InicioFrame;

public class InicioController implements ActionListener {

    private static InicioController instance;
    public InicioFrame inicioFrame;
    public InscripcionController inscripcionController;

    public InicioController() {
        inicioFrame = new InicioFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(inicioFrame);
        inicioFrame.setVisible(true);
    }

    public static InicioController getInstance() {
        if (instance == null) {
            instance = new InicioController();
        }
        return instance;
    }

    public void showInicioFrame() {
        inicioFrame.setVisible(true);

    }

    private void showInscripcionFrame() {
        inicioFrame.setVisible(false);
        inscripcionController.showInscripcionFrame();
    }

    public void setInscripcionController(InscripcionController inscripcionController) {
        this.inscripcionController = inscripcionController;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        showInscripcionFrame();
    }
}
