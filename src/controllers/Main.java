/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author User
 */
public class Main {
     public static void main(String[] args) {
    InicioController inicioController = InicioController.getInstance();
    InscripcionController inscripcionController = InscripcionController.getInstance();
    
    inicioController.setInscripcionController(inscripcionController);
    inscripcionController.setInicioController(inicioController);// Establish references between controllers
    
    System.out.println("Main main");
    
  }
}
