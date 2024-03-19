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

public class Main {
    
     public static void main(String[] args) {
    InicioController inicioController = InicioController.getInstance();
    InscripcionController inscripcionController = InscripcionController.getInstance();
    ListaSeccionController listaSeccionController = ListaSeccionController.getInstance();
    ListadoEstudiantesController listadoEstudiantesController = ListadoEstudiantesController.getInstance();
    AsignarNotaController asignarNotaController = AsignarNotaController.getInstance();
    
    inicioController.setInscripcionController(inscripcionController);
    inicioController.setListaSeccionController(listaSeccionController);
    inicioController.setListadoEstudiantesController(listadoEstudiantesController);
    inicioController.setAsignarNotaController(asignarNotaController);
    
    inscripcionController.setInicioController(inicioController);
    listaSeccionController.setInicioController(inicioController);
    listadoEstudiantesController.setInicioController(inicioController);
    asignarNotaController.setInicioController(inicioController);
  }
}
