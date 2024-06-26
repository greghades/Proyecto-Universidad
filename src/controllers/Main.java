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
        RetirarMateriaController retirarMateriaController = RetirarMateriaController.getInstance();
        AsignarNotaController asignarNotaController = AsignarNotaController.getInstance();
        AsignarSeccionController asignarSeccionController = AsignarSeccionController.getInstance();
        
        CrudController crudController = CrudController.getInstance();
        GestionarCrudController gestionarCrudController = GestionarCrudController.getInstance();
        crudController.setGestionarCrudController(gestionarCrudController);
        gestionarCrudController.setCrudController(crudController);
        ListaCarrerasController listaCarrerasController = ListaCarrerasController.getInstance();
        crudController.setListaCarrerasController(listaCarrerasController);
        listaCarrerasController.setCrudController(crudController);
        ListaDecanatosController listaDecanatosController = ListaDecanatosController.getInstance();
        crudController.setListaDecanatosController(listaDecanatosController);
        listaDecanatosController.setCrudController(crudController);
        
        inicioController.setInscripcionController(inscripcionController);
        inicioController.setListaSeccionController(listaSeccionController);
        inicioController.setListadoEstudiantesController(listadoEstudiantesController);
        inicioController.setRetirarMateriaController(retirarMateriaController);
        inicioController.setAsignarNotaController(asignarNotaController);
        inicioController.setCrudController(crudController);
        inicioController.setAsignarSeccionController(asignarSeccionController);

        inscripcionController.setInicioController(inicioController);
        listaSeccionController.setInicioController(inicioController);
        listadoEstudiantesController.setInicioController(inicioController);
        retirarMateriaController.setInicioController(inicioController);
        asignarNotaController.setInicioController(inicioController);
        crudController.setInicioController(inicioController);
        asignarSeccionController.setInicioController(inicioController);
    }
}
