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

    public Profesor profesor;
    public Universidad universidad;
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

    public void showGestionarProfesorFrame(Profesor profesor) {
        
        System.out.println("es agregar: " + esAgregar + " profesor: " + profesor);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(gestionarCrudFrame);
        gestionarCrudFrame.setVisible(true);
        
        if (esAgregar) {
            gestionarCrudFrame.configurarRegistro();
        } else {
            rellenarDatos(profesor);
            gestionarCrudFrame.configurarModificacion();
        }
    }

    private void showProfesorFrame() {
        gestionarCrudFrame.setVisible(false);
        crudController.showCrudFrame();
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

    private void showUniversidadFrame() {
        gestionarCrudFrame.setVisible(false);
        crudController.showCrudFrame();
    }
    
    public void setCrudController(CrudController crudController) {
        this.crudController = crudController;
    }

    private void limpiarVista() {
        gestionarCrudFrame.nombre_prof_TextField.setText("Nombre");
        gestionarCrudFrame.correo_prof_TextField.setText("Correo");
        gestionarCrudFrame.edad_prof_TextField.setText("Edad");
        gestionarCrudFrame.cmb_sexo.setSelectedIndex(0);
        gestionarCrudFrame.especialidad_prof_TextField.setText("Especialidad");
    }

    public void rellenarDatos(Profesor profesor) {
        gestionarCrudFrame.nombre_prof_TextField.setText(profesor.getNombre());
        gestionarCrudFrame.correo_prof_TextField.setText(profesor.getCorreo());
        gestionarCrudFrame.edad_prof_TextField.setText(String.valueOf(profesor.getEdad()));
        gestionarCrudFrame.cmb_sexo.setSelectedIndex("Femenino".equals(profesor.getSexo()) ? 1 : 2);
        gestionarCrudFrame.especialidad_prof_TextField.setText(profesor.getEspecialidad());
    }
    
    public void rellenarDatosUniversidad(Universidad universidad) {
        gestionarCrudFrame.nombre_prof_TextField.setText(universidad.getNombre());
        gestionarCrudFrame.correo_prof_TextField.setVisible(false);
        gestionarCrudFrame.edad_prof_TextField.setVisible(false);
        gestionarCrudFrame.cmb_sexo.setVisible(false);
        gestionarCrudFrame.especialidad_prof_TextField.setVisible(false);
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
        String cedula = crudController.crudFrame.getCedula();
        String nombre_completo = gestionarCrudFrame.nombre_prof_TextField.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.edad_prof_TextField.getText());
        String correo = gestionarCrudFrame.correo_prof_TextField.getText();
        //combobox
        String sexo = (String) gestionarCrudFrame.cmb_sexo.getSelectedItem();
        System.out.println("Sexo " + sexo);
        String especialidad = gestionarCrudFrame.especialidad_prof_TextField.getText();

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
        String cedula = crudController.crudFrame.getCedula();
        String nombre_completo = gestionarCrudFrame.nombre_prof_TextField.getText();
        int edad = Integer.parseInt(gestionarCrudFrame.edad_prof_TextField.getText());
        String sexo = (String) gestionarCrudFrame.cmb_sexo.getSelectedItem();
        String especialidad = gestionarCrudFrame.especialidad_prof_TextField.getText();
        String correo = gestionarCrudFrame.correo_prof_TextField.getText();

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
        if (event.getSource() == gestionarCrudFrame.getBack_button()) {
            showProfesorFrame();
        } else if (event.getSource() == gestionarCrudFrame.getAgg_prof_Btn()) {
            if (esAgregar) {
                agregarProfesor();
            } else {
                modificarProfesor();
            }
        } else if (event.getSource() == gestionarCrudFrame.getLimpiar_prof_Btn()) {
            limpiarVista();
        }
    }
}
