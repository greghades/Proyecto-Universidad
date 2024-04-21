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

import controllers.GestionarCrudController;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GestionarCrudFrame extends javax.swing.JFrame {

    public GestionarCrudController gestionarCrudController;

    public GestionarCrudFrame(GestionarCrudController controller) {
        this.gestionarCrudController = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        fourth_cmb.addActionListener(accion);
        carrera_cmb.addActionListener(accion);
        limpiar_campos_btn.addActionListener(accion);
        registrar_btn.addActionListener(accion);
    }

    public void setupComboBox(List<String> opciones, boolean isFourthCmb) {
        if (isFourthCmb) {
            fourth_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
        } else {
            carrera_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
        }
    }

    public void configurarRegistro() {
        registrar_btn.setText("Realizar registro");
        instruction_title_label.setText("Llena todos los campos");
        title_label.setText("Registro");
    }

    public void configurarModificacion() {
        registrar_btn.setText("Aplicar cambios");
        instruction_title_label.setText("Edita los campos necesarios");
        title_label.setText("Modificación");
    }

    public JButton getRegistrar_btn() {
        return registrar_btn;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getLimpiar_campos_btn() {
        return limpiar_campos_btn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        main_body_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        instruction_title_label = new javax.swing.JLabel();
        fields_panel = new javax.swing.JPanel();
        first_label = new javax.swing.JLabel();
        first_textfield = new javax.swing.JTextField();
        second_label = new javax.swing.JLabel();
        second_textfield = new javax.swing.JTextField();
        third_label = new javax.swing.JLabel();
        third_textfield = new javax.swing.JTextField();
        carrera_cmb = new javax.swing.JComboBox<>();
        carrera_label = new javax.swing.JLabel();
        fifth_label = new javax.swing.JLabel();
        fifth_textfield = new javax.swing.JTextField();
        fourth_cmb = new javax.swing.JComboBox<>();
        fourth_label1 = new javax.swing.JLabel();
        cedula_label = new javax.swing.JLabel();
        cedula_textfield = new javax.swing.JTextField();
        opciones_buttons_panel = new javax.swing.JPanel();
        registrar_btn = new javax.swing.JButton();
        limpiar_campos_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(242, 242, 242));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Gestionar");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("<Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(90, 90, 90))
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
                        .addComponent(title_label)))
                .addGap(16, 16, 16))
        );

        main_body_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0};
        jPanel1Layout.rowHeights = new int[] {0, 16, 0, 16, 0};
        jPanel1.setLayout(jPanel1Layout);

        instruction_title_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        instruction_title_label.setForeground(new java.awt.Color(58, 159, 220));
        instruction_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instruction_title_label.setText("Edita los campos");
        instruction_title_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        instruction_title_label.setPreferredSize(new java.awt.Dimension(53, 40));
        instruction_title_label.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(instruction_title_label, gridBagConstraints);

        fields_panel.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 16, 0};
        jPanel2Layout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
        fields_panel.setLayout(jPanel2Layout);

        first_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        first_label.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(first_label, gridBagConstraints);

        first_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        first_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        first_textfield.setText("Nombre");
        first_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(first_textfield, gridBagConstraints);

        second_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        second_label.setText("Correo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(second_label, gridBagConstraints);

        second_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        second_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        second_textfield.setText("Correo");
        second_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(second_textfield, gridBagConstraints);

        third_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        third_label.setText("Edad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(third_label, gridBagConstraints);

        third_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        third_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        third_textfield.setText("Edad");
        third_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(third_textfield, gridBagConstraints);

        carrera_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        carrera_cmb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        carrera_cmb.setMaximumSize(new java.awt.Dimension(32767, 80));
        carrera_cmb.setMinimumSize(new java.awt.Dimension(214, 80));
        carrera_cmb.setPreferredSize(new java.awt.Dimension(214, 32));
        carrera_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrera_cmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(carrera_cmb, gridBagConstraints);

        carrera_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        carrera_label.setText("Carrera:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(carrera_label, gridBagConstraints);

        fifth_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fifth_label.setText("Especialidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(fifth_label, gridBagConstraints);

        fifth_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        fifth_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fifth_textfield.setText("Especialidad");
        fifth_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(fifth_textfield, gridBagConstraints);

        fourth_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        fourth_cmb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        fourth_cmb.setMaximumSize(new java.awt.Dimension(32767, 80));
        fourth_cmb.setMinimumSize(new java.awt.Dimension(214, 80));
        fourth_cmb.setPreferredSize(new java.awt.Dimension(214, 32));
        fourth_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourth_cmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(fourth_cmb, gridBagConstraints);

        fourth_label1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fourth_label1.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(fourth_label1, gridBagConstraints);

        cedula_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cedula_label.setText("Cedula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(cedula_label, gridBagConstraints);

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("Cedula");
        cedula_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(cedula_textfield, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(fields_panel, gridBagConstraints);

        opciones_buttons_panel.setBackground(new java.awt.Color(255, 255, 255));
        opciones_buttons_panel.setPreferredSize(new java.awt.Dimension(276, 32));
        opciones_buttons_panel.setRequestFocusEnabled(false);
        java.awt.GridBagLayout opciones_prof_PanelLayout = new java.awt.GridBagLayout();
        opciones_prof_PanelLayout.columnWidths = new int[] {0, 16, 0};
        opciones_prof_PanelLayout.rowHeights = new int[] {0};
        opciones_buttons_panel.setLayout(opciones_prof_PanelLayout);

        registrar_btn.setBackground(new java.awt.Color(58, 159, 220));
        registrar_btn.setForeground(new java.awt.Color(255, 255, 255));
        registrar_btn.setText("Registrar profesor");
        registrar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        registrar_btn.setMaximumSize(new java.awt.Dimension(80, 20));
        registrar_btn.setPreferredSize(new java.awt.Dimension(80, 20));
        registrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        opciones_buttons_panel.add(registrar_btn, gridBagConstraints);

        limpiar_campos_btn.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_campos_btn.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_campos_btn.setText("Limpiar");
        limpiar_campos_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        limpiar_campos_btn.setPreferredSize(new java.awt.Dimension(80, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        opciones_buttons_panel.add(limpiar_campos_btn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 48;
        jPanel1.add(opciones_buttons_panel, gridBagConstraints);

        javax.swing.GroupLayout main_body_panelLayout = new javax.swing.GroupLayout(main_body_panel);
        main_body_panel.setLayout(main_body_panelLayout);
        main_body_panelLayout.setHorizontalGroup(
            main_body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_body_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        main_body_panelLayout.setVerticalGroup(
            main_body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_body_panelLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(main_body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carrera_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrera_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carrera_cmbActionPerformed

    private void registrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrar_btnActionPerformed

    private void fourth_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourth_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fourth_cmbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    public javax.swing.JComboBox<Object> carrera_cmb;
    public javax.swing.JLabel carrera_label;
    public javax.swing.JLabel cedula_label;
    public javax.swing.JTextField cedula_textfield;
    private javax.swing.JPanel fields_panel;
    public javax.swing.JLabel fifth_label;
    public javax.swing.JTextField fifth_textfield;
    private javax.swing.JLabel first_label;
    public javax.swing.JTextField first_textfield;
    public javax.swing.JComboBox<Object> fourth_cmb;
    private javax.swing.JLabel fourth_label1;
    private javax.swing.JLabel instruction_title_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar_campos_btn;
    private javax.swing.JPanel main_body_panel;
    private javax.swing.JPanel opciones_buttons_panel;
    private javax.swing.JButton registrar_btn;
    private javax.swing.JLabel second_label;
    public javax.swing.JTextField second_textfield;
    private javax.swing.JLabel third_label;
    public javax.swing.JTextField third_textfield;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
