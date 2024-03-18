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
import views.InscripcionFrame;

public class InscripcionController implements ActionListener, CheckableCellEventListener {

    private static InscripcionController instance;
    public ConexionSQL connection;
    public InscripcionFrame inscripcionFrame;
    public InicioController inicioController;
    private InscripcionInfo info;

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
        inscripcionFrame.setVisible(true);
    }

    private void showInicioFrame() {
        inscripcionFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void setConnection(ConexionSQL conexion) {
        this.connection = conexion;
    }

    private void mostrarDatos() {
        if ("Cedula".equals(inscripcionFrame.getCedula()) || inscripcionFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.info = connection.obtenerDatosDeInscripcion(inscripcionFrame.getCedula());

        System.out.println(info);
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

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == inscripcionFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == inscripcionFrame.getCedula_button()) {
            mostrarDatos();
        } else if (button.getSource() == inscripcionFrame.getInscripcion_button()) {   
            for (int index = 0; index < this.info.getAsignaturas().size(); index++) {
                System.out.println("Asignatura: " + info.getAsignaturas().get(index).getNombre() + ", Inscribir: " + info.getAsignaturas().get(index).esRetirada());
            }
        }
    }

    @Override
    public void onCheckboxValueChanged(int row, boolean value) {
        // Implementar la lógica para manejar el cambio de valor del checkbox
        Asignatura asignaturaSeleccionada = info.getAsignaturas().get(row);
        asignaturaSeleccionada.setInclusion(value);
        info.setAsignatura(row, asignaturaSeleccionada);
        
        // Obtener nombre de profesor
        Profesor profesor = connection.getProfesor(asignaturaSeleccionada.getId());
        ArrayList<Seccion> secciones = connection.getSecciones(asignaturaSeleccionada.getId());
        System.out.println("Nombre: " + profesor.getNombre() + ", Materia: " + asignaturaSeleccionada.getNombre() + "Mostrar: " + value);
        String[] numerosDeSeccion = secciones.stream().map(seccion -> String.format("Seccion %s", seccion.getNumero())).toArray(String[]::new);
        inscripcionFrame.actualizarPanelDeMaterias(value, asignaturaSeleccionada.getNombre(), profesor.getNombre(), numerosDeSeccion);
    }
}
