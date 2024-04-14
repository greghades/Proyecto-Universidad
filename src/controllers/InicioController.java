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
import util.PantallaCompleta;
import views.InicioFrame;

public class InicioController implements ActionListener {

    private static InicioController instance;
    public InicioFrame inicioFrame;
    public InscripcionController inscripcionController;
    public ListaSeccionController listaSeccionController;
    public ListadoEstudiantesController listadoEstudiantesController;
    public RetirarMateriaController retirarMateriaController;
    public AsignarNotaController asignarNotaController;
    public EstudianteController estudianteController;
    public ProfesorController profesorController;

    public InicioController() {
        inicioFrame = new InicioFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(inicioFrame);
        inicioFrame.setVisible(true);
    }

    public static InicioController getInstance() {
        if (instance == null) {
            instance = new InicioController();
        }
        return instance;
    }

    public void showInicioFrame() {
        inicioFrame.setVisible(true);
    }

    private void showInscripcionFrame() {
        inicioFrame.setVisible(false);
        inscripcionController.showInscripcionFrame();
    }

    private void showListaSeccionFrame() {
        inicioFrame.setVisible(false);
        listaSeccionController.showListaSeccionFrame();
    }

    private void showListadoEstudiantesFrame() {
        inicioFrame.setVisible(false);
        listadoEstudiantesController.showListadoEstudiantesFrame();
    }

    private void showRetirarMateriaFrame() {
        inicioFrame.setVisible(false);
        retirarMateriaController.showRetirarMateriaFrame();
    }

    private void showAsignarNotaFrame() {
        inicioFrame.setVisible(false);
        asignarNotaController.showAsignarNotaFrame();
    }
    
    private void showEstudianteFrame(){
        inicioFrame.setVisible(false);
        estudianteController.showEstudianteFrame();
    }
    
    private void showProfesorFrame() {
        inicioFrame.setVisible(false);
        profesorController.showProfesorFrame();
    }

    public void setInscripcionController(InscripcionController inscripcionController) {
        this.inscripcionController = inscripcionController;
    }
    
    public void setAsignarNotaController(AsignarNotaController asignarNotaController) {
        this.asignarNotaController = asignarNotaController;
    }

    public void setListaSeccionController(ListaSeccionController listaSeccionController) {
        this.listaSeccionController = listaSeccionController;
    }

    public void setListadoEstudiantesController(ListadoEstudiantesController listadoEstudiantesController) {
        this.listadoEstudiantesController = listadoEstudiantesController;
    }

    public void setRetirarMateriaController(RetirarMateriaController retirarMateriaController) {
        this.retirarMateriaController = retirarMateriaController;
    }
    public void setEstudianteController(EstudianteController estudianteController){
        this.estudianteController = estudianteController;
    }
    public void setProfesorController(ProfesorController profesorController) {
        this.profesorController = profesorController;
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == inicioFrame.getListado_seccion_button()) {
            showListaSeccionFrame();
            listaSeccionController.MostrarSeciones();
        } else if (button.getSource() == inicioFrame.getInscripcion_button()) {
            showInscripcionFrame();
        } else if (button.getSource() == inicioFrame.getListado_estudiante_button()) {
            showListadoEstudiantesFrame();
        } else if (button.getSource() == inicioFrame.getRetirar_materia_button()) {
            showRetirarMateriaFrame();
        } else if (button.getSource() == inicioFrame.getAsignar_nota_button()) {
            showAsignarNotaFrame();
        } else if(button.getSource() == inicioFrame.getEstudiante_Button()){
            showEstudianteFrame();
        } else if (button.getSource() == inicioFrame.getProfesor_Button()) {
            showProfesorFrame();
        }
    }
}
