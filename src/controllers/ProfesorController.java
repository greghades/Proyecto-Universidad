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
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.ProfesorFrame;

/**
 *
 * @author Usuario
 */
public class ProfesorController implements ActionListener {

    public Profesor profesor;
    private static ProfesorController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public ProfesorFrame profesorFrame;
    public InicioController inicioController;
    public GestionarProfesorController gestionarProfesorController;

    public ProfesorController() {
        profesorFrame = new ProfesorFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(profesorFrame);
        profesorFrame.setVisible(false);
    }

    public static ProfesorController getInstance() {
        if (instance == null) {
            instance = new ProfesorController();
        }
        return instance;
    }

    public void showProfesorFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(profesorFrame);
        profesorFrame.setVisible(true);
    }

    private void showInicioFrame() {
        profesorFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void showGestionarProfesorFrame() {
        profesorFrame.setVisible(false);
        gestionarProfesorController.showGestionarProfesorFrame(profesor);
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void setGestionarProfesorController(GestionarProfesorController gestionarProfesorController) {
        this.gestionarProfesorController = gestionarProfesorController;
    }

    //mostrar datos del profesor de la base de datos
    public void buscarProfesor() {
        if ("Cedula".equals(profesorFrame.getCedula()) || profesorFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.profesor = connection.motrarDatosProfesor(profesorFrame.getCedula());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            profesorFrame.rellenarInfoInicial(profesor);
            profesorFrame.mostrarEstadoProfesorInfo();
        }
    }

    //eliminar 
    public void eliminarProfesor() {
        if ("Cedula".equals(profesorFrame.getCedula()) || profesorFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.eliminarProfesor(profesorFrame.getCedula());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El profesor fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            profesorFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == profesorFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == profesorFrame.getCedula_profesor_btn()) {
            buscarProfesor();
        } else if (event.getSource() == profesorFrame.getReestablecer_prof_Btn()) {
            profesorFrame.mostrarEstadoInicial();
        } else if (event.getSource() == profesorFrame.getEliminar_prof_btn()) {
            eliminarProfesor();
        } else if (event.getSource() == profesorFrame.getModificar_prof_btn()) {
            gestionarProfesorController.esAgregar = false;
            showGestionarProfesorFrame();
        } else if (event.getSource() == profesorFrame.getRegistrar_prof_btn()) {
            gestionarProfesorController.esAgregar = true;
            showGestionarProfesorFrame();
        } else if (event.getSource() == profesorFrame.getBuscar_prof_btn()) {
            profesorFrame.mostrarEstadoBuscar();
        }
    }
}
