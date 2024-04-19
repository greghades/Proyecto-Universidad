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

import controllers.ProfesorController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Profesor;

public class ProfesorFrame extends javax.swing.JFrame {

    public ProfesorController controller;

    public ProfesorFrame(ProfesorController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        //dejalo como backbutton
        back_button.addActionListener(accion);
        buscar_prof_btn.addActionListener(accion);
        cedula_profesor_btn.addActionListener(accion);
        eliminar_prof_btn.addActionListener(accion);
        modificar_prof_btn.addActionListener(accion);
        reestablecer_btn.addActionListener(accion);
        registrar_prof_btn.addActionListener(accion);
    }

    public void mostrarEstadoInicial() {
        ID_prof_Panel1.setVisible(false);
        profesor_info_container_panel.setVisible(false);
        reestablecer_btn.setVisible(false);
        registrar_prof_btn.setVisible(true);
        buscar_prof_btn.setVisible(true);
        question_title_label.setText("¿Qué quieres hacer?");
    }

    public void rellenarInfoInicial(Profesor profesor) {
        nombre_prof_label.setText(profesor.getNombre());
        correo_prof_label.setText(profesor.getCorreo());
        edad_prof_label.setText(Integer.toString(profesor.getEdad()));
        genero_prof_label.setText(profesor.getSexo());
        especialidad_prof_label.setText(profesor.getEspecialidad());
        info_prof_Panel.setVisible(true);
    }
    
    public void mostrarEstadoProfesorInfo() {
        profesor_info_container_panel.setVisible(true);
    }

    public void mostrarEstadoBuscar() {
        ID_prof_Panel1.setVisible(true);
        registrar_prof_btn.setVisible(false);
        buscar_prof_btn.setVisible(false);
        reestablecer_btn.setVisible(true);
        profesor_info_container_panel.setVisible(false);
        question_title_label.setText("Realiza tu búsqueda");
    }

    public JPanel getID_prof_Panel1() {
        return ID_prof_Panel1;
    }

    public JPanel getBody_prof_Panel() {
        return body_prof_Panel;
    }

    public JPanel getInfo_buttons_panel() {
        return info_buttons_panel;
    }

    public JPanel getInfo_prof_Panel() {
        return info_prof_Panel;
    }

    public JPanel getMain_buttons_panel() {
        return main_buttons_panel;
    }

    public JPanel getProfesor_info_container_panel() {
        return profesor_info_container_panel;
    }

