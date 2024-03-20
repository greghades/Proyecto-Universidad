/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.AsignarNotaFrame;

/**
 *
 * @author alba
 */
public class AsignarNotaController implements ActionListener {

    private static AsignarNotaController instance;
    public AsignarNotaFrame asignarNotaFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    public Profesor profesor;

    public AsignarNotaController() {
        asignarNotaFrame = new AsignarNotaFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarNotaFrame);
        asignarNotaFrame.setVisible(false);
    }

    public static AsignarNotaController getInstance() {
        if (instance == null) {
            instance = new AsignarNotaController();
        }
        return instance;
    }

    public void showAsignarNotaFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarNotaFrame);
        asignarNotaFrame.setVisible(true);
        asignarNotaFrame.mostrarEstadoInicial();
    }

    private void showInicioFrame() {
        asignarNotaFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void mostrarDatos() {
        if ("Cedula".equals(asignarNotaFrame.getCedula()) || asignarNotaFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.profesor = connection.getDatosProfesor(asignarNotaFrame.getCedula());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese id", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            asignarNotaFrame.rellenarInformacionInicial(profesor);
        }
    }

    private void manejarCambioDeListado(ActionEvent button) {
        JComboBox<String> comboBox = (JComboBox<String>) button.getSource();
        String tipoSeleccionado = (String) comboBox.getSelectedItem();

        asignarNotaFrame.getCmb_asignatura().transferFocus();
        System.out.println("seleccion:" + tipoSeleccionado);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == asignarNotaFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == asignarNotaFrame.getCedula_button()) {
            mostrarDatos();
        } else if (event.getSource() == asignarNotaFrame.getCmb_asignatura()) {
            manejarCambioDeListado(event);
        }
    }
}
