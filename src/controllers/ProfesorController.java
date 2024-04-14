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
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.ProfesorFrame;

/**
 *
 * @author Usuario
 */
public class ProfesorController implements ActionListener {
    
    public Profesor profesor;
    private static ProfesorController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public ProfesorFrame profesorFrame;
    public InicioController inicioController;
    
    public ProfesorController(){
        profesorFrame = new ProfesorFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(profesorFrame);
        profesorFrame.setVisible(false);
    }
    
    public static ProfesorController getInstance() {
        if (instance == null) {
            instance = new ProfesorController();
        }
        return instance;
    }
    
    public void showProfesorFrame () {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(profesorFrame);
        profesorFrame.setVisible(true);
        profesorFrame.mostrarEstadoInicial();
    }
    
    private void showInicioFrame () {
        profesorFrame.setVisible(false);
        inicioController.showInicioFrame();
    }
    
    public void setInicioController (InicioController inicioController) {
        this.inicioController = inicioController;
    }
    
    public void mostrarDatos() {
        if ("Cedula".equals(profesorFrame.getCedula()) || profesorFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null,"debes ingresar una cedula.", " Ten Cuidado.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.profesor = connection.getProfesor(profesorFrame.getCedula());
        
        if (profesor == null) {
            JOptionPane.showMessageDialog(profesorFrame, instance);
            JOptionPane.showMessageDialog(null,"No existe ningun profesor con ese ID.", " Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            profesorFrame.rellenarInfoInicial(profesor);
        }
    }
    
    private void Limpiar() {
        profesorFrame.cedula_prof_TextField.setText(null);
        profesorFrame.nombre_prof_TextField.setText(null);
        profesorFrame.correo_prof_TextField.setText(null);
        profesorFrame.edad_prof_TextField.setText(null);
        profesorFrame.sexo_prof_TextField.setText(null);
        profesorFrame.especialidad_prof_TextField.setText(null);
        
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
        if (event.getSource() == profesorFrame.getVolver_prof_btn()) {
            showInicioFrame();    
        } else if (event.getSource() == profesorFrame.getCedula_profesor_btn()) {
            mostrarDatos(); 
        } else if (event.getSource() == profesorFrame.getAgg_prof_Btn()) {
            
        } else if (event.getSource() == profesorFrame.getLimpiar_prof_Btn()) {
            Limpiar();
        } else if (event.getSource() == profesorFrame.getEliminar_prof_Btn()) {
            
        } else if (event.getSource() == profesorFrame.getModif_prof_Btn()) {
            
        }
    }
    
    
}