    public String getCedula() {
        return cedula_prof_TextField.getText();
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getCedula_profesor_btn() {
        return cedula_profesor_btn;
    }

    public JButton getReestablecer_prof_Btn() {
        return reestablecer_btn;
    }

    public JButton getBuscar_prof_btn() {
        return buscar_prof_btn;
    }

    public JButton getEliminar_prof_btn() {
        return eliminar_prof_btn;
    }

    public JButton getModificar_prof_btn() {
        return modificar_prof_btn;
    }

    public JButton getReestablecer_btn() {
        return reestablecer_btn;
    }

    public JButton getRegistrar_prof_btn() {
        return registrar_prof_btn;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_prof_Panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        question_title_label = new javax.swing.JLabel();
        main_buttons_panel = new javax.swing.JPanel();
        registrar_prof_btn = new javax.swing.JButton();
        buscar_prof_btn = new javax.swing.JButton();
        reestablecer_btn = new javax.swing.JButton();
        ID_prof_Panel1 = new javax.swing.JPanel();
        ingresar_label = new javax.swing.JLabel();
        cedula_prof_TextField = new javax.swing.JTextField();
        cedula_profesor_btn = new javax.swing.JButton();
        profesor_info_container_panel = new javax.swing.JPanel();
        info_prof_Panel = new javax.swing.JPanel();
        nombre_prof_title_Label = new javax.swing.JLabel();
        nombre_prof_label = new javax.swing.JLabel();
        correo_prof_title_Label = new javax.swing.JLabel();
        correo_prof_label = new javax.swing.JLabel();
        edad_title_prof_Label = new javax.swing.JLabel();
        edad_prof_label = new javax.swing.JLabel();
        genero_title_prof_Label = new javax.swing.JLabel();
        genero_prof_label = new javax.swing.JLabel();
        especialidad_title_Label = new javax.swing.JLabel();
        especialidad_prof_label = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        info_buttons_panel = new javax.swing.JPanel();
        modificar_prof_btn = new javax.swing.JButton();
        eliminar_prof_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar profesor");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("<Volver");
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
                .addGap(8, 8, 8)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGroup(title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(title_panelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(title_panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addGap(16, 16, 16))
        );

        body_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        body_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        question_title_label.setBackground(new java.awt.Color(255, 255, 255));
        question_title_label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        question_title_label.setForeground(new java.awt.Color(58, 159, 220));
        question_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question_title_label.setText("¿Qué quieres hacer?");
        question_title_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        question_title_label.setPreferredSize(new java.awt.Dimension(53, 32));

        main_buttons_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_buttons_panel.setPreferredSize(new java.awt.Dimension(520, 32));
        java.awt.GridBagLayout main_buttons_panelLayout = new java.awt.GridBagLayout();
        main_buttons_panelLayout.columnWidths = new int[] {0, 16, 0};
        main_buttons_panelLayout.rowHeights = new int[] {0, 0, 0};
        main_buttons_panel.setLayout(main_buttons_panelLayout);

        registrar_prof_btn.setBackground(new java.awt.Color(58, 159, 220));
        registrar_prof_btn.setForeground(new java.awt.Color(255, 255, 255));
        registrar_prof_btn.setText("Registrar a un profesor");
        registrar_prof_btn.setAlignmentX(1.0F);
        registrar_prof_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        registrar_prof_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        registrar_prof_btn.setMaximumSize(new java.awt.Dimension(500, 20));
        registrar_prof_btn.setMinimumSize(new java.awt.Dimension(100, 20));
        registrar_prof_btn.setPreferredSize(new java.awt.Dimension(156, 32));
        registrar_prof_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_prof_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        main_buttons_panel.add(registrar_prof_btn, gridBagConstraints);

        buscar_prof_btn.setBackground(new java.awt.Color(58, 159, 220));
        buscar_prof_btn.setForeground(new java.awt.Color(255, 255, 255));
        buscar_prof_btn.setText("Buscar a un profesor ");
        buscar_prof_btn.setAlignmentX(1.0F);
        buscar_prof_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        buscar_prof_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buscar_prof_btn.setMaximumSize(new java.awt.Dimension(500, 20));
        buscar_prof_btn.setMinimumSize(new java.awt.Dimension(100, 20));
        buscar_prof_btn.setPreferredSize(new java.awt.Dimension(156, 32));
        buscar_prof_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_prof_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        main_buttons_panel.add(buscar_prof_btn, gridBagConstraints);

        reestablecer_btn.setBackground(new java.awt.Color(58, 159, 220));
        reestablecer_btn.setForeground(new java.awt.Color(255, 255, 255));
        reestablecer_btn.setText("Reestablecer opciones");
        reestablecer_btn.setAlignmentX(1.0F);
        reestablecer_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        reestablecer_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        reestablecer_btn.setMaximumSize(new java.awt.Dimension(500, 20));
        reestablecer_btn.setMinimumSize(new java.awt.Dimension(100, 20));
        reestablecer_btn.setPreferredSize(new java.awt.Dimension(156, 32));
        reestablecer_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reestablecer_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        main_buttons_panel.add(reestablecer_btn, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_buttons_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(question_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(question_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(main_buttons_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        jPanel3.add(jPanel2, gridBagConstraints);

        ID_prof_Panel1.setBackground(new java.awt.Color(255, 255, 255));

        ingresar_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ingresar_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar_label.setText("Ingresar ID del profesor");
        ingresar_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_prof_TextField.setText("ID");
        cedula_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_profesor_btn.setBackground(new java.awt.Color(58, 159, 220));
        cedula_profesor_btn.setForeground(new java.awt.Color(255, 255, 255));
        cedula_profesor_btn.setText("Buscar");
        cedula_profesor_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_profesor_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_profesor_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ID_prof_Panel1Layout = new javax.swing.GroupLayout(ID_prof_Panel1);
        ID_prof_Panel1.setLayout(ID_prof_Panel1Layout);
        ID_prof_Panel1Layout.setHorizontalGroup(
            ID_prof_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ID_prof_Panel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(ID_prof_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresar_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ID_prof_Panel1Layout.createSequentialGroup()
                        .addComponent(cedula_prof_TextField)
                        .addGap(16, 16, 16)
                        .addComponent(cedula_profesor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        ID_prof_Panel1Layout.setVerticalGroup(
            ID_prof_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ID_prof_Panel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ingresar_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(ID_prof_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_profesor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(ID_prof_Panel1, gridBagConstraints);

        profesor_info_container_panel.setBackground(new java.awt.Color(255, 255, 255));
        profesor_info_container_panel.setLayout(new javax.swing.BoxLayout(profesor_info_container_panel, javax.swing.BoxLayout.Y_AXIS));

        info_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        info_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        info_prof_Panel.setPreferredSize(new java.awt.Dimension(400, 120));

        nombre_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_prof_title_Label.setText("Nombre:");

        nombre_prof_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_prof_label.setText("Nombre Profesor");

        correo_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_prof_title_Label.setText("Correo:");

        correo_prof_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_prof_label.setText("Correo Profesor");

        edad_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_prof_Label.setText("Edad:");

        edad_prof_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_prof_label.setText("Edad Profesor");

        genero_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        genero_title_prof_Label.setText("Género:");

        genero_prof_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        genero_prof_label.setText("Género Profesor");

        especialidad_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        especialidad_title_Label.setText("Especialidad:");

        especialidad_prof_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        especialidad_prof_label.setText("Especialidad Profesor");

        javax.swing.GroupLayout info_prof_PanelLayout = new javax.swing.GroupLayout(info_prof_Panel);
        info_prof_Panel.setLayout(info_prof_PanelLayout);
        info_prof_PanelLayout.setHorizontalGroup(
            info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_prof_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genero_prof_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genero_title_prof_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_prof_PanelLayout.createSequentialGroup()
                        .addComponent(especialidad_prof_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(especialidad_title_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(correo_prof_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(correo_prof_title_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edad_prof_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad_title_prof_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        info_prof_PanelLayout.setVerticalGroup(
            info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_title_Label)
                    .addComponent(correo_prof_title_Label)
                    .addComponent(edad_title_prof_Label))
                .addGap(6, 6, 6)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_label)
                    .addComponent(correo_prof_label)
                    .addComponent(edad_prof_label))
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_title_prof_Label)
                    .addComponent(especialidad_title_Label))
                .addGap(6, 6, 6)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_prof_label)
                    .addComponent(especialidad_prof_label))
                .addGap(16, 16, 16))
        );

        profesor_info_container_panel.add(info_prof_Panel);

        filler4.setBackground(new java.awt.Color(255, 255, 255));
        profesor_info_container_panel.add(filler4);

        info_buttons_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_buttons_panel.setPreferredSize(new java.awt.Dimension(482, 32));
        java.awt.GridBagLayout info_buttons_panelLayout = new java.awt.GridBagLayout();
        info_buttons_panelLayout.columnWidths = new int[] {0, 16, 0};
        info_buttons_panelLayout.rowHeights = new int[] {0};
        info_buttons_panel.setLayout(info_buttons_panelLayout);

        modificar_prof_btn.setBackground(new java.awt.Color(58, 159, 220));
        modificar_prof_btn.setForeground(new java.awt.Color(255, 255, 255));
        modificar_prof_btn.setText("Modificar datos del profesor");
        modificar_prof_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        modificar_prof_btn.setPreferredSize(new java.awt.Dimension(150, 20));
        modificar_prof_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_prof_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        info_buttons_panel.add(modificar_prof_btn, gridBagConstraints);

        eliminar_prof_btn.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_prof_btn.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_prof_btn.setText("Eliminar al profesor");
        eliminar_prof_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        eliminar_prof_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_prof_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        info_buttons_panel.add(eliminar_prof_btn, gridBagConstraints);

        profesor_info_container_panel.add(info_buttons_panel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(profesor_info_container_panel, gridBagConstraints);

        javax.swing.GroupLayout body_prof_PanelLayout = new javax.swing.GroupLayout(body_prof_Panel);
        body_prof_Panel.setLayout(body_prof_PanelLayout);
        body_prof_PanelLayout.setHorizontalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_prof_PanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        body_prof_PanelLayout.setVerticalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonActionPerformed

    private void buscar_prof_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_prof_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_prof_btnActionPerformed

    private void registrar_prof_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_prof_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrar_prof_btnActionPerformed

    private void reestablecer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reestablecer_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reestablecer_btnActionPerformed

    private void cedula_profesor_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_profesor_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_profesor_btnActionPerformed

    private void modificar_prof_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_prof_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_prof_btnActionPerformed

    private void eliminar_prof_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_prof_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminar_prof_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ID_prof_Panel1;
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_prof_Panel;
    private javax.swing.JButton buscar_prof_btn;
    public javax.swing.JTextField cedula_prof_TextField;
    private javax.swing.JButton cedula_profesor_btn;
    private javax.swing.JLabel correo_prof_label;
    private javax.swing.JLabel correo_prof_title_Label;
    private javax.swing.JLabel edad_prof_label;
    private javax.swing.JLabel edad_title_prof_Label;
    private javax.swing.JButton eliminar_prof_btn;
    private javax.swing.JLabel especialidad_prof_label;
    private javax.swing.JLabel especialidad_title_Label;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel genero_prof_label;
    private javax.swing.JLabel genero_title_prof_Label;
    private javax.swing.JPanel info_buttons_panel;
    private javax.swing.JPanel info_prof_Panel;
    private javax.swing.JLabel ingresar_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel main_buttons_panel;
    private javax.swing.JButton modificar_prof_btn;
    private javax.swing.JLabel nombre_prof_label;
    private javax.swing.JLabel nombre_prof_title_Label;
    private javax.swing.JPanel profesor_info_container_panel;
    private javax.swing.JLabel question_title_label;
    private javax.swing.JButton reestablecer_btn;
    private javax.swing.JButton registrar_prof_btn;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
