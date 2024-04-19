/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import models.Profesor;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.GestionarProfesorFrame;

public class GestionarProfesorController implements ActionListener {

    public Profesor profesor;
    private static GestionarProfesorController instance;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public GestionarProfesorFrame gestionarProfesorFrame;
    public ProfesorController profesorController;
    public boolean esAgregar;
    //para el combobox del sexo
    private final List<String> opcionSexo = Arrays.asList(
            "Seleccionar ",
            "Femenino",
            "Masculino"
    );

    public GestionarProfesorController() {
        gestionarProfesorFrame = new GestionarProfesorFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarProfesorFrame);
        gestionarProfesorFrame.setVisible(false);
        gestionarProfesorFrame.setupComboBox(opcionSexo);
    }

    public static GestionarProfesorController getInstance() {
        if (instance == null) {
            instance = new GestionarProfesorController();
        }
        return instance;
    }

    public void showGestionarProfesorFrame(Profesor profesor) {
        
        System.out.println("es agregar: " + esAgregar + " profesor: " + profesor);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarProfesorFrame);
        gestionarProfesorFrame.setVisible(true);
        
        if (esAgregar) {
            gestionarProfesorFrame.configurarRegistro();
        } else {
            rellenarDatos(profesor);
            gestionarProfesorFrame.configurarModificacion();
        }
    }

    private void showProfesorFrame() {
        gestionarProfesorFrame.setVisible(false);
        profesorController.showProfesorFrame();
    }

    public void setProfesorController(ProfesorController profesorController) {
        this.profesorController = profesorController;
    }

    private void limpiarVista() {
        gestionarProfesorFrame.nombre_prof_TextField.setText("Nombre");
        gestionarProfesorFrame.correo_prof_TextField.setText("Correo");
        gestionarProfesorFrame.edad_prof_TextField.setText("Edad");
        gestionarProfesorFrame.cmb_sexo.setSelectedIndex(0);
        gestionarProfesorFrame.especialidad_prof_TextField.setText("Especialidad");
    }

    public void rellenarDatos(Profesor profesor) {
        gestionarProfesorFrame.nombre_prof_TextField.setText(profesor.getNombre());
        gestionarProfesorFrame.correo_prof_TextField.setText(profesor.getCorreo());
        gestionarProfesorFrame.edad_prof_TextField.setText(String.valueOf(profesor.getEdad()));
        gestionarProfesorFrame.cmb_sexo.setSelectedIndex("Femenino".equals(profesor.getSexo()) ? 1 : 2);
        gestionarProfesorFrame.especialidad_prof_TextField.setText(profesor.getEspecialidad());
    }

    private void showSuccessAlert(boolean exitosa) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                exitosa ? "¡Las notas han sido actualizadas exitosamente!" : "No se pudieron actualizar las notas correctamente",
                exitosa ? "Felicidades" : "Ha ocurrido un error",
                JOptionPane.OK_OPTION,
                exitosa ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION && exitosa) {
            showProfesorFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }

    }

    //agregar
    public void agregarProfesor() {
        //obtener los datos del formulario 
        String cedula = profesorController.profesorFrame.getCedula();
        String nombre_completo = gestionarProfesorFrame.nombre_prof_TextField.getText();
        int edad = Integer.parseInt(gestionarProfesorFrame.edad_prof_TextField.getText());
        String correo = gestionarProfesorFrame.correo_prof_TextField.getText();
        //combobox
        String sexo = (String) gestionarProfesorFrame.cmb_sexo.getSelectedItem();
        System.out.println("Sexo " + sexo);
        String especialidad = gestionarProfesorFrame.especialidad_prof_TextField.getText();

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
            showSuccessAlert(true);
        } else {
            showSuccessAlert(false);
        }
        limpiarVista();
    }

    //modificar
    public void modificarProfesor() {
        //datos que se van a actualizar
        String cedula = profesorController.profesorFrame.getCedula();
        String nombre_completo = gestionarProfesorFrame.nombre_prof_TextField.getText();
        int edad = Integer.parseInt(gestionarProfesorFrame.edad_prof_TextField.getText());
        String sexo = (String) gestionarProfesorFrame.cmb_sexo.getSelectedItem();
        String especialidad = gestionarProfesorFrame.especialidad_prof_TextField.getText();
        String correo = gestionarProfesorFrame.correo_prof_TextField.getText();

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

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gestionarProfesorFrame.getBack_button()) {
            showProfesorFrame();
        } else if (event.getSource() == gestionarProfesorFrame.getAgg_prof_Btn()) {
            if (esAgregar) {
                agregarProfesor();
            } else {
                modificarProfesor();
            }
        } else if (event.getSource() == gestionarProfesorFrame.getLimpiar_prof_Btn()) {
            limpiarVista();
        }
    }
}
