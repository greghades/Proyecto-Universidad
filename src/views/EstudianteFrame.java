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
package views;

import controllers.AsignarNotaController;
import controllers.EstudianteController;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import models.Carrera;
import models.Estudiante;
import models.Profesor;
import sql.ConexionSQL;

public class EstudianteFrame extends javax.swing.JFrame {

    public EstudianteController controller;

     //controlador
    public EstudianteFrame(EstudianteController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
        cmb_sexo.setBackground(Color.white);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        cedula_button.addActionListener(accion);
        limpiar_button.addActionListener(accion);
        cmb_carrera.addActionListener(accion);
        agregar_button.addActionListener(accion);
        eliminar_button.addActionListener(accion);
        modificar_button.addActionListener(accion);
        cmb_sexo.addActionListener(accion); 
    }
    
// muestra el estado inicial de la interfaz
    public void mostrarEstadoInicial() {
        info_panel.setVisible(false);
        cedula_panel.setVisible(true);
        crud_panel.setVisible(true);
        opcion_panel.setVisible(true);
    }
    // el error esta que hay que cambiarlo para que traiga un string por si acaso a la larga me da error 
  public void setupComboBox(List<String> opciones) {
        cmb_sexo.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
    }
    
    public void rellenarInformacionInicial(Estudiante estudiante) {
        nombre_label.setText(estudiante.getNombre());
        //cambie a get nombre 
        carrera_label.setText(estudiante.getCarrera().getNombre());
        correo_label.setText(estudiante.getCorreo());
        edad_label.setText(Integer.toString(estudiante.getEdad()));
        sexo_label.setText(estudiante.getSexo());
        info_panel.setVisible(true);
        opcion_panel.setVisible(true);  
        crud_panel.setVisible(true);
    }    
    public void mostrarCrud(Estudiante estudiante){
         crud_panel.setVisible(true);
    }
    
    public String getCedula() {
        return cedula_textfield.getText();
  }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getCedula_button() {
        return cedula_button;
    }
    
    public JButton getLimpiar_button(){
        return limpiar_button;
    }

    public JButton getEliminar_button(){
        return eliminar_button;
    }
    
    public JButton getAgregar_button() {
        return agregar_button;
        
    }
    
    public JButton getModificar_button(){
        return modificar_button;
    }
    public JComboBox<Object> getCmb_carrera() {
        return cmb_carrera;
    }
    public JComboBox<Object> getCmb_sexo() {
        return cmb_sexo;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_prof_Panel = new javax.swing.JPanel();
        cedula_panel = new javax.swing.JPanel();
        ingresar_label = new javax.swing.JLabel();
        cedula_textfield = new javax.swing.JTextField();
        cedula_button = new javax.swing.JButton();
        crud_panel = new javax.swing.JPanel();
        nombre_est_Label = new javax.swing.JLabel();
        correo_est_Label = new javax.swing.JLabel();
        edad_est_Label = new javax.swing.JLabel();
        sexo_est_Label = new javax.swing.JLabel();
        carrera_est_Label = new javax.swing.JLabel();
        nombre_textfield = new javax.swing.JTextField();
        correo_textfield = new javax.swing.JTextField();
        edad_textfield = new javax.swing.JTextField();
        cmb_sexo = new javax.swing.JComboBox<>();
        cmb_carrera = new javax.swing.JComboBox<>();
        opcion_panel = new javax.swing.JPanel();
        agregar_button = new javax.swing.JButton();
        eliminar_button = new javax.swing.JButton();
        modificar_button = new javax.swing.JButton();
        limpiar_button = new javax.swing.JButton();
        info_panel = new javax.swing.JPanel();
        nombre_prof_title_Label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        correo_prof_title_Label = new javax.swing.JLabel();
        correo_label = new javax.swing.JLabel();
        edad_title_Label = new javax.swing.JLabel();
        edad_label = new javax.swing.JLabel();
        genero_title_prof_Label = new javax.swing.JLabel();
        sexo_label = new javax.swing.JLabel();
        especialidad_title_Label = new javax.swing.JLabel();
        carrera_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel4.setBackground(new java.awt.Color(58, 159, 220));
        title_panel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("ESTUDIANTE");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("<Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout title_panel4Layout = new javax.swing.GroupLayout(title_panel4);
        title_panel4.setLayout(title_panel4Layout);
        title_panel4Layout.setHorizontalGroup(
            title_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(340, 340, 340))
        );
        title_panel4Layout.setVerticalGroup(
            title_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panel4Layout.createSequentialGroup()
                .addGroup(title_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(title_panel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(title_panel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)))
                .addGap(35, 35, 35))
        );

        body_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        body_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_panel.setBackground(new java.awt.Color(255, 255, 255));

