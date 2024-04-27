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

import controllers.CrudController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Carrera;
import models.Estudiante;
import models.Profesor;
import models.Universidad;

public class CrudFrame extends javax.swing.JFrame {

    public CrudController controller;

    public CrudFrame(CrudController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        //dejalo como backbutton
        botonBean1.addActionListener(accion);
        buscar_btn.addActionListener(accion);
        buscar_id_btn.addActionListener(accion);
        eliminar_btn.addActionListener(accion);
        modificar_btn.addActionListener(accion);
        reestablecer_btn.addActionListener(accion);
        registrar_btn.addActionListener(accion);
    }

    public void mostrarEstadoInicial() {
        id_panel.setVisible(false);
        info_container_panel.setVisible(false);
        reestablecer_btn.setVisible(false);
        registrar_btn.setVisible(true);
        buscar_btn.setVisible(true);
        configurarTextos();
    }

    private void configurarTextos() {
        String tipoCrud = controller.tipoCrud;
        String registroText, buscarText, modificarText, eliminarText, idText;
        if (tipoCrud.equals("universidad") || tipoCrud.equals("carrera")) {
            registroText = "Registrar una %s";
            buscarText = "Buscar una %s";
            modificarText = "Modificar datos de la %s";
            eliminarText = "Eliminar la %s";
            idText = "Ingresar ID de la %s";
        } else {
            registroText = "Registrar a un %s";
            buscarText = "Buscar a un %s";
            modificarText = "Modificar datos del %s";
            eliminarText = "Eliminar al %s";
            idText = "Ingresar ID del %s";
        }

        main_title_label.setText(String.format("Gestionar %s", tipoCrud));
        registrar_btn.setText(String.format(registroText, tipoCrud));
        buscar_btn.setText(String.format(buscarText, tipoCrud));
        modificar_btn.setText(String.format(modificarText, tipoCrud));
        eliminar_btn.setText(String.format(eliminarText, tipoCrud));
        question_title_label.setText("¿Qué quieres hacer?");
        ingresar_label.setText(String.format(idText, tipoCrud));
    }

    public void rellenarInfoProfesor(Profesor profesor) {
        first_crud_label.setText(profesor.getNombre());
        second_label.setText(profesor.getCorreo());
        third_label.setText(Integer.toString(profesor.getEdad()));
        fourth_label.setText(profesor.getSexo());
        fifth_label.setText(profesor.getEspecialidad());
        info_panel.setVisible(true);
    }
    
     public void rellenarInfoEstudiante(Estudiante estudiante) {
        first_crud_label.setText(estudiante.getNombre());
        second_label.setText(estudiante.getCorreo());
        third_label.setText(Integer.toString(estudiante.getEdad()));
        fourth_label.setText(estudiante.getSexo());
        fifth_title_label.setText("Carrera:");
        fifth_label.setText(estudiante.getCarrera().getNombre());
        info_panel.setVisible(true);
    }
     
     public void rellenarInfoUniversidad(Universidad universidad) {
        first_crud_label.setText(universidad.getNombre());
        second_label.setVisible(false);
        correo_prof_title_Label.setVisible(false);
        fifth_title_label.setVisible(false);
        genero_title_prof_Label.setText("Direccion: ");
        edad_title_prof_Label.setVisible(false);
        third_label.setVisible(false);
        fourth_label.setText(universidad.getDireccion());
        fifth_label.setVisible(false);
        info_panel.setVisible(true);
      
    }
      public void rellenarInfoCarrera(Carrera carrera) {
          first_crud_label.setText(carrera.getNombre());
          correo_prof_title_Label.setText("Decanato: ");
          second_label.setText(carrera.getDecanato().getNombre());
          genero_title_prof_Label.setText("Modalidad: ");
          fourth_label.setText(carrera.getModalidad());
          fifth_title_label.setText("Duracion: ");
          fifth_label.setText(Integer.toString(carrera.getDuracion()));
          edad_title_prof_Label.setVisible(false);
          third_label.setVisible(false);
          info_panel.setVisible(true);
      
    }
     
     
    public void mostrarEstadoInformacion() {
        info_container_panel.setVisible(true);
    }

    public void mostrarEstadoBuscar() {
        id_panel.setVisible(true);
        registrar_btn.setVisible(false);
        buscar_btn.setVisible(false);
        reestablecer_btn.setVisible(true);
        info_container_panel.setVisible(false);
        question_title_label.setText("Realiza tu búsqueda");
        id_textField.setText("ID");
    }

    public JPanel getId_panel() {
        return id_panel;
    }

    public JPanel getMain_body_panel() {
        return main_body_panel;
    }

    public JPanel getInfo_buttons_panel() {
        return info_buttons_panel;
    }

    public JPanel getInfo_panel() {
        return info_panel;
    }

    public JPanel getMain_buttons_panel() {
        return main_buttons_panel;
    }

