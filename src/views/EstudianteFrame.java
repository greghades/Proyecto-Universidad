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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import models.Carrera;
import models.Estudiante;
import models.Profesor;

public class EstudianteFrame extends javax.swing.JFrame {

    public EstudianteController controller;

    public EstudianteFrame(EstudianteController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        cedula_button.addActionListener(accion);
        limpiar_button.addActionListener(accion);
        agregar_button.addActionListener(accion);
        eliminar_button.addActionListener(accion);
        modificar_button.addActionListener(accion);
        
    }

    public void mostrarEstadoInicial() {
        info_panel.setVisible(false);
    }

    
//Para que se muestre la informacion que se esta buscando 
    public void rellenarInformacionInicial(Estudiante estudiante) {
        nombre_label.setText(estudiante.getNombre());
        carrera_label.setText(estudiante.getCarrera().toString());
        correo_label.setText(estudiante.getCorreo());
        edad_label.setText(Integer.toString(estudiante.getEdad()));
        sexo_label.setText(estudiante.getSexo());
        info_panel.setVisible(true);
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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        cedula_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        sexo_textfield = new javax.swing.JTextField();
        cedula_label = new javax.swing.JLabel();
        cedula_button = new javax.swing.JButton();
        nombre_textfield = new javax.swing.JTextField();
        correo_textfield = new javax.swing.JTextField();
        edad_textfield1 = new javax.swing.JTextField();
        carrera_textfield = new javax.swing.JTextField();
        info_panel = new javax.swing.JPanel();
        nombre_title_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        carrera_label = new javax.swing.JLabel();
        carrera_title_label = new javax.swing.JLabel();
        correo_title_label = new javax.swing.JLabel();
        correo_label = new javax.swing.JLabel();
        edad_title_label = new javax.swing.JLabel();
        edad_label = new javax.swing.JLabel();
        carrera_title_label2 = new javax.swing.JLabel();
        sexo_label = new javax.swing.JLabel();
        limpiar_button = new javax.swing.JButton();
        agregar_button = new javax.swing.JButton();
        modificar_button = new javax.swing.JButton();
        eliminar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(623, 94));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estudiante");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("< Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_panel.setBackground(new java.awt.Color(255, 255, 255));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("ID");
        cedula_textfield.setToolTipText("Introduce tu cedula");
        cedula_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        cedula_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        cedula_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        cedula_textfield.setName(""); // NOI18N
        cedula_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_textfieldActionPerformed(evt);
            }
        });

        sexo_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        sexo_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sexo_textfield.setText("Sexo");
        sexo_textfield.setToolTipText("Introduce tu cedula");
        sexo_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        sexo_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        sexo_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        sexo_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        sexo_textfield.setName(""); // NOI18N
        sexo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_textfieldActionPerformed(evt);
            }
        });

        cedula_label.setBackground(new java.awt.Color(255, 255, 255));
        cedula_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label.setText("Ingresar ID de Estudiante");
        cedula_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_label.setPreferredSize(new java.awt.Dimension(120, 32));

        cedula_button.setBackground(new java.awt.Color(58, 159, 220));
        cedula_button.setForeground(new java.awt.Color(255, 255, 255));
        cedula_button.setText("Buscar");
        cedula_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_buttonActionPerformed(evt);
            }
        });

        nombre_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        nombre_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_textfield.setText("Nombre");
        nombre_textfield.setToolTipText("Introduce tu cedula");
        nombre_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        nombre_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        nombre_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        nombre_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        nombre_textfield.setName(""); // NOI18N
        nombre_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_textfieldActionPerformed(evt);
            }
        });

        correo_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        correo_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo_textfield.setText("Correo");
        correo_textfield.setToolTipText("Introduce tu cedula");
        correo_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        correo_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        correo_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        correo_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        correo_textfield.setName(""); // NOI18N
        correo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo_textfieldActionPerformed(evt);
            }
        });

        edad_textfield1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        edad_textfield1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad_textfield1.setText("Edad");
        edad_textfield1.setToolTipText("Introduce tu cedula");
        edad_textfield1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        edad_textfield1.setMargin(new java.awt.Insets(8, 8, 8, 8));
        edad_textfield1.setMaximumSize(new java.awt.Dimension(100, 20));
        edad_textfield1.setMinimumSize(new java.awt.Dimension(100, 20));
        edad_textfield1.setName(""); // NOI18N
        edad_textfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edad_textfield1ActionPerformed(evt);
            }
        });

        carrera_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        carrera_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        carrera_textfield.setText("Carrera");
        carrera_textfield.setToolTipText("Introduce tu cedula");
        carrera_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        carrera_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        carrera_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        carrera_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        carrera_textfield.setName(""); // NOI18N
        carrera_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrera_textfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cedula_panelLayout = new javax.swing.GroupLayout(cedula_panel);
        cedula_panel.setLayout(cedula_panelLayout);
        cedula_panelLayout.setHorizontalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cedula_label, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(correo_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carrera_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad_textfield1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexo_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addComponent(cedula_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cedula_panelLayout.setVerticalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carrera_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(edad_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(sexo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

        nombre_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_title_label.setText("Nombre");
        nombre_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        nombre_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_label.setText("NombreEstudiante");
        nombre_label.setPreferredSize(new java.awt.Dimension(120, 32));

        carrera_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        carrera_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carrera_label.setText("CarreraEstudiante");
        carrera_label.setPreferredSize(new java.awt.Dimension(120, 32));

        carrera_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        carrera_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carrera_title_label.setText("Carrera");
        carrera_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_title_label.setText("Correo");
        correo_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_label.setText("CorreoEstudiante");
        correo_label.setPreferredSize(new java.awt.Dimension(120, 32));

        edad_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_title_label.setText("Edad");
        edad_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        edad_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_label.setText("edadEstudiante");
        edad_label.setPreferredSize(new java.awt.Dimension(120, 32));

        carrera_title_label2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        carrera_title_label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carrera_title_label2.setText("Sexo");
        carrera_title_label2.setPreferredSize(new java.awt.Dimension(120, 32));

        sexo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sexo_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sexo_label.setText("sexoEstudiante");
        sexo_label.setPreferredSize(new java.awt.Dimension(120, 32));

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(correo_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(correo_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edad_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombre_label, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(nombre_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(carrera_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(carrera_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carrera_title_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sexo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(correo_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(edad_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carrera_title_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        limpiar_button.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_button.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_button.setText("Limpiar");
        limpiar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        limpiar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_buttonActionPerformed(evt);
            }
        });

        agregar_button.setBackground(new java.awt.Color(58, 159, 220));
        agregar_button.setForeground(new java.awt.Color(255, 255, 255));
        agregar_button.setText("Agregar");
        agregar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        agregar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_buttonActionPerformed(evt);
            }
        });

        modificar_button.setBackground(new java.awt.Color(58, 159, 220));
        modificar_button.setForeground(new java.awt.Color(255, 255, 255));
        modificar_button.setText("Modificar");
        modificar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        modificar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_buttonActionPerformed(evt);
            }
        });

        eliminar_button.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_button.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_button.setText("Eliminar");
        eliminar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        eliminar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                        .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed

    private void cedula_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_textfieldActionPerformed

    }//GEN-LAST:event_cedula_textfieldActionPerformed

    private void cedula_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_buttonActionPerformed

    private void sexo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexo_textfieldActionPerformed

    private void carrera_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrera_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carrera_textfieldActionPerformed

    private void nombre_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_textfieldActionPerformed

    private void correo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo_textfieldActionPerformed

    private void edad_textfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edad_textfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edad_textfield1ActionPerformed

    private void limpiar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiar_buttonActionPerformed

    private void agregar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_buttonActionPerformed

    private void modificar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_buttonActionPerformed

    private void eliminar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminar_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_button;
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel carrera_label;
    public javax.swing.JTextField carrera_textfield;
    private javax.swing.JLabel carrera_title_label;
    private javax.swing.JLabel carrera_title_label2;
    private javax.swing.JButton cedula_button;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JPanel cedula_panel;
    public javax.swing.JTextField cedula_textfield;
    private javax.swing.JLabel correo_label;
    public javax.swing.JTextField correo_textfield;
    private javax.swing.JLabel correo_title_label;
    private javax.swing.JLabel edad_label;
    public javax.swing.JTextField edad_textfield1;
    private javax.swing.JLabel edad_title_label;
    private javax.swing.JButton eliminar_button;
    private javax.swing.JPanel info_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limpiar_button;
    private javax.swing.JButton modificar_button;
    private javax.swing.JLabel nombre_label;
    public javax.swing.JTextField nombre_textfield;
    private javax.swing.JLabel nombre_title_label;
    private javax.swing.JLabel sexo_label;
    public javax.swing.JTextField sexo_textfield;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
