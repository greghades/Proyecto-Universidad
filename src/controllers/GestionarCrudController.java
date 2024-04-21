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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import models.Profesor;
import models.Universidad;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.GestionarCrudFrame;

public class GestionarCrudController implements ActionListener {

    private static GestionarCrudController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public GestionarCrudFrame gestionarCrudFrame;
    public CrudController crudController;
    public boolean esAgregar;
    public String tipoCrud;
    //para el combobox del sexo
    private final List<String> opcionSexo = Arrays.asList(
            "Seleccionar ",
            "Femenino",
            "Masculino"
    );

    public GestionarCrudController() {
        gestionarCrudFrame = new GestionarCrudFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(false);
        gestionarCrudFrame.setupComboBox(opcionSexo);
    }

    public static GestionarCrudController getInstance() {
        if (instance == null) {
            instance = new GestionarCrudController();
        }
        return instance;
    }

    public void showGestionarFrame() {

        Profesor profesor = crudController.profesor;
        Universidad universidad = crudController.universidad;
        System.out.println("es agregar: " + esAgregar + " profesor: " + profesor);

        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);

        if (esAgregar) {
            limpiarVista();
            switch (tipoCrud) {
                case "profesor" ->
                    gestionarCrudFrame.configurarRegistro("Profesor");
                case "universidad" ->
                    gestionarCrudFrame.configurarRegistro("Universidad");
                default ->
                    throw new AssertionError();
            }
        } else {           
             switch (tipoCrud) {
                case "profesor" ->
                    rellenarDatos(profesor);
                case "universidad" ->
                    rellenarDatosUniversidad(universidad);
                default ->
                    throw new AssertionError();
          
        }
             gestionarCrudFrame.configurarModificacion();
        }
    }

    private void showCrudFrame() {
        gestionarCrudFrame.setVisible(false);
        crudController.showCrudFrame();
    }

    public void setCrudController(CrudController crudController) {
        this.crudController = crudController;
    }

    public void limpiarVista() {
        System.out.println(tipoCrud);
        switch (tipoCrud) {
            case "profesor" -> {

                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Correo");
                gestionarCrudFrame.third_textfield.setText("Edad");
                gestionarCrudFrame.fourth_cmb.setSelectedIndex(0);
                gestionarCrudFrame.fifth_textfield.setText("Especialidad");

            }
            case "universidad" -> {
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Direccion");

            }
            default ->
                throw new AssertionError();
        }
    }

    public void rellenarDatos(Profesor profesor) {
        gestionarCrudFrame.first_textfield.setText(profesor.getNombre());
        gestionarCrudFrame.second_textfield.setText(profesor.getCorreo());
        gestionarCrudFrame.third_textfield.setText(String.valueOf(profesor.getEdad()));
        gestionarCrudFrame.fourth_cmb.setSelectedIndex("Femenino".equals(profesor.getSexo()) ? 1 : 2);
        gestionarCrudFrame.fifth_textfield.setText(profesor.getEspecialidad());
    }

    public boolean validarCampos() {
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String edad = gestionarCrudFrame.third_textfield.getText();
        String correo = gestionarCrudFrame.second_textfield.getText();
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String especialidad = gestionarCrudFrame.fifth_textfield.getText();
        //String cedula = gestionarCrudFrame.cedula_textfield.getText();
        //String carrera = (String) gestionarCrudFrame.carrera_cmb.getSelectedItem();
        boolean contenidoValido = true;

        if ("profesor".equals(tipoCrud)) {
            if (nombre.isEmpty() || nombre.equals("Nombre")
                    || edad.isEmpty() || edad.equals("Edad")
                    || correo.isEmpty() || correo.equals("Correo")
                    || sexo.equals("Seleccione")
                    || especialidad.isEmpty() || especialidad.equals("Especialidad")) {
                showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);

                contenidoValido = false;
            }
        } else if ("univerisdad".equals(tipoCrud)) {
            if (nombre.isEmpty() || nombre.equals("Nombre")
                    || correo.isEmpty() || correo.equals("Direccion")) {
                showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);

                contenidoValido = false;
            }
        }

        return contenidoValido;
    }

    public void rellenarDatosUniversidad(Universidad universidad) {
        gestionarCrudFrame.first_textfield.setText(universidad.getNombre());
        gestionarCrudFrame.second_label.setText("Direccion:");
        gestionarCrudFrame.third_label.setVisible(false);
        gestionarCrudFrame.fourth_label.setVisible(false);
        gestionarCrudFrame.fifth_label.setVisible(false);
        gestionarCrudFrame.second_textfield.setText(universidad.getDireccion());
        gestionarCrudFrame.third_textfield.setVisible(false);
        gestionarCrudFrame.fourth_cmb.setVisible(false);
        gestionarCrudFrame.fifth_textfield.setVisible(false);
    }

    private void showAlert(String title, String message, boolean isSuccess) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.OK_OPTION,
                isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION && isSuccess) {
            crudController.showCrudFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }
    }

    //agregar
    public void agregarProfesor() {
        //obtener los datos del formulario 
        String cedula = connection.obtenerNuevoID("profesor");
        String nombre_completo = gestionarCrudFrame.first_textfield.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        String correo = gestionarCrudFrame.second_textfield.getText();
        //combobox
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String especialidad = gestionarCrudFrame.fifth_textfield.getText();

        // nuevos valores
        Profesor nuevoProfesor = new Profesor(cedula, nombre_completo, " ", correo, edad, sexo, especialidad);
        nuevoProfesor.setCedula(cedula);
        nuevoProfesor.setNombre(nombre_completo);
        nuevoProfesor.setEdad(edad);
        nuevoProfesor.setCorreo(correo);
        nuevoProfesor.setSexo(sexo);
        nuevoProfesor.setEspecialidad(especialidad);

        //consulta
        int rowsAffected = connection.agregarProfesor(nuevoProfesor);

        if (rowsAffected > 0) {
            showAlert("Felicidades", "El registro ha sido realizado exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con el registro", false);
        }
        limpiarVista();
    }

    //modificar
    public void modificarProfesor() {
        Profesor profesor = crudController.profesor;

        //datos que se van a actualizar
        String cedula = crudController.crudFrame.getCedula();
        String nombre_completo = gestionarCrudFrame.first_textfield.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String especialidad = gestionarCrudFrame.fifth_textfield.getText();
        String correo = gestionarCrudFrame.second_textfield.getText();

        profesor.setNombre(nombre_completo);
        profesor.setEdad(edad);
        profesor.setCorreo(correo);
        profesor.setSexo(sexo);
        profesor.setEspecialidad(especialidad);

        //consulta
        int rowsAffected = connection.modificarProfesor(profesor, cedula);
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
        limpiarVista();
    }

    
       //modificar
    public void modificarUniversidad() {
        Universidad universidad = crudController.universidad;

        //datos que se van a actualizar
        String id = crudController.crudFrame.getCedula();
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String direccion = gestionarCrudFrame.second_textfield.getText();

        universidad.setNombre(nombre);
        universidad.setDireccion(direccion);
       

        //consulta
        int rowsAffected = connection.modificarUniversidad(universidad, id);
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
        limpiarVista();
    }
    
    public void agregarUniversidad() {
        //obtener los datos del formulario 
        String id_universidad = connection.obtenerNuevoID("universidad");
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String direccion = gestionarCrudFrame.second_textfield.getText();

        // nuevos valores
        Universidad nuevaUniversidad = new Universidad(id_universidad, nombre, direccion);
        nuevaUniversidad.setId(id_universidad);
        nuevaUniversidad.setNombre(nombre);
        nuevaUniversidad.setDireccion(direccion);

        //consulta
        int rowsAffected = connection.agregarUniversidad(nuevaUniversidad);

        if (rowsAffected > 0) {
            showAlert("Felicidades", "El registro ha sido realizado exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con el registro", false);
        }
        limpiarVista();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gestionarCrudFrame.getBack_button()) {
            showCrudFrame();
        } else if (event.getSource() == gestionarCrudFrame.getRegistrar_btn()) {

            if (!validarCampos()) {
                return;
            }

            if (esAgregar) {

                switch (tipoCrud) {
                    case "profesor" ->
                        agregarProfesor();
                    case "universidad" ->
                        agregarUniversidad();
                    default ->
                        throw new AssertionError();
                }

            } else {
                
                switch (tipoCrud) {
                    case "profesor" ->
                        modificarProfesor();
                    case "universidad" ->
                        modificarUniversidad();
                    default ->
                        throw new AssertionError();
                }
                
            }
        } else if (event.getSource() == gestionarCrudFrame.getLimpiar_campos_btn()) {
            limpiarVista();
        }
    }
}
