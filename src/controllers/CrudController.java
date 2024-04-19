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
import models.Estudiante;
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.CrudFrame;

/**
 *
 * @author Usuario
 */
public class CrudController implements ActionListener {

    public Profesor profesor;
    public Estudiante estudiante;
    public String tipoCrud;
    private static CrudController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public CrudFrame crudFrame;
    public InicioController inicioController;
    public GestionarCrudController gestionarCrudController;

    public CrudController() {
        crudFrame = new CrudFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(crudFrame);
        crudFrame.setVisible(false);
    }

    public static CrudController getInstance() {
        if (instance == null) {
            instance = new CrudController();
        }
        return instance;
    }

    public void showCrudFrame() {
        crudFrame.setVisible(true);
    }

    private void showInicioFrame() {
        crudFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void showGestionarCrudFrame(boolean esAgregar) {
        gestionarCrudController.esAgregar = esAgregar;
        gestionarCrudController.tipoCrud = tipoCrud;
        crudFrame.setVisible(false);
        
        switch (tipoCrud) {
            case "profesor" ->
                gestionarCrudController.showGestionarProfesorFrame(profesor);
            case "estudiante" -> {
//                Crear un metodo en gestionarCrud que sea showGestionarEstudianteFrame y reciba al estudiante como parametro
            }
            default ->
                throw new AssertionError();
        }
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void setGestionarCrudController(GestionarCrudController gestionarCrudController) {
        this.gestionarCrudController = gestionarCrudController;
    }

    //mostrar datos del profesor de la base de datos
    public void buscarProfesor() {
        if ("Cedula".equals(crudFrame.getCedula()) || crudFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.profesor = connection.motrarDatosProfesor(crudFrame.getCedula());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            crudFrame.rellenarInfoProfesor(profesor);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    //eliminar 
    public void eliminarProfesor() {
        if ("Cedula".equals(crudFrame.getCedula()) || crudFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.eliminarProfesor(crudFrame.getCedula());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El profesor fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void manejarBusqueda() {
        switch (tipoCrud) {
            case "profesor" ->
                buscarProfesor();
            case "estudiante" -> {
//            Crear metodo buscarEstudiante();
            }
            default ->
                throw new AssertionError();
        }
    }

    private void manejarEliminacion() {
        switch (tipoCrud) {
            case "profesor" ->
                eliminarProfesor();
            case "estudiante" -> {
//            Crear metodo eliminarEstudiante();
            }
            default ->
                throw new AssertionError();
        }
    }

    // Crear metodos de crear y eliminar estudiante.
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == crudFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == crudFrame.getBuscar_id_btn()) {
            manejarBusqueda();
        } else if (event.getSource() == crudFrame.getReestablecer_prof_Btn()) {
            crudFrame.mostrarEstadoInicial();
        } else if (event.getSource() == crudFrame.getEliminar_btn()) {
            manejarEliminacion();
        } else if (event.getSource() == crudFrame.getModificar_btn()) {
            showGestionarCrudFrame(false);
        } else if (event.getSource() == crudFrame.getRegistrar_btn()) {
            showGestionarCrudFrame(true);
        } else if (event.getSource() == crudFrame.getBuscar_btn()) {
            crudFrame.mostrarEstadoBuscar();
        }
    }
}
