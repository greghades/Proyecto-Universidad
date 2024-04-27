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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import models.Carrera;
import models.Decanato;
import models.Estudiante;
import models.Profesor;
import models.Universidad;
import observer.Observable;
import observer.Observer;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.GestionarCrudFrame;

public class GestionarCrudController implements ActionListener, Observable {

    private static GestionarCrudController instance;
    private final List<Observer> observers = new ArrayList<>();
    public ConexionSQL connection = ConexionSQL.getInstance();
    public GestionarCrudFrame gestionarCrudFrame;
    public CrudController crudController;
    public boolean esAgregar;
    public String tipoCrud;
    //combobox
    private final List<String> opcionSexo = Arrays.asList(
            "Seleccionar ",
            "Femenino",
            "Masculino"
    );
    //combobox carrera
    private ArrayList<Carrera> carreras;
    private ArrayList<Decanato> decanatos;
    private ArrayList<Universidad> universidades;

    public GestionarCrudController() {
        gestionarCrudFrame = new GestionarCrudFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(false);
        gestionarCrudFrame.setupComboBox(opcionSexo, true);
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
        Estudiante estudiante = crudController.estudiante;
        Carrera carrera = crudController.carrera;
        Decanato decanato = crudController.decanato;

        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);

        switch (tipoCrud) {
            case "estudiante" ->
                configurarCamposEstudiante();
            case "profesor" ->
                configurarCamposProfesor();
            case "universidad" ->
                configurarCamposUniversidad();
            case "carrera" ->
                configurarCamposCarrera();
            case "decanato" ->
                configurarCamposDecanato();
        }

