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
import javax.swing.JOptionPane;
import models.*;
import sql.ConexionSQL;
import util.CheckableCellEventListener;
import util.PantallaCompleta;
import views.RetirarMateriaFrame;

public class RetirarMateriaController implements ActionListener, CheckableCellEventListener {

    private static RetirarMateriaController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public RetirarMateriaFrame retirarMateriaFrame;
    public InicioController inicioController;
    private InscripcionInfo info;
    private final ArrayList<InscripcionData> retiros = new ArrayList<>();

    private RetirarMateriaController() {
        retirarMateriaFrame = new RetirarMateriaFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirarMateriaFrame);
        retirarMateriaFrame.setVisible(false);
    }

    public static RetirarMateriaController getInstance() {
        if (instance == null) {
            instance = new RetirarMateriaController();
        }
        return instance;
    }

    public void showRetirarMateriaFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirarMateriaFrame);
        limpiarFormulario();
        retirarMateriaFrame.setVisible(true);
    }

    private void showInicioFrame() {
        retirarMateriaFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    private void limpiarFormulario() {
        info = null;
        retiros.removeAll(retiros);
        retirarMateriaFrame.displayUI(false);
        retirarMateriaFrame.limpiarTabla();
    }

    private void mostrarDatos() {
        if ("Cedula".equals(retirarMateriaFrame.getCedula()) || retirarMateriaFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.info = connection.obtenerEstudianteConAsignaturas(retirarMateriaFrame.getCedula(), true);

        if (info == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante inscrito con esa cedula", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            retirarMateriaFrame.setCarrera(info.getEstudiante().getCarrera().getNombre());
            retirarMateriaFrame.setCorreo(info.getEstudiante().getCorreo());
            retirarMateriaFrame.setEdad(String.valueOf(info.getEstudiante().getEdad()));
            retirarMateriaFrame.setNombre(info.getEstudiante().getNombre());
            retirarMateriaFrame.setSexo(info.getEstudiante().getSexo());
            retirarMateriaFrame.setupTable(info.getAsignaturas());
            retirarMateriaFrame.displayUI(true);
        }
    }

    private void retirarAsignatura() {
        String cedulaEstudianteConMateriaRetirada = connection.revisarRetiroMateria(retiros.get(0).getId_estudiante());
        
        if (cedulaEstudianteConMateriaRetirada.isEmpty()) {
            String mensajeConsulta = connection.retirarAsignatura(retiros);
            if (mensajeConsulta.contains("No")) {
                showSuccessAlert(false, mensajeConsulta);
            } else {
                showSuccessAlert(true, mensajeConsulta);
            }            
        } else if (cedulaEstudianteConMateriaRetirada == null) {
            showAlert("Ha ocurrido un error", "No se pudo realizar la consulta para retirar mediante base de datos.", false);
        } else {
            showAlert("Lo sentimos", "El estudiante ya retiro una materia este periodo academico.", false);
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
            showInicioFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }
    }

    private void showSuccessAlert(boolean exitosa, String message) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                message,
                exitosa ? "Felicidades" : "Ha ocurrido un error",
                JOptionPane.OK_OPTION,
                exitosa ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION) {
            showInicioFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == retirarMateriaFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == retirarMateriaFrame.getCedula_button()) {
            mostrarDatos();
        } else if (button.getSource() == retirarMateriaFrame.getBtn_retirar_asignatura()) {
            retirarAsignatura();
        }
    }

    @Override
    public void onCheckboxValueChanged(int row, boolean value) {
        // Implementar la lógica para manejar el cambio de valor del checkbox
        Asignatura asignaturaSeleccionada = info.getAsignaturas().get(row);
        asignaturaSeleccionada.setInclusion(value);
        info.setAsignatura(row, asignaturaSeleccionada);

        PeriodoAcademico periodo = connection.getPeriodoAcademico(asignaturaSeleccionada.getId());

        InscripcionData inscripcion = new InscripcionData(info.getEstudiante().getCedula(), asignaturaSeleccionada.getId(), periodo.getId(), asignaturaSeleccionada.getSeccion().getId());

        // Si this.inscripciones está vacío, inicializar con la inscripcion generada
        if (retiros.isEmpty()) {
            retiros.add(inscripcion);
        } else {
            // Si this.inscripciones no está vacío
            if (!value) {
                // Si value es falso, eliminar la inscripcion si existe
                retiros.removeIf(i -> i.equals(inscripcion));
            } else {
                // Si value es verdadero, validar la existencia de la inscripcion
                if (!retiros.contains(inscripcion)) {
                    // Si no existe, agregar la inscripcion al arreglo
                    retiros.add(inscripcion);
                }
            }
        }
        retirarMateriaFrame.actualizarBoton(!retiros.isEmpty());
    }
}
