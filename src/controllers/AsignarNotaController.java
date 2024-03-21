/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Asignatura;
import models.NotaEstudianteListModel;
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.AsignarNotaFrame;

public class AsignarNotaController implements ActionListener {

    private static AsignarNotaController instance;
    public AsignarNotaFrame asignarNotaFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    public Profesor profesor;
    private List<NotaEstudianteListModel> estudiantes;

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

    public void notaActualizada(Object value, int row) {
        if (value instanceof Float nota) {
            System.out.println("cedula: " + estudiantes.get(row).getCedula());
            estudiantes.get(row).setNota(nota);
        } else {
            System.out.println("El valor no es un objeto Float.");
        }
    }

    private void manejarCambioDeListado(ActionEvent button) {
        JComboBox<String> comboBox = (JComboBox<String>) button.getSource();
        String tipoSeleccionado = (String) comboBox.getSelectedItem();
        if (tipoSeleccionado.equals("Seleccionar asignatura")) {
            asignarNotaFrame.limpiarTabla();
            return;
        }

        // Buscar el ID de la asignatura seleccionada
        String idAsignaturaSeleccionada = null;
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            if (tipoSeleccionado.equals(asignatura.getNombre())) {
                idAsignaturaSeleccionada = asignatura.getId();
                break; // Terminar la iteración una vez que se encuentra la asignatura
            }
        }

//        System.out.println("tipoSeleccionado: " + tipoSeleccionado + " idAsignatura: " + idAsignaturaSeleccionada + " profesor: " + this.profesor.getCedula());
        // Verificar si se encontró la asignatura seleccionada
        if (idAsignaturaSeleccionada != null) {
            // Llamar al método mostrarTablaEstudiantes con el ID de la asignatura seleccionada
            mostrarTablaEstudiantes(idAsignaturaSeleccionada);
        } else {
            System.out.println("No se encontró la asignatura seleccionada.");
        }
        asignarNotaFrame.getCmb_asignatura().transferFocus();

//        System.out.println("seleccion:" + tipoSeleccionado);
    }

    private void mostrarTablaEstudiantes(String idAsignatura) {
        List<NotaEstudianteListModel> estudiantes = connection.getEstudiantesParaAsignarNota(profesor.getCedula(), idAsignatura);
        this.estudiantes = estudiantes;
        asignarNotaFrame.configurarTablaEstudiantes(estudiantes, idAsignatura);
    }

    private void guardarNotas() {
        System.out.println("notas: " + this.estudiantes);
        if (this.estudiantes == null || this.estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes colocar al menos una nota para poder guardar", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == asignarNotaFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == asignarNotaFrame.getCedula_button()) {
            mostrarDatos();
        } else if (event.getSource() == asignarNotaFrame.getCmb_asignatura()) {
            manejarCambioDeListado(event);
        } else if (event.getSource() == asignarNotaFrame.getSave_button()) {
            guardarNotas();
        }
    }
}
