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
import javax.swing.JOptionPane;
import models.Carrera;
import models.Estudiante;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.EstudianteFrame;

public class EstudianteController implements ActionListener {
    public Estudiante estudiante;
    private static EstudianteController instance;
    public EstudianteFrame estudianteFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
   

    public EstudianteController() {
        estudianteFrame = new EstudianteFrame(this); 
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(estudianteFrame);
        estudianteFrame.setVisible(false);
    }

    public static EstudianteController getInstance() {
        if (instance == null) {
            instance = new EstudianteController();
        }
        return instance;
    }

    public void showEstudianteFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(estudianteFrame);
        estudianteFrame.setVisible(true);
        estudianteFrame.mostrarEstadoInicial();
    }

    private void showInicioFrame() {
        estudianteFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void mostrarDatos() {
        if ("Cedula".equals(estudianteFrame.getCedula()) || estudianteFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.estudiante = connection.getEstudiante(estudianteFrame.getCedula(), false);
        //this.profesor = connection.getDatosProfesor(asignarNotaFrame.getCedula());

        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun profesor con ese id", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            estudianteFrame.rellenarInformacionInicial(estudiante);
        }
    }
    
public void insertarEstudiante() {
  Estudiante nuevoEstudiante = connection.insertarEstudiante(estudiante);

  // Si el estudiante se insertó correctamente
  if (nuevoEstudiante != null) {
      this.estudiante = nuevoEstudiante;
  } else {
      JOptionPane.showMessageDialog(null, "Error al registrar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
  }
}
    
    private void limpiar(){
        estudianteFrame.cedula_textfield.setText(null);
         estudianteFrame.carrera_textfield.setText(null);
         estudianteFrame.nombre_textfield.setText(null);
         estudianteFrame.correo_textfield.setText(null);
         estudianteFrame.edad_textfield1.setText(null);
         estudianteFrame.sexo_textfield.setText(null);
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
        if (event.getSource() == estudianteFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == estudianteFrame.getCedula_button()) {
            mostrarDatos();
        } else if (event.getSource() == estudianteFrame.getLimpiar_button()) {
            limpiar();
        }else if (event.getSource() == estudianteFrame.getAgregar_button()) {
        insertarEstudiante();
        }
    }
}
