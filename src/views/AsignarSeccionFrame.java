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

public class AsignarSeccionFrame extends javax.swing.JFrame {

    public GestionarCrudController gestionarCrudController;

    public AsignarSeccionFrame(GestionarCrudController controller) {
        this.gestionarCrudController = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        asignatura_cmb.addActionListener(accion);
        carrera_cmb.addActionListener(accion);
        limpiar_campos_btn.addActionListener(accion);
        registrar_btn.addActionListener(accion);
    }

    public void setupComboBox(List<String> opciones, boolean isFourthCmb) {
        if (isFourthCmb) {
            asignatura_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
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
        carrera_cmb = new javax.swing.JComboBox<>();
        carrera_label = new javax.swing.JLabel();
        asignatura_label = new javax.swing.JLabel();
        profesor_label = new javax.swing.JLabel();
        asignatura_cmb = new javax.swing.JComboBox<>();
        profesor_cmb = new javax.swing.JComboBox<>();
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

        asignatura_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        asignatura_label.setText("Asignatura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(asignatura_label, gridBagConstraints);

        profesor_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        profesor_label.setText("Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(profesor_label, gridBagConstraints);

        asignatura_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        asignatura_cmb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        asignatura_cmb.setMaximumSize(new java.awt.Dimension(32767, 80));
        asignatura_cmb.setMinimumSize(new java.awt.Dimension(214, 80));
        asignatura_cmb.setPreferredSize(new java.awt.Dimension(214, 32));
        asignatura_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignatura_cmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        fields_panel.add(asignatura_cmb, gridBagConstraints);

        profesor_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        profesor_cmb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        profesor_cmb.setMaximumSize(new java.awt.Dimension(32767, 80));
        profesor_cmb.setMinimumSize(new java.awt.Dimension(214, 80));
        profesor_cmb.setPreferredSize(new java.awt.Dimension(214, 32));
        profesor_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesor_cmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(profesor_cmb, gridBagConstraints);

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
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
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

    private void asignatura_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignatura_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignatura_cmbActionPerformed

    private void profesor_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesor_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesor_cmbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Object> asignatura_cmb;
    public javax.swing.JLabel asignatura_label;
    private javax.swing.JButton back_button;
    public javax.swing.JComboBox<Object> carrera_cmb;
    public javax.swing.JLabel carrera_label;
    private javax.swing.JPanel fields_panel;
    private javax.swing.JLabel instruction_title_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar_campos_btn;
    private javax.swing.JPanel main_body_panel;
    private javax.swing.JPanel opciones_buttons_panel;
    public javax.swing.JComboBox<Object> profesor_cmb;
    public javax.swing.JLabel profesor_label;
    private javax.swing.JButton registrar_btn;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
