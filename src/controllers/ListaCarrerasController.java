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
import util.PantallaCompleta;
import views.ListaCarrerasFrame;


public class ListaCarrerasController implements ActionListener {

    private static ListaCarrerasController instance;
    public ListaCarrerasFrame listaCarrerasFrame;
    public CrudController crudController;
    public List<ComponenteUniversitario> carreras = new ArrayList<>();;

    private ListaCarrerasController() {
        listaCarrerasFrame = new ListaCarrerasFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaCarrerasFrame);
        listaCarrerasFrame.setVisible(false);
    }

    public static ListaCarrerasController getInstance() {
        if (instance == null) {
            instance = new ListaCarrerasController();
        }
        return instance;
    }

    public void showListaCarrerasFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(listaCarrerasFrame);
        listaCarrerasFrame.setVisible(true);
        MostrarCarreras();
    }

    private void showInicioFrame() {
        listaCarrerasFrame.setVisible(false);
        crudController.showCrudFrame();
    }

    public void setCrudController(CrudController crudController) {
        this.crudController = crudController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showInicioFrame();
    }
    
    public void MostrarCarreras(){
        
        if (carreras == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las carreras correctamente", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            listaCarrerasFrame.setupTable(carreras);
            listaCarrerasFrame.displayUI(true);
        }
    }

}
