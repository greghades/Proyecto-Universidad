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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Carrera;
import models.Estudiante;
import models.NotaEstudianteListModel;
import sql.ConexionSQL;
import util.PantallaCompleta;
import views.EstudianteFrame;

public class EstudianteController implements ActionListener {
    public Estudiante estudiante;
    private static EstudianteController instance;
    public EstudianteFrame estudianteFrame;
    public ConexionSQL connection = ConexionSQL.getInstance();
    public InicioController inicioController;
    //para el combobox del sexo
    private final List<String> opcionSexo = Arrays.asList(
            "Seleccionar ",
            "Femenino",
            "Masculino"
    );
    private ArrayList<Carrera>  carreras;

    public EstudianteController() {
        estudianteFrame = new EstudianteFrame(this); 
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(estudianteFrame);
        estudianteFrame.setVisible(false);
        estudianteFrame.setupComboBox(opcionSexo);
        mostrarCarreras();
        
    }

    public static EstudianteController getInstance() {
        if (instance == null) {
            instance = new EstudianteController();
        }
        return instance;
    }

    public void showEstudianteFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(estudianteFrame);
        estudianteFrame.setVisible(true);
        estudianteFrame.mostrarEstadoInicial();
    }

    private void showInicioFrame() {
        estudianteFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void mostrarCarreras(){      
        carreras = connection.getCarrera();
        estudianteFrame.cmb_carrera.removeAllItems(); //remover todos los elementos del combobox
        
        //recorrer el listado con todos sus datos
        for(int i = 0; i < carreras.size(); i++){
          estudianteFrame.cmb_carrera.addItem(carreras.get(i).getNombre()); //para que aparezca el nombre
        } 
   }

    public void agregarEstudiante(){
        //obtener el id de la carrera del combobox a partir de un indice
        int selectedIndex = estudianteFrame.cmb_carrera.getSelectedIndex();
        Carrera carreraSeleccionada = carreras.get(selectedIndex);

        // Obtener los datos del formulario 
        String cedula = estudianteFrame.cedula_textfield.getText();
        Carrera carrera = carreraSeleccionada;
        String nombre = estudianteFrame.nombre_textfield.getText() ;
        int edad = Integer.parseInt(estudianteFrame.edad_textfield.getText());
        String correo = estudianteFrame.correo_textfield.getText();
        //combobox de sexo opcion
        String sexo = (String) estudianteFrame.getCmb_sexo().getSelectedItem();
        System.out.println("Sexo " + sexo);
        System.out.println("Carrera " + carreraSeleccionada);
        
      // Crear un objeto Estudiante con los datos capturados
        Estudiante estudiante = new Estudiante(carrera, cedula, nombre, sexo, correo, edad, sexo);
        estudiante.setCedula(cedula);
        estudiante.setCarrera(carrera);
        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setCorreo(correo);
        estudiante.setSexo(sexo);
        
         int rowsAffected = connection.agregarEstudiante(estudiante);
               
         if(rowsAffected > 0){
              showSuccessAlert(true);
         }else{
             showSuccessAlert(false);
         }
    }
    
    //modificar
    public void modificarEstudiante(){
         //verificar el id del estudiante 
        if ("Cedula".equals(estudianteFrame.getCedula()) || estudianteFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //traer los datos que ya se han guardado 
        
        
        //Nuevos datos que se van a actualizar 
        int selectedIndex = estudianteFrame.cmb_carrera.getSelectedIndex();
        Carrera carreraSeleccionada = carreras.get(selectedIndex);
        Carrera carrera = carreraSeleccionada;
        String cedula = estudianteFrame.getCedula();
        String nombre = estudianteFrame.nombre_textfield.getText() ;
        int edad = Integer.parseInt(estudianteFrame.edad_textfield.getText());
        String correo = estudianteFrame.correo_textfield.getText();
        String sexo = (String) estudianteFrame.getCmb_sexo().getSelectedItem();
        
        estudiante.setCarrera(carrera);
        estudiante.setNombre(nombre);
        estudiante.setEdad(edad);
        estudiante.setCorreo(correo);
        estudiante.setSexo(sexo);
        
        //consulta
         int rowsAffected = connection.modificarEstudiante(estudiante, cedula);
         if(rowsAffected > 0){
              JOptionPane.showMessageDialog(null, "Modificado exitosamente", "Felicidades", JOptionPane.ERROR_MESSAGE);
         }else{
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
         } 
    }
   
    
    //eliminar 
    public void eliminarEstudiante(){
         if ("Cedula".equals(estudianteFrame.getCedula()) || estudianteFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }
         
          int rowsAffected = connection.eliminarEstudiante(estudianteFrame.getCedula());
               
         if(rowsAffected > 0){
              JOptionPane.showMessageDialog(null, "Eliminado exitosamente", "Felicidades", JOptionPane.ERROR_MESSAGE);
         }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
         }      
    }
    
    //buscar
    public void mostrarDatos() {
        if ("Cedula".equals(estudianteFrame.getCedula()) || estudianteFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.estudiante = connection.buscarEstudiante(estudianteFrame.getCedula());
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con ese id", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        } else {
            estudianteFrame.rellenarInformacionInicial(estudiante);
        }
    }
    
    
    
       private void limpiar(){
         estudianteFrame.cedula_textfield.setText(null);
         estudianteFrame.cmb_carrera.setSelectedIndex(0);
         estudianteFrame.nombre_textfield.setText(null);
         estudianteFrame.correo_textfield.setText(null);
         estudianteFrame.edad_textfield.setText(null);
         estudianteFrame.cmb_sexo.setSelectedIndex(0);
    }
    
   

      private void showSuccessAlert(boolean exitosa) {
        Object[] options = {"Aceptar"};
        int selection = JOptionPane.showOptionDialog(
                null,
                exitosa ? "¡El estudiante sido actualizadas exitosamente!" : "No se pudo agregar el estudiante correctamente",
                exitosa ? "Felicidades" : "Ha ocurrido un error",
                JOptionPane.OK_OPTION,
                exitosa ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);

        if (selection == JOptionPane.OK_OPTION && exitosa) {
            showInicioFrame();
        } else {
            System.out.println("Selected Option Is X: " + selection);
        }
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == estudianteFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == estudianteFrame.getCedula_button()) {
            mostrarDatos();
        } else if (button.getSource() == estudianteFrame.getLimpiar_button()) {
            limpiar();
        }else if (button.getSource() == estudianteFrame.getAgregar_button()){
            //rellenarInformacionCmb();
            agregarEstudiante();
        } else if (button.getSource() == estudianteFrame.getEliminar_button()) {
            eliminarEstudiante();
        }else if (button.getSource() == estudianteFrame.getModificar_button()) {
           modificarEstudiante();
        }
    }
}
