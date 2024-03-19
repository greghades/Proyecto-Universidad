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
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.ListadoEstudiantesFrame;

public class ListadoEstudiantesController implements ActionListener {

    private static ListadoEstudiantesController instance;
    public ListadoEstudiantesFrame listadoEstudiantesFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;

    //constructor 
    public ListadoEstudiantesController() {
        //traer la vista y el modelo
        listadoEstudiantesFrame = new ListadoEstudiantesFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listadoEstudiantesFrame);
        listadoEstudiantesFrame.setVisible(false);

    }

    //que la instancia exista en el controlador???
    public static ListadoEstudiantesController getInstance() {
        if (instance == null) {
            instance = new ListadoEstudiantesController();
        }
        return instance;
    }

    //VISIBILIDAD
    public void showListadoEstudiantesFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listadoEstudiantesFrame);
        listadoEstudiantesFrame.setVisible(true);
    }

    private void showInicioFrame() {
        listadoEstudiantesFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    //inicio controlador
    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showInicioFrame();
    }
    /*interaccion base de datos
     public void setConnection(ConexionSQL conexion) {
        this.connection = conexion;
    }*/

//acciones que va a realizar el boton
}
