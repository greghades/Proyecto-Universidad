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
import models.Carrera;
import models.Estudiante;
import models.Profesor;
import models.Universidad;
import models.Decanato;
import observer.Observer;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.CrudFrame;

/**
 *
 * @author Usuario
 */
public class CrudController implements ActionListener, Observer {

    public Profesor profesor;
    public Estudiante estudiante;
    public Universidad universidad;
    public Carrera carrera;
    public Decanato decanato;
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
        this.gestionarCrudController.addObserver(this);
    }

    //mostrar datos del profesor de la base de datos
    public void buscarProfesor() {
        if ("ID".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.profesor = connection.obtenerProfesor(crudFrame.getID());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            crudFrame.rellenarInfoProfesor(profesor);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    public void buscarEstudiante() {
        System.out.println("cedula" + crudFrame.getID());
        if ("ID".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.estudiante = connection.obtenerEstudiante(crudFrame.getID());

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("estudiante buscar" + estudiante);
            crudFrame.rellenarInfoEstudiante(estudiante);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    public void buscarUniversidad() {
        if ("ID".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar un id de universidad.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.universidad = connection.obtenerUniversidad(crudFrame.getID());

        if (universidad == null) {
            JOptionPane.showMessageDialog(null, "No existe ninguna universidad con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            crudFrame.rellenarInfoUniversidad(universidad);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    public void buscarCarrera() {
        if ("ID".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "debes ingresar un id de carrera.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.carrera = connection.obtenerCarrera(crudFrame.getID());

        if (carrera == null) {
            JOptionPane.showMessageDialog(null, "No existe ninguna carrera con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("carrera buscar" + carrera.getModalidad() + " carrera " + carrera.getNombre());
            crudFrame.rellenarInfoCarrera(carrera);
            crudFrame.mostrarEstadoInformacion();
        }
    }

    public void buscarDecanato() {
        if ("ID".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un ID de Decanato valido.", " Ten cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.decanato = connection.obtenerDecanato(crudFrame.getID());

        if (decanato == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun decanato con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("decanato buscar" + decanato.getNombre_universidad()+ " decanato" + decanato.getNombre());
            crudFrame.rellenarInfoDecanato(decanato);
            crudFrame.mostrarEstadoInformacion();
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
            case "carrera" -> {
                buscarCarrera();
            }
            case "decanato" -> {
                buscarDecanato();
            }
            default ->
                throw new AssertionError();
        }
    }

    //eliminar 
    public void eliminarProfesor() {
        int rowsAffected = connection.eliminarProfesor(crudFrame.getID());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El profesor fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarEstudiante() {
        int rowsAffected = connection.eliminarEstudiante(crudFrame.getID());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "El estudiante fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    //eliminar 
    public void eliminarUniversidad() {
        if ("Cedula".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Id de universidad", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.eliminarUniversidad(crudFrame.getID());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "La universidad fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCarrera() {
        if ("Cedula".equals(crudFrame.getID()) || crudFrame.getID().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Id de carrera", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.eliminarCarrera(crudFrame.getID());

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "La carrera fue eliminado exitosamente de la base de datos", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            crudFrame.mostrarEstadoInicial();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
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
            case "carrera" -> {
                eliminarCarrera();
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

    @Override
    public void update() {
        switch (tipoCrud) {
            case "universidad" -> {
                crudFrame.rellenarInfoUniversidad(universidad);
            }
            case "carrera" -> {
                crudFrame.rellenarInfoCarrera(carrera);
            }
            case "profesor" -> {
                crudFrame.rellenarInfoProfesor(profesor);
            }
            case "estudiante" -> {
                crudFrame.rellenarInfoEstudiante(estudiante);
            }
        }
        crudFrame.mostrarEstadoInformacion();
    }
}
