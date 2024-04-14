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
import factoryMethod.ListadoFactory;
import factoryMethod.DataFetcher;

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
        DataFetcher dataFetcher = ListadoFactory.create(tipoSeleccionado);
        ArrayList<?> dataSource = dataFetcher.obtenerDatos();

        if (dataSource != null) {
            switch (tipoSeleccionado) {
                case "Seleccione listado":
                    listadoEstudiantesFrame.limpiarUI();
                    break;
                case "Por carrera":
                    listadoEstudiantesFrame.configurarTablaTresColumnas((ArrayList<TresColumnasModel>) dataSource, "Carrera", "Por carrera");
                    break;
                case "Por semestre":
                    listadoEstudiantesFrame.configurarTablaTresColumnas((ArrayList<TresColumnasModel>) dataSource, "Semestre", "Por semestre");
                    break;
                case "20 mejores promedios por carrera":
                    String[] columnas1 = {"Num", "Cedula", "Nombre", "Carrera", "Calificación promedio"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas((ArrayList<CuatroColumnasModel>) dataSource, columnas1, "20 mejores promedios por carrera");
                    break;

                case "Genero de carrera y decanato":
                    listadoEstudiantesFrame.configurarTablaCincoColumnas((ArrayList<CincoColumnasModel>) dataSource, "Genero de carrera y decanato");
                    break;
                case "20 mejores promedios por decanato":
                    String[] columna2 = {"Num", "Cedula", "Nombre", "Decanato", "Calificación promedio"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas((ArrayList<CuatroColumnasModel>) dataSource, columna2, "20 mejores promedios por decanato");
                    break;
                case "Promedios por encima de 16 puntos":
                    listadoEstudiantesFrame.configurarTablaTresColumnas((ArrayList<TresColumnasModel>) dataSource, "Calificación promedio", "Promedios por encima de 16 puntos");
                    break;
                case "Con materia retirada":
                    String[] columnas3 = {"Num", "Cedula", "Nombre", "Asignatura", "Periodo academico"};
                    listadoEstudiantesFrame.configurarTablaCuatroColumnas((ArrayList<CuatroColumnasModel>) dataSource, columnas3, "Con materia retirada");

                default:
                    break;
            }
            this.listadoActual = dataSource;
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
