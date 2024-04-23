/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
                opciones.add(String.format("Sección %s", seccion.getNumero()));
            }
        } else {
            // Si no se encontró la asignatura, mostrar un mensaje de error o tomar alguna acción apropiada
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
        return null; // Retorna null si no se encontró la asignatura con el nombre especificado
    }

    private void configurarProfesores() {
        ArrayList<String> opciones = new ArrayList<>();
        List<Profesor> profesores = connection.obtenerProfesores();

        opciones.add("Seleccionar");
        for (Profesor profesor : profesores) {
            profesoresList.add(profesor);
            opciones.add(profesor.getNombre());
        }
        asignarSeccionFrame.setupComboBox(opciones, "profesor");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == asignarSeccionFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == asignarSeccionFrame.getAsignar_btn()) {
            showInicioFrame();
        } else if (event.getSource() == asignarSeccionFrame.getProfesor_cmb()) {
            asignarSeccionFrame.configurarContenidoPorPaso(1);
        } else if (event.getSource() == asignarSeccionFrame.getAsignatura_cmb()) {
            asignarSeccionFrame.configurarContenidoPorPaso(2);
            configurarSecciones((String) asignarSeccionFrame.getAsignatura_cmb().getSelectedItem());
        } else if (event.getSource() == asignarSeccionFrame.getSeccion_cmb()) {
            asignarSeccionFrame.configurarContenidoPorPaso(3);
        }
    }
}
