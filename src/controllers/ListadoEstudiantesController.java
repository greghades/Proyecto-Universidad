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
import models.CincoColumnasModel;
import models.CuatroColumnasModel;
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
            "Promedios por encima de 16 puntos",
            "Con materia retirada"
    );
    private ArrayList listadoActual;

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
        listadoEstudiantesFrame.limpiarUI();
        listadoEstudiantesFrame.mostrarUI(false);
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
            case "Seleccione listado" -> listadoEstudiantesFrame.limpiarUI();
            case "Por carrera" -> {
                ArrayList<TresColumnasModel> datasourceCarrera = connection.getEstudiantesTres("carrera");
                if (datasourceCarrera != null) {
                    listadoEstudiantesFrame.configurarTablaTresColumnas(datasourceCarrera, "Carrera", "Por carrera");
                    this.listadoActual = datasourceCarrera;
                }
            }
            case "Por semestre" -> {
                ArrayList<TresColumnasModel> datasourceSemestre = connection.getEstudiantesTres("semestre");
                if (datasourceSemestre != null) {
                    listadoEstudiantesFrame.configurarTablaTresColumnas(datasourceSemestre, "Semestre",  "Por semestre");
                    this.listadoActual = datasourceSemestre;
                }
            }
            case "20 mejores promedios por carrera" -> {
                ArrayList<CuatroColumnasModel> datasource20Carrera = connection.getEstudiantesCuatro("20 promedios carrera");
                if (datasource20Carrera != null) {
                    String[] columnas = {"Num", "Cedula", "Nombre", "Carrera", "Calificación promedio"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas(datasource20Carrera, columnas,  "20 mejores promedios por carrera");
                    this.listadoActual = datasource20Carrera;
                }
            }
            case "Genero de carrera y decanato" -> {
                ArrayList<CincoColumnasModel> datasourcegenero = connection.getEstudiantesCinco();
                if (datasourcegenero != null) {
                    listadoEstudiantesFrame.configurarTablaCincoColumnas(datasourcegenero, "Genero de carrera y decanato");
                    this.listadoActual = datasourcegenero;
                }
            }
            case "20 mejores promedios por decanato" -> {
                ArrayList<CuatroColumnasModel> datasource20Decanato = connection.getEstudiantesCuatro("20 promedios decanato");
                if (datasource20Decanato != null) {
                    String[] columnas = {"Num", "Cedula", "Nombre", "Decanato", "Calificación promedio"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas(datasource20Decanato, columnas,  "20 mejores promedios por decanato");
                    this.listadoActual = datasource20Decanato;
                }
            }
            case "Promedios por encima de 16 puntos" -> {
                ArrayList<TresColumnasModel> datasource16promedios = connection.getEstudiantesTres("16 promedios");
                if (datasource16promedios != null) {
                    listadoEstudiantesFrame.configurarTablaTresColumnas(datasource16promedios, "Calificación promedio",  "Promedios por encima de 16 puntos");
                    this.listadoActual = datasource16promedios;
                }
            }
            case "Con materia retirada" -> {
                ArrayList<CuatroColumnasModel> datasourceRetiroMateria = connection.getEstudiantesCuatro("Con materia retirada");
                if (datasourceRetiroMateria != null) {
                    String[] columnas = {"Num", "Cedula", "Nombre", "Asignatura", "Periodo academico"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas(datasourceRetiroMateria, columnas,  "Con materia retirada");
                    this.listadoActual = datasourceRetiroMateria;
                }
            }
            default -> {
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == listadoEstudiantesFrame.getBack_button()) {
            showInicioFrame();
        } else if (event.getSource() == listadoEstudiantesFrame.getSearch_button()) {
            listadoEstudiantesFrame.search();
        } else if (event.getSource() == listadoEstudiantesFrame.getCmb_listado_estudiantes()) {
            manejarCambioDeListado(event);
        }
    }
}
