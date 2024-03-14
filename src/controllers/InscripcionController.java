/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import views.InscripcionFrame;

public class InscripcionController {
    
private static InscripcionController instance; // Singleton instance
  public InscripcionFrame inscripcionFrame;
  private InicioController inicioController; // Reference to InicioController

  private InscripcionController() {
    inscripcionFrame = new InscripcionFrame(this);
    inscripcionFrame.setVisible(false); // Initially hide InscripcionFrame
  }

  public static InscripcionController getInstance() {
    if (instance == null) {
      instance = new InscripcionController();
    }
    return instance;
  }

  public void showInscripcionFrame() {
    inscripcionFrame.setVisible(true); // Show InscripcionFrame
  }

  public void showInicioFrame() {
    inscripcionFrame.setVisible(false); // Hide InscripcionFrame
    inicioController.showInicioFrame(); // Delegate to InicioController
  }

  public void setInicioController(InicioController inicioController) {
    this.inicioController = inicioController; // Set reference
  }
}
