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
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import models.TresColumnasModel;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.ListadoEstudiantesFrame;

public class ListadoEstudiantesController implements ActionListener {

    private static ListadoEstudiantesController instance;
    public ListadoEstudiantesFrame listadoEstudiantesFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    private final List<String> opcionesListado = Arrays.asList(
            "Seleccione listado",
            "Por carrera",
            "Por semestre",
            "20 mejores promedios por carrera",
            "Genero de carrera y decanato",
            "20 mejores promedios por decanato",
            "Promedios por encima de 16 puntos"
    );

    public ListadoEstudiantesController() {
        //traer la vista y el modelo
        listadoEstudiantesFrame = new ListadoEstudiantesFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listadoEstudiantesFrame);
        listadoEstudiantesFrame.setupComboBox(opcionesListado);
        listadoEstudiantesFrame.setVisible(false);
    }

    public static ListadoEstudiantesController getInstance() {
        if (instance == null) {
            instance = new ListadoEstudiantesController();
        }
        return instance;
    }

    public void showListadoEstudiantesFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listadoEstudiantesFrame);
        listadoEstudiantesFrame.setVisible(true);
    }

    private void showInicioFrame() {
        listadoEstudiantesFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    private void manejarCambioDeListado(ActionEvent button) {
        JComboBox<String> comboBox = (JComboBox<String>) button.getSource();
        String tipoSeleccionado = (String) comboBox.getSelectedItem();

        listadoEstudiantesFrame.getCmb_listado_estudiantes().transferFocus();
        switch (tipoSeleccionado) {
            case "Seleccione listado":
                listadoEstudiantesFrame.limpiarTabla();
            case "Por carrera":
                ArrayList<TresColumnasModel> datasourceCarrera = connection.getEstudiantes("carrera");
                if (datasourceCarrera != null) {
                    System.out.println("carrera");
                    listadoEstudiantesFrame.setupTable(datasourceCarrera, "Carrera");
                    listadoEstudiantesFrame.displayUI(true);
                }
            case "Por semestre":
                ArrayList<TresColumnasModel> datasourceSemestre = connection.getEstudiantes("semestre");
                if (datasourceSemestre != null) {
                    System.out.println("semestre");
                    listadoEstudiantesFrame.setupTable(datasourceSemestre, "Semestre");
                    listadoEstudiantesFrame.displayUI(true);
                }
            // Handle selection for "Por semestre"

            case "20 mejores promedios por carrera":
                System.out.println("20 mejores promedios por carrera");
            // Handle selection for "20 mejores promedios por carrera"

            case "Genero de carrera y decanato":
                System.out.println("Genero");
            // Handle selection for "Genero de carrera y decanato"

            case "20 mejores promedios por decanato":
                System.out.println("20 mejores promedios por decanato");
            // Handle selection for "20 mejores promedios por decanato"

            case "Promedios por encima de 16 puntos":
                System.out.println("Promedios por encima de 16");
            // Handle selection for "Promedios por encima de 16 puntos"

            default:
                System.out.println("Random");
            // Handle unknown selection

        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == listadoEstudiantesFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == listadoEstudiantesFrame.getCmb_listado_estudiantes()) {
            manejarCambioDeListado(event);
        }
    }
}
