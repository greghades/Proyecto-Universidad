/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static controllers.Inicio.inicioJF;
import javax.swing.JFrame;
import views.JFrame_Inicio;
import views.JFrame_Inscripcion;

/**
 *
 * @author User
 */
public class Inscripcion {
    
    public static JFrame inscripcionJF;
    
    public static void main(String[] args) {
    // Perform any pre-initialization tasks here (optional)
     
    inscripcionJF = new JFrame_Inscripcion();
    inscripcionJF.setVisible(true);
  }
    
    public void openInicioFrame() {
        if (inicioJF == null) {
           inicioJF = new JFrame_Inicio();
        }
        inscripcionJF.setVisible(false);
        inicioJF.setVisible(true);
    }
}
