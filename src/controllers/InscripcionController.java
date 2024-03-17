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
import javax.swing.JOptionPane;
import models.SearchResult;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.InscripcionFrame;

public class InscripcionController implements ActionListener {

    private static InscripcionController instance;
    public ConexionSQL connection;
    public InscripcionFrame inscripcionFrame;
    public InicioController inicioController;

    private InscripcionController() {
        inscripcionFrame = new InscripcionFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(inscripcionFrame);
        inscripcionFrame.setVisible(false);
    }

    public static InscripcionController getInstance() {
        if (instance == null) {
            instance = new InscripcionController();
        }
        return instance;
    }

    public void showInscripcionFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(inscripcionFrame);
        inscripcionFrame.setVisible(true);
    }

    private void showInicioFrame() {
        inscripcionFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void setConnection(ConexionSQL conexion) {
        this.connection = conexion;
    }

    private void mostrarDatos() {
        if ("Cedula".equals(inscripcionFrame.getCedula()) || inscripcionFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SearchResult info = connection.obtenerDatosDeInscripcion(inscripcionFrame.getCedula());

        if (info == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con esa cedula", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            inscripcionFrame.setCarrera(info.getEstudiante().getCarrera());
            inscripcionFrame.setCorreo(info.getEstudiante().getCorreo());
            inscripcionFrame.setEdad(String.valueOf(info.getEstudiante().getEdad()));
            inscripcionFrame.setNombre(info.getEstudiante().getNombre());
            inscripcionFrame.setSexo(info.getEstudiante().getSexo());
            inscripcionFrame.setupTable(info.getAsignaturas());
            inscripcionFrame.displayUI(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == inscripcionFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == inscripcionFrame.getCedula_button()) {
            mostrarDatos();
        } else if (button.getSource() == inscripcionFrame.getInscripcion_button()) {
            System.out.println("Inscripcion tap");
        }
    }
}