        ingresar_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ingresar_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar_label.setText("Ingresar ID del estudiante");
        ingresar_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("ID");
        cedula_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_button.setBackground(new java.awt.Color(58, 159, 220));
        cedula_button.setForeground(new java.awt.Color(255, 255, 255));
        cedula_button.setText("Buscar");
        cedula_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout cedula_panelLayout = new javax.swing.GroupLayout(cedula_panel);
        cedula_panel.setLayout(cedula_panelLayout);
        cedula_panelLayout.setHorizontalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedula_panelLayout.createSequentialGroup()
                        .addComponent(ingresar_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(cedula_panelLayout.createSequentialGroup()
                        .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        cedula_panelLayout.setVerticalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ingresar_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        crud_panel.setBackground(new java.awt.Color(255, 255, 255));

        nombre_est_Label.setText("Nombre:");

        correo_est_Label.setText("Correo:");

        edad_est_Label.setText("Edad:");

        sexo_est_Label.setText("Sexo:");

        carrera_est_Label.setText("Carrera");

        nombre_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        nombre_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_textfield.setText("Nombre");
        nombre_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        correo_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        correo_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo_textfield.setText("Correo");
        correo_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        edad_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        edad_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad_textfield.setText("Edad");
        edad_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cmb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cmb_sexo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cmb_sexo.setMaximumSize(new java.awt.Dimension(32767, 80));
        cmb_sexo.setMinimumSize(new java.awt.Dimension(214, 80));
        cmb_sexo.setPreferredSize(new java.awt.Dimension(214, 32));
        cmb_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_sexoActionPerformed(evt);
            }
        });

        cmb_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cmb_carrera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cmb_carrera.setMaximumSize(new java.awt.Dimension(32767, 80));
        cmb_carrera.setMinimumSize(new java.awt.Dimension(214, 80));
        cmb_carrera.setPreferredSize(new java.awt.Dimension(214, 32));
        cmb_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_carreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crud_panelLayout = new javax.swing.GroupLayout(crud_panel);
        crud_panel.setLayout(crud_panelLayout);
        crud_panelLayout.setHorizontalGroup(
            crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carrera_est_Label)
                    .addComponent(sexo_est_Label)
                    .addComponent(edad_est_Label)
                    .addComponent(correo_est_Label)
                    .addComponent(nombre_est_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_textfield)
                    .addComponent(correo_textfield)
                    .addComponent(edad_textfield)
                    .addComponent(cmb_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_carrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        crud_panelLayout.setVerticalGroup(
            crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_est_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_est_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edad_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_est_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_est_Label)
                    .addComponent(cmb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrera_est_Label))
                .addGap(16, 16, 16))
        );

        opcion_panel.setBackground(new java.awt.Color(255, 255, 255));

        agregar_button.setBackground(new java.awt.Color(58, 159, 220));
        agregar_button.setForeground(new java.awt.Color(255, 255, 255));
        agregar_button.setText("Agregar");
        agregar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        eliminar_button.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_button.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_button.setText("Eliminar");
        eliminar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        modificar_button.setBackground(new java.awt.Color(58, 159, 220));
        modificar_button.setForeground(new java.awt.Color(255, 255, 255));
        modificar_button.setText("Modificar");
        modificar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        limpiar_button.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_button.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_button.setText("Limpiar");
        limpiar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout opcion_panelLayout = new javax.swing.GroupLayout(opcion_panel);
        opcion_panel.setLayout(opcion_panelLayout);
        opcion_panelLayout.setHorizontalGroup(
            opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcion_panelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175)
                .addGroup(opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        opcion_panelLayout.setVerticalGroup(
            opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcion_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        nombre_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_prof_title_Label.setText("Nombre:");

        nombre_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_label.setText("Nombre Estudiante");

        correo_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_prof_title_Label.setText("Correo:");

        correo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_label.setText("Correo Estudiante");

        edad_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_Label.setText("Edad:");

        edad_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_label.setText("Edad Estudiante");

        genero_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        genero_title_prof_Label.setText("Género");

        sexo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sexo_label.setText("Género Estudiante");

        especialidad_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        especialidad_title_Label.setText("Carrera");

        carrera_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        carrera_label.setText("Carrera estudiante");

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(nombre_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sexo_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correo_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(correo_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(especialidad_title_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(genero_title_prof_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edad_title_Label)
                    .addComponent(edad_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_title_Label)
                    .addComponent(correo_prof_title_Label)
                    .addComponent(edad_title_Label))
                .addGap(6, 6, 6)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label)
                    .addComponent(correo_label)
                    .addComponent(edad_label))
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_title_prof_Label)
                    .addComponent(especialidad_title_Label))
                .addGap(6, 6, 6)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_label)
                    .addComponent(carrera_label))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout body_prof_PanelLayout = new javax.swing.GroupLayout(body_prof_Panel);
        body_prof_Panel.setLayout(body_prof_PanelLayout);
        body_prof_PanelLayout.setHorizontalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addGroup(body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, body_prof_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(crud_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcion_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        body_prof_PanelLayout.setVerticalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(crud_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(opcion_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_prof_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_carreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_carreraActionPerformed

    private void cmb_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_sexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_button;
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_prof_Panel;
    private javax.swing.JLabel carrera_est_Label;
    private javax.swing.JLabel carrera_label;
    private javax.swing.JButton cedula_button;
    private javax.swing.JPanel cedula_panel;
    public javax.swing.JTextField cedula_textfield;
    public javax.swing.JComboBox<Object> cmb_carrera;
    public javax.swing.JComboBox<Object> cmb_sexo;
    private javax.swing.JLabel correo_est_Label;
    private javax.swing.JLabel correo_label;
    private javax.swing.JLabel correo_prof_title_Label;
    public javax.swing.JTextField correo_textfield;
    private javax.swing.JPanel crud_panel;
    private javax.swing.JLabel edad_est_Label;
    private javax.swing.JLabel edad_label;
    public javax.swing.JTextField edad_textfield;
    private javax.swing.JLabel edad_title_Label;
    private javax.swing.JButton eliminar_button;
    private javax.swing.JLabel especialidad_title_Label;
    private javax.swing.JLabel genero_title_prof_Label;
    public javax.swing.JPanel info_panel;
    public javax.swing.JLabel ingresar_label;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton limpiar_button;
    private javax.swing.JButton modificar_button;
    private javax.swing.JLabel nombre_est_Label;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nombre_prof_title_Label;
    public javax.swing.JTextField nombre_textfield;
    private javax.swing.JPanel opcion_panel;
    private javax.swing.JLabel sexo_est_Label;
    private javax.swing.JLabel sexo_label;
    private javax.swing.JPanel title_panel4;
    // End of variables declaration//GEN-END:variables
}
