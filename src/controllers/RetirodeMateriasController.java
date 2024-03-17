/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.PantallaCompleta;

import views.RetirodeMateriasFrame;
/**
 *
 * @author usuario
 */
public class RetirodeMateriasController implements ActionListener {
     private static RetirodeMateriasController instance;
    public RetirodeMateriasFrame retirodeMateriasFrame;
    
    public InicioController inicioController;

    private RetirodeMateriasController() {
       retirodeMateriasFrame = new RetirodeMateriasFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirodeMateriasFrame);
        retirodeMateriasFrame.setVisible(false);
    }

    public static RetirodeMateriasController getInstance() {
        if (instance == null) {
            instance = new RetirodeMateriasController();
        }
        return instance;
    }

    public void showRetirodeMateriasFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirodeMateriasFrame);
       retirodeMateriasFrame.setVisible(true);
    }
    private void showInicioFrame() {
        retirodeMateriasFrame.setVisible(false);
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
