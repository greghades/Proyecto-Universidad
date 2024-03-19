/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.InscripcionFrame;
import views.ListaSeccionFrame;

/**
 *
 * @author 58412
 */
public class ListaSeccionController implements ActionListener {
    
    private static ListaSeccionController instance;
    public ListaSeccionFrame listaSeccionFrame;
    public ConexionSQL connection = new ConexionSQL();
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
