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
import models.Estudiante;
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
    //combobox del sexo
    private final List<String> opcionSexo = Arrays.asList(
            "Seleccionar ",
            "Femenino",
            "Masculino"
    );
    //combobox carrera
    private ArrayList<Carrera> carreras;

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

    public void showGestionarProfesorFrame(Profesor profesor) {
        System.out.println("es agregar: " + esAgregar + " profesor: " + profesor + " tipo crud " + tipoCrud);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);
        mostrarEstadoInicial();

        if (esAgregar) {
            gestionarCrudFrame.configurarRegistro();
        } else {
            rellenarDatosProfesor(profesor);
            gestionarCrudFrame.configurarModificacion();
        }
    }

    public void showGestionarEstudianteFrame(Estudiante estudiante) {
        System.out.println("es agregar: " + esAgregar + " estudiante: " + estudiante + " tipo crud " + tipoCrud);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);
        mostrarCarreras();
        mostrarEstadoInicial();

        if (esAgregar) {
            gestionarCrudFrame.configurarRegistro();
        } else {
            rellenarDatosEstudiante(estudiante);
            gestionarCrudFrame.configurarModificacion();
        }
    }

    public void showGestionarUniversidadFrame(Universidad universidad) {

        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);

        if (esAgregar) {
            gestionarCrudFrame.configurarRegistro();
        } else {
            rellenarDatosUniversidad(universidad);
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
        gestionarCrudFrame.first_textfield.setText("Nombre");
        gestionarCrudFrame.second_textfield.setText("Correo");
        gestionarCrudFrame.third_textfield.setText("Edad");
        gestionarCrudFrame.carrera_cmb.setSelectedIndex(0);
        gestionarCrudFrame.fifth_textfield.setText("Especialidad");
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
        System.out.println("Estudiante rellenar datos" + estudiante);
    }

    public void rellenarDatosUniversidad(Universidad universidad) {
        gestionarCrudFrame.first_textfield.setText(universidad.getNombre());
        gestionarCrudFrame.second_textfield.setVisible(false);
        gestionarCrudFrame.third_textfield.setVisible(false);
        gestionarCrudFrame.carrera_cmb.setVisible(false);
        gestionarCrudFrame.fifth_textfield.setVisible(false);
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

    public void mostrarEstadoInicial() {
        System.out.println("tipo crud " + tipoCrud);
        if ("estudiante".equals(tipoCrud)) {
            gestionarCrudFrame.fifth_textfield.setVisible(false);
            gestionarCrudFrame.fifth_label.setVisible(false);
            gestionarCrudFrame.cedula_label.setVisible(true);
            gestionarCrudFrame.cedula_textfield.setVisible(true);
            gestionarCrudFrame.carrera_label.setVisible(true);
            gestionarCrudFrame.carrera_cmb.setVisible(true);
        } else if ("profesor".equals(tipoCrud)) {
            gestionarCrudFrame.fifth_textfield.setVisible(true);
            gestionarCrudFrame.fifth_label.setVisible(true);
            gestionarCrudFrame.cedula_label.setVisible(false);
            gestionarCrudFrame.cedula_textfield.setVisible(false);
            gestionarCrudFrame.carrera_label.setVisible(false);
            gestionarCrudFrame.carrera_cmb.setVisible(false);
        }
    }

    public boolean validarCampos() {
        String nombre = gestionarCrudFrame.first_textfield.getText();
        String edad = gestionarCrudFrame.third_textfield.getText();
        String correo = gestionarCrudFrame.second_textfield.getText();
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String especialidad = gestionarCrudFrame.fifth_textfield.getText();
        String cedula = gestionarCrudFrame.cedula_textfield.getText();
        String carrera = (String) gestionarCrudFrame.carrera_cmb.getSelectedItem();
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
        } else if ("estudiante".equals(tipoCrud)) {
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
        Carrera carreraSeleccionada = carreras.get(selectedIndex);
        Carrera carrera = carreraSeleccionada;

        //nuevos valores
        Estudiante nuevoEstudiante = new Estudiante(carrera, cedula, nombre_completo, " ", correo, edad, sexo);
        nuevoEstudiante.setCedula(cedula);
        nuevoEstudiante.setNombre(nombre_completo);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setCorreo(correo);
        nuevoEstudiante.setSexo(sexo);
        nuevoEstudiante.setCarrera(carrera);

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
    }

    public void modificarEstudiante() {

        Estudiante estudiante = crudController.estudiante;
        //datos del estudiante
        String cedula = crudController.crudFrame.getCedula();
        String nombre_completo = gestionarCrudFrame.first_textfield.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.third_textfield.getText());
        String sexo = (String) gestionarCrudFrame.fourth_cmb.getSelectedItem();
        String correo = gestionarCrudFrame.second_textfield.getText();
        //combobox carrera
        int selectedIndex = gestionarCrudFrame.carrera_cmb.getSelectedIndex();
        Carrera carreraSeleccionada = carreras.get(selectedIndex);
        Carrera carrera = carreraSeleccionada;

        estudiante.setNombre(nombre_completo);
        estudiante.setEdad(edad);
        estudiante.setCorreo(correo);
        estudiante.setSexo(sexo);
        estudiante.setCarrera(carrera);

        //consulta
        int rowsAffected = connection.modificarEstudiante(estudiante, cedula);

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Las modificaciones fueron realizadas exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
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
                if ("profesor".equals(tipoCrud)) {
                    agregarProfesor();
                } else if ("estudiante".equals(tipoCrud)) {
                    agregarEstudiante();
                }

            } else {
                if ("profesor".equals(tipoCrud)) {
                    modificarProfesor();
                } else if ("estudiante".equals(tipoCrud)) {
                    modificarEstudiante();
                }

            }
        } else if (event.getSource() == gestionarCrudFrame.getLimpiar_campos_btn()) {
            limpiarVista();
        }
    }
}
