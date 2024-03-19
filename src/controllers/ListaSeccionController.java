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
import views.ListaSeccionFrame;

public class ListaSeccionController implements ActionListener {

    private static ListaSeccionController instance;
    public ListaSeccionFrame listaSeccionFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;

    private ListaSeccionController() {
        listaSeccionFrame = new ListaSeccionFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaSeccionFrame);
        listaSeccionFrame.setVisible(false);
    }

    public static ListaSeccionController getInstance() {
        if (instance == null) {
            instance = new ListaSeccionController();
        }
        return instance;
    }

    public void showListaSeccionFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaSeccionFrame);
        listaSeccionFrame.setVisible(true);
    }

    private void showInicioFrame() {
        listaSeccionFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showInicioFrame();
    }

}
