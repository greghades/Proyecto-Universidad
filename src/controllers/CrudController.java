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
import models.Universidad;
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
    public Universidad universidad;
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
        gestionarCrudController.showGestionarFrame();
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

        this.profesor = connection.obtenerProfesor(crudFrame.getCedula());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            crudFrame.rellenarInfoProfesor(profesor);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    public void buscarEstudiante() {
        System.out.println("cedula" + crudFrame.getCedula());
        if ("Cedula".equals(crudFrame.getCedula()) || crudFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.estudiante = connection.obtenerEstudiante(crudFrame.getCedula());

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("estudiante buscar" + estudiante);
            crudFrame.rellenarInfoEstudiante(estudiante);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    //eliminar 
    public void eliminarProfesor() {
        int rowsAffected = connection.eliminarProfesor(crudFrame.getCedula());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El profesor fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarEstudiante() {
        int rowsAffected = connection.eliminarEstudiante(crudFrame.getCedula());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El estudiante fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarUniversidad() {
        if ("Cedula".equals(crudFrame.getCedula()) || crudFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar un id de universidad.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.universidad = connection.getUniversidad(crudFrame.getCedula());

        if (universidad == null) {
            JOptionPane.showMessageDialog(null, "No existe ninguna universidad con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            crudFrame.rellenarInfoUniversidad(universidad);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    //eliminar 
    public void eliminarUniversidad() {
        if ("Cedula".equals(crudFrame.getCedula()) || crudFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Id de universidad", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.eliminarUniversidad(crudFrame.getCedula());

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
                buscarEstudiante();
            }
            case "universidad" -> {
                buscarUniversidad();
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
                eliminarEstudiante();
            }
            case "universidad" -> {
                eliminarUniversidad();
            }
            default ->
                throw new AssertionError();
        }
    }

    // Crear metodos de crear y eliminar estudiante.
    @Override
    public void actionPerformed(ActionEvent event
    ) {
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
