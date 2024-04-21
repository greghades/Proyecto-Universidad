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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.*;
import sql.ConexionSQL;
import util.CheckableCellEventListener;
import util.PantallaCompleta;
import views.InscripcionFrame;

public class InscripcionController implements ActionListener, CheckableCellEventListener {

    private static InscripcionController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InscripcionFrame inscripcionFrame;
    public InicioController inicioController;
    private InscripcionInfo info;
    private final ArrayList<InscripcionData> inscripciones = new ArrayList<>();

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
        limpiarFormulario();
        inscripcionFrame.setVisible(true);
    }

    private void showInicioFrame() {
        inscripcionFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    private void limpiarFormulario() {
        info = null;
        inscripciones.removeAll(inscripciones);
        inscripcionFrame.displayUI(false);
        inscripcionFrame.limpiarTabla();
    }

    private void mostrarDatos() {
        if ("Cedula".equals(inscripcionFrame.getCedula()) || inscripcionFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (connection.validarInscripcion(inscripcionFrame.getCedula())) {
            JOptionPane.showMessageDialog(null, "El estudiante ingresado ya se encuentra inscrito", "Operacion no disponible", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.info = connection.obtenerEstudianteConAsignaturas(inscripcionFrame.getCedula(), false);
        
        if (info == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con esa cedula", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            inscripcionFrame.setCarrera(info.getEstudiante().getCarrera().getNombre());
            inscripcionFrame.setCorreo(info.getEstudiante().getCorreo());
            inscripcionFrame.setEdad(String.valueOf(info.getEstudiante().getEdad()));
            inscripcionFrame.setNombre(info.getEstudiante().getNombre());
            inscripcionFrame.setSexo(info.getEstudiante().getSexo());
            inscripcionFrame.setupTable(info.getAsignaturas());
            inscripcionFrame.displayUI(true);
        }
    }

    private void inscribirEstudiante() {
        if (connection.validarInscripcion(inscripcionFrame.getCedula())) {
            JOptionPane.showMessageDialog(null, "El estudiante ingresado ya se encuentra inscrito", "Operacion no disponible", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowsAffected = connection.inscribirEstudiante(inscripciones);

        if (rowsAffected > 0) {
            showSuccessAlert(true);
        } else {
            showSuccessAlert(false);
        }
    }

    private void manejarCambioDeSeccion(ActionEvent button) {
        JComboBox<String> comboBox = (JComboBox<String>) button.getSource();
        String selectedSeccion = (String) comboBox.getSelectedItem();

        // Access inicioFrame to get the asignatura based on the container panel
        Asignatura asignatura = (Asignatura) comboBox.getClientProperty("asignatura");
        ArrayList<Seccion> secciones = (ArrayList<Seccion>) comboBox.getClientProperty("secciones");

        Seccion seccionSeleccionada = null;
        for (Seccion seccion : secciones) {
            if (selectedSeccion.equals(String.valueOf(String.format("Seccion %s", seccion.getNumero())))) {
                seccionSeleccionada = seccion;
                break;
            }
        }
        Profesor profesor = connection.obtenerProfesorPorAsignaturaYSeccion(asignatura.getId(), seccionSeleccionada.getId());

        for (JPanel panel : inscripcionFrame.materiaPanels) {
            JPanel entryPanel = (JPanel) panel.getComponent(1);
            JLabel materiaLabel = (JLabel) entryPanel.getComponent(0);
            String asignaturaFormateada = String.format("<html><font size=\"4\" color=\"#3A9FDC\">Materia:</font> %s</html>", asignatura.getNombre());

            if (materiaLabel.getText().equals(asignaturaFormateada)) {
                JLabel profesorLabel = (JLabel) entryPanel.getComponent(2);
                profesorLabel.setText("<html><font size=\"4\" color=\"#3A9FDC\">Profesor:</font> " + profesor.getNombre() + "</html>");
                break;
            }
        }

        for (InscripcionData inscripcion : inscripciones) {
            if (inscripcion.getId_asignatura().equals(asignatura.getId())) {
                inscripcion.setId_seccion(seccionSeleccionada.getId());
                break;
            }
        }
    }
    
    private void showSuccessAlert(boolean exitosa) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                exitosa ? "¡Te has inscrito correctamente!" : "No se pudo llevar a cabo la inscripcion correctamente",
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
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == inscripcionFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == inscripcionFrame.getCedula_button()) {
            mostrarDatos();
        } else if (button.getSource() == inscripcionFrame.getInscripcion_button()) {
            inscribirEstudiante();
        } else if (button.getSource() instanceof JComboBox) {
            manejarCambioDeSeccion(button);
        }
    }

    @Override
    public void onCheckboxValueChanged(int row, boolean value) {
        // Implementar la lógica para manejar el cambio de valor del checkbox
        Asignatura asignaturaSeleccionada = info.getAsignaturas().get(row);
        asignaturaSeleccionada.setInclusion(value);
        info.setAsignatura(row, asignaturaSeleccionada);

        // Obtener nombre de profesor
        ArrayList<Seccion> secciones = connection.obtenerSecciones(asignaturaSeleccionada.getId());
        Profesor profesor = connection.obtenerProfesorPorAsignaturaYSeccion(asignaturaSeleccionada.getId(), secciones.get(0).getId());
        PeriodoAcademico periodo = connection.obtenerPeriodoAcademico(asignaturaSeleccionada.getId());
        inscripcionFrame.actualizarPanelDeMaterias(value, asignaturaSeleccionada, profesor, secciones);

        InscripcionData inscripcion = new InscripcionData(info.getEstudiante().getCedula(), asignaturaSeleccionada.getId(), periodo.getId(), secciones.get(0).getId());

        // Si this.inscripciones está vacío, inicializar con la inscripcion generada
        if (inscripciones.isEmpty()) {
            inscripciones.add(inscripcion);
        } else {
            // Si this.inscripciones no está vacío
            if (!value) {
                // Si value es falso, eliminar la inscripcion si existe
                inscripciones.removeIf(i -> i.equals(inscripcion));
            } else {
                // Si value es verdadero, validar la existencia de la inscripcion
                if (!inscripciones.contains(inscripcion)) {
                    // Si no existe, agregar la inscripcion al arreglo
                    inscripciones.add(inscripcion);
                }
            }
        }
    }
}
