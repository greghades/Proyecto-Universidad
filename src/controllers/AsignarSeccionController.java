/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Asignatura;
import models.Profesor;
import models.Seccion;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.AsignarSeccionFrame;

/**
 *
 * @author User
 */
public class AsignarSeccionController implements ActionListener {

    private static AsignarSeccionController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    public AsignarSeccionFrame asignarSeccionFrame;
    public ArrayList<Profesor> profesoresList = new ArrayList<>();
    public ArrayList<Asignatura> asignaturasList = new ArrayList<>();
    public ArrayList<Seccion> seccionesList = new ArrayList<>();
    private Asignatura asignaturaSeleccionada;
    private Profesor profesorSeleccionado;
    private Seccion seccionSeleccionada;

    public AsignarSeccionController() {
        asignarSeccionFrame = new AsignarSeccionFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarSeccionFrame);
        asignarSeccionFrame.setVisible(false);
    }

    public static AsignarSeccionController getInstance() {
        if (instance == null) {
            instance = new AsignarSeccionController();
        }
        return instance;
    }

    public void showAsignarSeccionFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarSeccionFrame);
        asignarSeccionFrame.setVisible(true);
        asignarSeccionFrame.configurarContenidoPorPaso(0);
        configurarComboBoxes();
    }

    private void showInicioFrame() {
        asignarSeccionFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    private void configurarComboBoxes() {
        configurarProfesores();
        configurarAsignaturas();
    }

    private void configurarAsignaturas() {
        ArrayList<String> opciones = new ArrayList<>();
        List<Asignatura> asignaturas = connection.obtenerAsignaturas();

        opciones.add("Seleccionar");
        for (Asignatura asignatura : asignaturas) {
            asignaturasList.add(asignatura);
            opciones.add(asignatura.getNombre());
        }

        asignarSeccionFrame.setupComboBox(opciones, "asignatura");
    }

    private void configurarSecciones(String nombre) {
        ArrayList<String> opciones = new ArrayList<>();

        Asignatura asignatura = buscarAsignaturaPorNombre(nombre);

        if (asignatura != null) {
            List<Seccion> secciones = connection.obtenerSecciones(asignatura.getId());

            opciones.add("Seleccionar");
            for (Seccion seccion : secciones) {
                seccionesList.add(seccion);
                opciones.add(String.format("Sección %s, ID: %s", seccion.getNumero(), seccion.getId()));
            }
        } else {
            System.out.println("Error: No se encontró la asignatura con el nombre especificado.");
        }
        asignarSeccionFrame.setupComboBox(opciones, "seccion");
    }

    private Asignatura buscarAsignaturaPorNombre(String nombre) {
        for (Asignatura asignatura : asignaturasList) {
            if (asignatura.getNombre().equals(nombre)) {
                return asignatura;
            }
        }
        return null;
    }

    private Profesor buscarProfesorPorNombre(String nombre) {
        for (Profesor profesor : profesoresList) {
            if (profesor.getNombre().equals(nombre)) {
                return profesor;
            }
        }
        return null;
    }

    private Seccion buscarSeccionPorNombre(String nombre) {
        for (Seccion seccion : seccionesList) {
            if (nombre.contains(seccion.getId())) {
                return seccion;
            }
        }
        return null;
    }

    private void configurarProfesores() {
        ArrayList<String> opciones = new ArrayList<>();
        List<Profesor> profesores = connection.obtenerProfesoresSinSeccion();

        opciones.add("Seleccionar");
        for (Profesor profesor : profesores) {
            profesoresList.add(profesor);
            opciones.add(profesor.getNombre());
        }
        asignarSeccionFrame.setupComboBox(opciones, "profesor");
    }

    private void asignarSeccion() {
        int rowsAffected = connection.asignarSeccion(profesorSeleccionado.getCedula(), asignaturaSeleccionada.getId(), seccionSeleccionada.getId());

        if (rowsAffected > 0) {
            showAlert("Felicidades", "La seccion ha sido asignada exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con la asignacion de seccion", false);
        }
    }

    private void showAlert(String title, String message, boolean isSuccess) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.OK_OPTION,
                isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION && isSuccess) {
            inicioController.showInicioFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == asignarSeccionFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == asignarSeccionFrame.getAsignar_btn()) {
            asignarSeccion();
        } else if (event.getSource() == asignarSeccionFrame.getLimpiar_campos_btn()) {
            asignarSeccionFrame.limpiarVista();
        } else if (event.getSource() == asignarSeccionFrame.getProfesor_cmb()) {
            String seleccion = (String) asignarSeccionFrame.getProfesor_cmb().getSelectedItem();

            if ("Seleccionar".equals(seleccion)) {
                return;
            }

            asignarSeccionFrame.configurarContenidoPorPaso(1);
            this.profesorSeleccionado = buscarProfesorPorNombre(seleccion);
        } else if (event.getSource() == asignarSeccionFrame.getAsignatura_cmb()) {
            String seleccion = (String) asignarSeccionFrame.getAsignatura_cmb().getSelectedItem();

            if ("Seleccionar".equals(seleccion)) {
                return;
            }
            asignarSeccionFrame.configurarContenidoPorPaso(2);
            this.asignaturaSeleccionada = buscarAsignaturaPorNombre(seleccion);
            configurarSecciones((String) asignarSeccionFrame.getAsignatura_cmb().getSelectedItem());
        } else if (event.getSource() == asignarSeccionFrame.getSeccion_cmb()) {
            String seleccion = (String) asignarSeccionFrame.getSeccion_cmb().getSelectedItem();

            if ("Seleccionar".equals(seleccion)) {
                return;
            }
            asignarSeccionFrame.configurarContenidoPorPaso(3);
            this.seccionSeleccionada = buscarSeccionPorNombre(seleccion);
        }
    }
}