    public JPanel getInfo_container_panel() {
        return info_container_panel;
    }

    public String getCedula() {
        return id_textField.getText();
    }

    public JButton getBack_button() {
        return botonBean1;
    }

    public JButton getBuscar_id_btn() {
        return buscar_id_btn;
    }

    public JButton getReestablecer_prof_Btn() {
        return reestablecer_btn;
    }

    public JButton getBuscar_btn() {
        return buscar_btn;
    }

    public JButton getEliminar_btn() {
        return eliminar_btn;
    }

    public JButton getModificar_btn() {
        return modificar_btn;
    }

    public JButton getReestablecer_btn() {
        return reestablecer_btn;
    }

    public JButton getRegistrar_btn() {
        return registrar_btn;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title_panel = new javax.swing.JPanel();
        main_title_label = new javax.swing.JLabel();
        botonBean1 = new ComponenteBean.BotonBean();
        main_body_panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        question_title_label = new javax.swing.JLabel();
        main_buttons_panel = new javax.swing.JPanel();
        registrar_btn = new javax.swing.JButton();
        buscar_btn = new javax.swing.JButton();
        reestablecer_btn = new javax.swing.JButton();
        id_panel = new javax.swing.JPanel();
        ingresar_label = new javax.swing.JLabel();
        id_textField = new javax.swing.JTextField();
        buscar_id_btn = new javax.swing.JButton();
        info_container_panel = new javax.swing.JPanel();
        info_panel = new javax.swing.JPanel();
        nombre_prof_title_Label = new javax.swing.JLabel();
        first_crud_label = new javax.swing.JLabel();
        correo_prof_title_Label = new javax.swing.JLabel();
        second_label = new javax.swing.JLabel();
        edad_title_prof_Label = new javax.swing.JLabel();
        third_label = new javax.swing.JLabel();
        genero_title_prof_Label = new javax.swing.JLabel();
        fourth_label = new javax.swing.JLabel();
        fifth_title_label = new javax.swing.JLabel();
        fifth_label = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        info_buttons_panel = new javax.swing.JPanel();
        modificar_btn = new javax.swing.JButton();
        eliminar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        main_title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        main_title_label.setForeground(new java.awt.Color(242, 242, 242));
        main_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        main_title_label.setText("Gestionar titulo");

        botonBean1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        botonBean1.setForeground(new java.awt.Color(58, 159, 220));
        botonBean1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonBean1.setMaximumSize(new java.awt.Dimension(59, 25));
        botonBean1.setMinimumSize(new java.awt.Dimension(59, 25));
        botonBean1.setPreferredSize(new java.awt.Dimension(59, 25));

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(main_title_label))
                .addGap(16, 16, 16))
        );

        botonBean1.getAccessibleContext().setAccessibleName("<Volver");

        main_body_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

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

        registrar_btn.setBackground(new java.awt.Color(58, 159, 220));
        registrar_btn.setForeground(new java.awt.Color(255, 255, 255));
        registrar_btn.setText("Registrar a un profesor");
        registrar_btn.setAlignmentX(1.0F);
        registrar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        registrar_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        registrar_btn.setMaximumSize(new java.awt.Dimension(500, 20));
        registrar_btn.setMinimumSize(new java.awt.Dimension(100, 20));
        registrar_btn.setPreferredSize(new java.awt.Dimension(156, 32));
        registrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_btnActionPerformed(evt);
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
        main_buttons_panel.add(registrar_btn, gridBagConstraints);

        buscar_btn.setBackground(new java.awt.Color(58, 159, 220));
        buscar_btn.setForeground(new java.awt.Color(255, 255, 255));
        buscar_btn.setText("Buscar a un profesor ");
        buscar_btn.setAlignmentX(1.0F);
        buscar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        buscar_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buscar_btn.setMaximumSize(new java.awt.Dimension(500, 20));
        buscar_btn.setMinimumSize(new java.awt.Dimension(100, 20));
        buscar_btn.setPreferredSize(new java.awt.Dimension(156, 32));
        buscar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btnActionPerformed(evt);
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
        main_buttons_panel.add(buscar_btn, gridBagConstraints);

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

        id_panel.setBackground(new java.awt.Color(255, 255, 255));

        ingresar_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ingresar_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar_label.setText("Ingresar ID del profesor");
        ingresar_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        id_textField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        id_textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_textField.setText("ID");
        id_textField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        buscar_id_btn.setBackground(new java.awt.Color(58, 159, 220));
        buscar_id_btn.setForeground(new java.awt.Color(255, 255, 255));
        buscar_id_btn.setText("Buscar");
        buscar_id_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        buscar_id_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_id_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout id_panelLayout = new javax.swing.GroupLayout(id_panel);
        id_panel.setLayout(id_panelLayout);
        id_panelLayout.setHorizontalGroup(
            id_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, id_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(id_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresar_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(id_panelLayout.createSequentialGroup()
                        .addComponent(id_textField)
                        .addGap(16, 16, 16)
                        .addComponent(buscar_id_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        id_panelLayout.setVerticalGroup(
            id_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(id_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ingresar_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(id_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_id_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(id_panel, gridBagConstraints);

        info_container_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_container_panel.setLayout(new javax.swing.BoxLayout(info_container_panel, javax.swing.BoxLayout.Y_AXIS));

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        info_panel.setPreferredSize(new java.awt.Dimension(400, 120));

        nombre_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_prof_title_Label.setText("Nombre:");

        first_crud_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        first_crud_label.setText("Nombre Profesor");

        correo_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_prof_title_Label.setText("Correo:");

        second_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        second_label.setText("Correo Profesor");

        edad_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_prof_Label.setText("Edad:");

        third_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        third_label.setText("Edad Profesor");

        genero_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        genero_title_prof_Label.setText("Género:");

        fourth_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fourth_label.setText("Género Profesor");

        fifth_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fifth_title_label.setText("Especialidad:");

        fifth_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fifth_label.setText("Especialidad Profesor");

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(first_crud_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fourth_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genero_title_prof_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(fifth_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(fifth_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(second_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(correo_prof_title_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(third_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad_title_prof_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_title_Label)
                    .addComponent(correo_prof_title_Label)
                    .addComponent(edad_title_prof_Label))
                .addGap(6, 6, 6)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_crud_label)
                    .addComponent(second_label)
                    .addComponent(third_label))
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_title_prof_Label)
                    .addComponent(fifth_title_label))
                .addGap(6, 6, 6)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fourth_label)
                    .addComponent(fifth_label))
                .addGap(16, 16, 16))
        );

        info_container_panel.add(info_panel);

        filler4.setBackground(new java.awt.Color(255, 255, 255));
        info_container_panel.add(filler4);

        info_buttons_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_buttons_panel.setPreferredSize(new java.awt.Dimension(482, 32));
        java.awt.GridBagLayout info_buttons_panelLayout = new java.awt.GridBagLayout();
        info_buttons_panelLayout.columnWidths = new int[] {0, 16, 0};
        info_buttons_panelLayout.rowHeights = new int[] {0};
        info_buttons_panel.setLayout(info_buttons_panelLayout);

        modificar_btn.setBackground(new java.awt.Color(58, 159, 220));
        modificar_btn.setForeground(new java.awt.Color(255, 255, 255));
        modificar_btn.setText("Modificar datos del profesor");
        modificar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        modificar_btn.setPreferredSize(new java.awt.Dimension(150, 20));
        modificar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        info_buttons_panel.add(modificar_btn, gridBagConstraints);

        eliminar_btn.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_btn.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_btn.setText("Eliminar al profesor");
        eliminar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        eliminar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        info_buttons_panel.add(eliminar_btn, gridBagConstraints);

        info_container_panel.add(info_buttons_panel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(info_container_panel, gridBagConstraints);

        javax.swing.GroupLayout main_body_panelLayout = new javax.swing.GroupLayout(main_body_panel);
        main_body_panel.setLayout(main_body_panelLayout);
        main_body_panelLayout.setHorizontalGroup(
            main_body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_body_panelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        main_body_panelLayout.setVerticalGroup(
            main_body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_body_panelLayout.createSequentialGroup()
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
                    .addComponent(main_body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(main_body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_btnActionPerformed

    private void registrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrar_btnActionPerformed

    private void reestablecer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reestablecer_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reestablecer_btnActionPerformed

    private void buscar_id_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_id_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_id_btnActionPerformed

    private void modificar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_btnActionPerformed

    private void eliminar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminar_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComponenteBean.BotonBean botonBean1;
    private javax.swing.JButton buscar_btn;
    private javax.swing.JButton buscar_id_btn;
    private javax.swing.JLabel correo_prof_title_Label;
    private javax.swing.JLabel edad_title_prof_Label;
    private javax.swing.JButton eliminar_btn;
    private javax.swing.JLabel fifth_label;
    private javax.swing.JLabel fifth_title_label;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel first_crud_label;
    private javax.swing.JLabel fourth_label;
    private javax.swing.JLabel genero_title_prof_Label;
    private javax.swing.JPanel id_panel;
    public javax.swing.JTextField id_textField;
    private javax.swing.JPanel info_buttons_panel;
    private javax.swing.JPanel info_container_panel;
    private javax.swing.JPanel info_panel;
    private javax.swing.JLabel ingresar_label;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel main_body_panel;
    private javax.swing.JPanel main_buttons_panel;
    private javax.swing.JLabel main_title_label;
    private javax.swing.JButton modificar_btn;
    private javax.swing.JLabel nombre_prof_title_Label;
    private javax.swing.JLabel question_title_label;
    private javax.swing.JButton reestablecer_btn;
    private javax.swing.JButton registrar_btn;
    private javax.swing.JLabel second_label;
    private javax.swing.JLabel third_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