        if (esAgregar) {
            gestionarCrudFrame.configurarRegistro();
            limpiarVista();
        } else {
            switch (tipoCrud) {
                case "profesor" -> {
                    rellenarDatosProfesor(profesor);
                }
                case "universidad" -> {
                    rellenarDatosUniversidad(universidad);
                }
                case "estudiante" -> {
                    rellenarDatosEstudiante(estudiante);
                }
                case "carrera" -> {
                    rellenarDatosCarrera(carrera);
                }
                case "decanato" -> {
                    rellenarDatosDecanato(decanato);
                }
                default -> {
                    throw new AssertionError();
                }
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

    private void limpiarVista() {
        System.out.println(" tipoCrud2: " + tipoCrud);
        switch (tipoCrud) {
            case "profesor" -> {
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Correo");
                gestionarCrudFrame.third_textfield.setText("Edad");
                gestionarCrudFrame.fourth_cmb.setSelectedIndex(0);
                gestionarCrudFrame.fifth_textfield.setText("Especialidad");

            }
            case "estudiante" -> {
                gestionarCrudFrame.cedula_textfield.setText("Cedula");
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Correo");
                gestionarCrudFrame.third_textfield.setText("Edad");
                gestionarCrudFrame.fourth_cmb.setSelectedIndex(0);
                gestionarCrudFrame.carrera_cmb.setSelectedIndex(0);

            }
            case "universidad" -> {
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Direccion");

            }
            case "carrera" -> {
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.second_textfield.setText("Modalidad");
                gestionarCrudFrame.third_textfield.setText("Duracion semestral");
                gestionarCrudFrame.carrera_cmb.setSelectedIndex(0);
            }
            case "decanato" -> {
                gestionarCrudFrame.first_textfield.setText("Nombre");
                gestionarCrudFrame.third_textfield.setText("Direccion");
                gestionarCrudFrame.carrera_cmb.setSelectedIndex(0);
            }
            default ->
                throw new AssertionError();
        }
    }

    public void rellenarDatosProfesor(Profesor profesor) {
        gestionarCrudFrame.first_textfield.setText(profesor.getNombre());
        gestionarCrudFrame.second_textfield.setText(profesor.getCorreo());
        gestionarCrudFrame.third_textfield.setText(String.valueOf(profesor.getEdad()));
        gestionarCrudFrame.fourth_cmb.setSelectedIndex("Femenino".equals(profesor.getSexo()) ? 1 : 2);
        gestionarCrudFrame.fifth_textfield.setText(profesor.getEspecialidad());
    }

    private void rellenarDatosEstudiante(Estudiante estudiante) {
        gestionarCrudFrame.cedula_textfield.setText(estudiante.getCedula());
        gestionarCrudFrame.first_textfield.setText(estudiante.getNombre());
        gestionarCrudFrame.second_textfield.setText(estudiante.getCorreo());
        gestionarCrudFrame.third_textfield.setText(String.valueOf(estudiante.getEdad()));
        gestionarCrudFrame.fourth_cmb.setSelectedIndex("Femenino".equals(estudiante.getSexo()) ? 1 : 2);
        gestionarCrudFrame.carrera_cmb.setSelectedItem(estudiante.getCarrera().getNombre());
        System.out.println("Estudiante rellenar datos" + estudiante.getCarrera().getNombre());
    }

    public void rellenarDatosCarrera(Carrera carrera) {
        gestionarCrudFrame.first_textfield.setText(carrera.getNombre());
        gestionarCrudFrame.second_textfield.setText(carrera.getModalidad());
        gestionarCrudFrame.third_textfield.setText(String.valueOf(carrera.getDuracion()));
        gestionarCrudFrame.carrera_cmb.setSelectedItem(carrera.getDecanato().getId());
    }

    public void rellenarDatosDecanato(Decanato decanato) {
        gestionarCrudFrame.first_textfield.setText(decanato.getNombre());
        gestionarCrudFrame.second_textfield.setText(decanato.getDireccion());
        gestionarCrudFrame.carrera_cmb.setSelectedItem(decanato.getId_universidad());
    }

    public void mostrarCarreras() {
        carreras = connection.obtenerCarreras();
        List<String> opcionesCarrera = new ArrayList<>();

        opcionesCarrera.add("Seleccionar");

        System.out.println("carreras: " + carreras.size());
        for (int i = 0; i < carreras.size(); i++) {
            opcionesCarrera.add(carreras.get(i).getNombre());
        }

        gestionarCrudFrame.setupComboBox(opcionesCarrera, false);
    }

    public void mostrarDecanatos() {
        decanatos = connection.obtenerDecanatos();
        List<String> opcionesDecanato = new ArrayList<>();

        opcionesDecanato.add("Seleccionar");

        System.out.println("decanatos: " + decanatos.size());
        for (int i = 0; i < decanatos.size(); i++) {
            opcionesDecanato.add(decanatos.get(i).getNombre());
        }

        gestionarCrudFrame.setupComboBox(opcionesDecanato, false);
    }

    public void mostrarUniversidades() {
        universidades = connection.obtenerUniversidades();
        List<String> opcionesUniversidad = new ArrayList<>();

        opcionesUniversidad.add("Seleccionar");

        System.out.println("universidades: " + universidades.size());
        for (int i = 0; i < universidades.size(); i++) {
            opcionesUniversidad.add(universidades.get(i).getNombre());
        }

        gestionarCrudFrame.setupComboBox(opcionesUniversidad, false);
    }

    private void configurarCamposDecanato() {
        mostrarUniversidades();
        gestionarCrudFrame.first_textfield.setText("Nombre");
        gestionarCrudFrame.second_label.setText("Direccion");
        gestionarCrudFrame.third_label.setVisible(false);
        gestionarCrudFrame.third_textfield.setVisible(false);
        gestionarCrudFrame.fourth_label.setVisible(false);
        gestionarCrudFrame.fourth_cmb.setVisible(false);
        gestionarCrudFrame.cedula_label.setVisible(false);
        gestionarCrudFrame.cedula_textfield.setVisible(false);
        gestionarCrudFrame.fifth_label.setVisible(false);
        gestionarCrudFrame.fifth_textfield.setVisible(false);
    }

    private void configurarCamposCarrera() {
        mostrarDecanatos();
        gestionarCrudFrame.first_label.setText("Nombre");
        gestionarCrudFrame.first_textfield.setText("Nombre");
        gestionarCrudFrame.second_label.setText("Modalidad");
        gestionarCrudFrame.second_textfield.setText("Modalidad");
        gestionarCrudFrame.third_label.setText("Duracion");
        gestionarCrudFrame.third_textfield.setText("Duracion");
        gestionarCrudFrame.carrera_label.setText("Decanato:");
        gestionarCrudFrame.fourth_label.setVisible(false);
        gestionarCrudFrame.cedula_textfield.setVisible(false);
        gestionarCrudFrame.cedula_label.setVisible(false);
        gestionarCrudFrame.fourth_cmb.setVisible(false);
        gestionarCrudFrame.fifth_label.setVisible(false);
        gestionarCrudFrame.fifth_textfield.setVisible(false);
    }

    private void configurarCamposUniversidad() {
        gestionarCrudFrame.second_label.setText("Direccion:");
        gestionarCrudFrame.third_label.setVisible(false);
        gestionarCrudFrame.fourth_label.setVisible(false);
        gestionarCrudFrame.fifth_label.setVisible(false);
        gestionarCrudFrame.third_textfield.setVisible(false);
        gestionarCrudFrame.fourth_cmb.setVisible(false);
        gestionarCrudFrame.fifth_textfield.setVisible(false);
        gestionarCrudFrame.second_label.setVisible(false);
        gestionarCrudFrame.second_textfield.setVisible(false);
    }

    private void configurarCamposProfesor() {
        System.out.println("controllers.GestionarCrudController.configurarCamposProfesor()");
        gestionarCrudFrame.third_textfield.setVisible(true);
        gestionarCrudFrame.third_label.setVisible(true);
        gestionarCrudFrame.fourth_cmb.setVisible(true);
        gestionarCrudFrame.fourth_label.setVisible(true);
        gestionarCrudFrame.fifth_textfield.setVisible(true);
        gestionarCrudFrame.fifth_label.setVisible(true);
        gestionarCrudFrame.carrera_cmb.setVisible(false);
        gestionarCrudFrame.carrera_label.setVisible(false);
        gestionarCrudFrame.cedula_label.setVisible(false);
        gestionarCrudFrame.cedula_textfield.setVisible(false);
    }

    private void configurarCamposEstudiante() {
        mostrarCarreras();
        gestionarCrudFrame.fifth_textfield.setVisible(false);
        gestionarCrudFrame.fifth_label.setVisible(false);
        gestionarCrudFrame.cedula_label.setVisible(true);
        gestionarCrudFrame.cedula_textfield.setVisible(true);
        gestionarCrudFrame.carrera_label.setVisible(true);
        gestionarCrudFrame.carrera_cmb.setVisible(true);
    }

    public void rellenarDatosUniversidad(Universidad universidad) {
        gestionarCrudFrame.first_textfield.setText(universidad.getNombre());
        gestionarCrudFrame.second_textfield.setText(universidad.getDireccion());
    }

    public boolean validarCampos() {
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String edad = gestionarCrudFrame.third_textfield.getText();
        String correo = gestionarCrudFrame.second_textfield.getText();
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String especialidad = gestionarCrudFrame.fifth_textfield.getText();
        String cedula = gestionarCrudFrame.cedula_textfield.getText();
        String carrera = (String) gestionarCrudFrame.carrera_cmb.getSelectedItem();
        String modalidad = gestionarCrudFrame.second_textfield.getText();
        String duracion = gestionarCrudFrame.third_textfield.getText();
        String universidad = (String) gestionarCrudFrame.carrera_cmb.getSelectedItem();

        boolean contenidoValido = true;

        switch (tipoCrud) {
            case "profesor" -> {
                if (nombre.isEmpty() || nombre.equals("Nombre")
                        || edad.isEmpty() || edad.equals("Edad")
                        || correo.isEmpty() || correo.equals("Correo")
                        || sexo.equals("Seleccione")
                        || especialidad.isEmpty() || especialidad.equals("Especialidad")) {
                    showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);
                    contenidoValido = false;
                }
            }
            case "estudiante" -> {
                if (nombre.isEmpty() || nombre.equals("Nombre")
                        || edad.isEmpty() || edad.equals("Edad")
                        || correo.isEmpty() || correo.equals("Correo")
                        || sexo.equals("Seleccione")
                        || carrera.equals("Seleccionar")
                        || cedula.isEmpty() || cedula.equals("Cedula")) {
                    showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);
                    contenidoValido = false;
                }
            }
            case "universidad" -> {
                if (nombre.isEmpty() || nombre.equals("Nombre")
                        || correo.isEmpty() || correo.equals("Direccion")) {
                    showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);

                    contenidoValido = false;
                }
            }
            case "carrera" -> {
                if (nombre.isEmpty() || nombre.equals("Nombre")
                        || modalidad.isEmpty() || modalidad.equals("Modalidad")
                        || duracion.isEmpty() || duracion.equals("Duracion")
                        || carrera.equals("Seleccionar")) {
                    showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);

                    contenidoValido = false;
                }
            }
            case "decanato" -> {
                if (nombre.isEmpty() || nombre.equals("Nombre")
                        || correo.isEmpty() || correo.equals("Direccion")
                        || universidad.equals("Seleccionar")) {
                    showAlert("Espera un momento", esAgregar ? "Debes llenar todos los campos para continuar" : "Debes editar y llenar todos los campos para continuar", false);

                    contenidoValido = false;
                }
            }
        }
        return contenidoValido;
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

    public void agregarEstudiante() {

        String cedula = gestionarCrudFrame.cedula_textfield.getText();
        String nombre_completo = gestionarCrudFrame.first_textfield.getText();
        String correo = gestionarCrudFrame.second_textfield.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Carrera carreraSeleccionada = carreras.get(selectedIndex - 1);
        Carrera carrera = carreraSeleccionada;

        //nuevos valores
        Estudiante nuevoEstudiante = new Estudiante(carrera, cedula, nombre_completo, " ", correo, edad, sexo);

        int rowsAffected = connection.agregarEstudiante(nuevoEstudiante);

        if (rowsAffected > 0) {
            showAlert("Felicidades", "El registro ha sido realizado exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con el registro", false);
        }
        limpiarVista();
    }

    public void modificarProfesor() {
        Profesor profesor = crudController.profesor;
        String cedula = crudController.crudFrame.getID();
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
            crudController.profesor = profesor;
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarEstudiante() {

        Estudiante estudiante = crudController.estudiante;
        //datos del estudiante
        String cedula = crudController.crudFrame.getID();
        String nombre_completo = gestionarCrudFrame.first_textfield.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String correo = gestionarCrudFrame.second_textfield.getText();
        //combobox carrera
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Carrera carreraSeleccionada = carreras.get(selectedIndex - 1);
        Carrera carrera = carreraSeleccionada;

        estudiante.setNombre(nombre_completo);
        estudiante.setEdad(edad);
        estudiante.setCorreo(correo);
        estudiante.setSexo(sexo);
        estudiante.setCarrera(carrera);

        //consulta
        int rowsAffected = connection.modificarEstudiante(estudiante, cedula);

        if (rowsAffected > 0) {
            crudController.estudiante = estudiante;
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    //modificar
    public void modificarUniversidad() {
        Universidad universidad = crudController.universidad;

        //datos que se van a actualizar
        String id = crudController.crudFrame.getID();
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String direccion = gestionarCrudFrame.second_textfield.getText();

        universidad.setNombre(nombre);
        universidad.setDireccion(direccion);

        //consulta
        int rowsAffected = connection.modificarUniversidad(universidad, id);
        if (rowsAffected > 0) {
            crudController.universidad = universidad;
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
    
    public void agregarDecanato() {
        String id_decanato = connection.obtenerNuevoID("decanato");
        String nombre_decanato = gestionarCrudFrame.first_textfield.getText();
        String direccion = gestionarCrudFrame.second_textfield.getText();
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Universidad universidadSeleccionada = universidades.get(selectedIndex - 1);

        Decanato nuevoDecanato = new Decanato(id_decanato, nombre_decanato, universidadSeleccionada.getId(), direccion);
        //consulta
        int rowsAffected = connection.agregarDecanato(nuevoDecanato);

        if (rowsAffected > 0) {
            showAlert("Felicidades", "El registro ha sido realizado exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con el registro", false);
        }
        limpiarVista();
    }
    
    public void agregarCarrera() {
        //obtener los datos del formulario 
        String id_carrera = connection.obtenerNuevoID("carrera");
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String modalidad = gestionarCrudFrame.second_textfield.getText();
        int duracion = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Decanato decanatoSeleccionado = decanatos.get(selectedIndex - 1);
        Decanato decanato = decanatoSeleccionado;

        // nuevos valores
        Carrera nuevaCarrera = new Carrera(id_carrera, decanato, nombre, modalidad, duracion);
        nuevaCarrera.setId(id_carrera);
        nuevaCarrera.setNombre(nombre);
        nuevaCarrera.setDecanato(decanato);
        nuevaCarrera.setDuracion(duracion);
        nuevaCarrera.setModalidad(modalidad);

        //consulta
        int rowsAffected = connection.agregarCarrera(nuevaCarrera);

        if (rowsAffected > 0) {
            showAlert("Felicidades", "El registro ha sido realizado exitosamente", true);
        } else {
            showAlert("Lo sentimos", "Ha ocurrido un error con el registro", false);
        }
        limpiarVista();
    }

    public void modificarCarrera() {
        Carrera carrera = crudController.carrera;

        //datos que se van a actualizar
        String id = crudController.crudFrame.getID();
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String modalidad = gestionarCrudFrame.second_textfield.getText();
        int duracion = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Decanato decanatoSeleccionado = decanatos.get(selectedIndex - 1);
        Decanato decanato = decanatoSeleccionado;

        carrera.setNombre(nombre);
        carrera.setDecanato(decanato);
        carrera.setDuracion(duracion);
        carrera.setModalidad(modalidad);

        //consulta
        int rowsAffected = connection.modificarCarrera(carrera, id);
        if (rowsAffected > 0) {
            crudController.carrera = carrera;
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
        limpiarVista();
    }
    
    public void modificarDecanato() {
//        Carrera carrera = crudController.carrera;
//
//        //datos que se van a actualizar
//        String id = crudController.crudFrame.getID();
//        String nombre = gestionarCrudFrame.first_textfield.getText();
//        String modalidad = gestionarCrudFrame.second_textfield.getText();
//        int duracion = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
//        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
//        Decanato decanatoSeleccionado = decanatos.get(selectedIndex - 1);
//        Decanato decanato = decanatoSeleccionado;
//
//        carrera.setNombre(nombre);
//        carrera.setDecanato(decanato);
//        carrera.setDuracion(duracion);
//        carrera.setModalidad(modalidad);
//
//        //consulta
//        int rowsAffected = connection.modificarCarrera(carrera, id);
//        if (rowsAffected > 0) {
//            crudController.carrera = carrera;
//            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
//        }
//        limpiarVista();
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
                    case "estudiante" ->
                        agregarEstudiante();
                    case "carrera" ->
                        agregarCarrera();
                    case "decanato" ->
                        agregarDecanato();
                    default ->
                        throw new AssertionError();
                }
            } else {
                switch (tipoCrud) {
                    case "profesor" ->
                        modificarProfesor();
                    case "universidad" ->
                        modificarUniversidad();
                    case "estudiante" ->
                        modificarEstudiante();
                    case "carrera" ->
                        modificarCarrera();
                    case "decanato" ->
                        modificarDecanato();
                    default ->
                        throw new AssertionError();
                }
                this.notifyObservers();
            }
        } else if (event.getSource() == gestionarCrudFrame.getLimpiar_campos_btn()) {
            limpiarVista();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para remover observadores
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método para notificar a los observadores
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
