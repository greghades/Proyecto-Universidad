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

import compose.ComponenteUniversitario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.ListadoDecanatoModel;
import models.Universidad;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.ListaDecanatosFrame;


public class ListaDecanatosController implements ActionListener {

    private static ListaDecanatosController instance;
    public ListaDecanatosFrame listaDecanatosFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    public List<ComponenteUniversitario> decanatos = new ArrayList<>();;

    private ListaDecanatosController() {
        listaDecanatosFrame = new ListaDecanatosFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaDecanatosFrame);
        listaDecanatosFrame.setVisible(false);
    }

    public static ListaDecanatosController getInstance() {
        if (instance == null) {
            instance = new ListaDecanatosController();
        }
        return instance;
    }

    public void showListaDecanatosFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaDecanatosFrame);
        listaDecanatosFrame.setVisible(true);
        MostrarDecanatos();
    }

    private void showInicioFrame() {
        listaDecanatosFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showInicioFrame();
    }
    
    public void MostrarDecanatos(){
        
        if (decanatos == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las secciones correctamente", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            listaDecanatosFrame.setupTable(decanatos);
            listaDecanatosFrame.displayUI(true);
        }
    }

}
