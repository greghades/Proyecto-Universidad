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
    private List<NotaEstudianteListModel> estudiantesActualizables = new ArrayList<>();
    private String asignaturaSeleccionada;

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

        this.profesor = connection.obtenerProfesorPorAsignatura(asignarNotaFrame.getCedula());

        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese id", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            asignarNotaFrame.rellenarInformacionInicial(profesor);
        }
    }

    public void actualizarNota(Object value, int row) {
        if (value instanceof Float nota) {
            NotaEstudianteListModel estudianteActualizado = estudiantes.get(row);
            boolean encontrado = false;

            // Iterar sobre estudiantesActualizables para verificar si el estudiante ya existe
            for (NotaEstudianteListModel estudiante : estudiantesActualizables) {
                if (estudiante.getCedula().equals(estudianteActualizado.getCedula())) {
                    // El estudiante ya existe, sobrescribe la nota
                    estudiante.setNota(nota);
                    encontrado = true;
                    break; // Salir del bucle una vez encontrado el estudiante
                }
            }

            // Si no se encontró el estudiante, agrégalo a estudiantesActualizables
            if (!encontrado) {
                estudiantesActualizables.add(estudianteActualizado);
            }
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
        
        // Verificar si se encontró la asignatura seleccionada
        if (idAsignaturaSeleccionada != null) {
            // Llamar al método mostrarTablaEstudiantes con el ID de la asignatura seleccionada
            mostrarTablaEstudiantes(idAsignaturaSeleccionada);
            this.asignaturaSeleccionada = idAsignaturaSeleccionada;
        } else {
            System.out.println("No se encontró la asignatura seleccionada.");
        }
        asignarNotaFrame.getCmb_asignatura().transferFocus();
    }

    private void mostrarTablaEstudiantes(String idAsignatura) {
        List<NotaEstudianteListModel> estudiantes = connection.obtenerEstudiantesParaAsignarNota(profesor.getCedula(), idAsignatura);
        this.estudiantes = estudiantes;
        asignarNotaFrame.configurarTablaEstudiantes(estudiantes, idAsignatura);
    }

    private void guardarNotas() {
        if (estudiantesActualizables.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes colocar al menos una nota para poder guardar", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        System.out.println("guardando notas: " + asignaturaSeleccionada);
        int rowsAffected = connection.actualizarNotasEstudiantes(estudiantesActualizables, asignaturaSeleccionada);

        if (rowsAffected > 0) {
            showSuccessAlert(true);
        } else {
            showSuccessAlert(false);
        }
    }

    private void showSuccessAlert(boolean exitosa) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                exitosa ? "¡Las notas han sido actualizadas exitosamente!" : "No se pudieron actualizar las notas correctamente",
                exitosa ? "Felicidades" : "Ha ocurrido un error",
                JOptionPane.OK_OPTION,
                exitosa ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION && exitosa) {
            showInicioFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
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
