/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.*;
import sql.ConexionSQL;
import util.CheckableCellEventListener;
import util.PantallaCompleta;
import views.RetirarMateriaFrame;


public class RetirarMateriaController implements ActionListener, CheckableCellEventListener {
    
    private static RetirarMateriaController instance;
    public ConexionSQL connection = new ConexionSQL();
    public InicioController inicioController;
    private InscripcionInfo info;
    public RetirarMateriaFrame retirarMateriaFrame;
    
    private RetirarMateriaController() {
        retirarMateriaFrame = new RetirarMateriaFrame(this);
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirarMateriaFrame);
        retirarMateriaFrame.setVisible(false);
    }

    public static RetirarMateriaController getInstance() {
        if (instance == null) {
            instance = new RetirarMateriaController();
        }
        return instance;
    }
    
     public void showRetirarMateriaFrame() {
        PantallaCompleta pantallaCompleta = new PantallaCompleta();
        pantallaCompleta.setPantallaCompleta(retirarMateriaFrame);
        
        retirarMateriaFrame.setVisible(true);
    }

    private void showInicioFrame() {
        retirarMateriaFrame.setVisible(false);
        inicioController.showInicioFrame();
    }

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public void setConnection(ConexionSQL conexion) {
        this.connection = conexion;
    }
    
    private void mostrarDatos() {
        if ("Cedula".equals(retirarMateriaFrame.getCedula()) || retirarMateriaFrame.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cedula", "Ten cuidado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        connection.getEstudiantes();
        this.info = connection.obtenerDatosDeInscripcion(retirarMateriaFrame.getCedula());

        System.out.println(info);
        if (info == null) {
            JOptionPane.showMessageDialog(null, "No existe ningun estudiante con esa cedula", "Lo sentimos", JOptionPane.ERROR_MESSAGE);
        }
         else {
            retirarMateriaFrame.setCarrera(info.getEstudiante().getCarrera().getNombre());
            retirarMateriaFrame.setCorreo(info.getEstudiante().getCorreo());
            retirarMateriaFrame.setEdad(String.valueOf(info.getEstudiante().getEdad()));
            retirarMateriaFrame.setNombre(info.getEstudiante().getNombre());
            retirarMateriaFrame.setSexo(info.getEstudiante().getSexo());
            retirarMateriaFrame.displayUI(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == retirarMateriaFrame.getBack_button()) {
            showInicioFrame();
        } else if (button.getSource() == retirarMateriaFrame.getCedula_button()) {
            mostrarDatos();
    }
    }
    @Override
    public void onCheckboxValueChanged(int row, boolean value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
