/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.AsignarNotaFrame;

/**
 *
 * @author alba
 */
public class AsignarNotaController implements ActionListener {

    private static AsignarNotaController instance;
    public AsignarNotaFrame asignarNotaFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;

    public AsignarNotaController() {
        asignarNotaFrame = new AsignarNotaFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarNotaFrame);
        asignarNotaFrame.setVisible(false);
    }

    public static AsignarNotaController getInstance() {
        if (instance == null) {
            instance = new AsignarNotaController();
        }
        return instance;
    }

    public void showAsignarNotaFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(asignarNotaFrame);
        asignarNotaFrame.setVisible(true);
    }

    private void showInicioFrame() {
        asignarNotaFrame.setVisible(false);
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
