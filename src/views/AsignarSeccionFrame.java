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

import controllers.AsignarSeccionController;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AsignarSeccionFrame extends javax.swing.JFrame {
    
    public AsignarSeccionController asignarSeccionController;
    
    public AsignarSeccionFrame(AsignarSeccionController controller) {
        this.asignarSeccionController = controller;
        initComponents();
        agregarListener(controller);
    }
    
    private void agregarListener(ActionListener accion) {
        botonBean2.addActionListener(accion);
        profesor_cmb.addActionListener(accion);
        asignatura_cmb.addActionListener(accion);
        seccion_cmb.addActionListener(accion);
        limpiar_campos_btn.addActionListener(accion);
        asignar_btn.addActionListener(accion);
    }
    
    public void setupComboBox(List<String> opciones, String tipo) {
        switch (tipo) {
            case "asignatura" -> {
                asignatura_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
            }
            case "seccion" -> {
                seccion_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
            }
            case "profesor" -> {
                profesor_cmb.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
            }
        }
    }
    
    public void configurarContenidoPorPaso(int paso) {
        switch (paso) {
            case 0 -> {
                asignar_btn.setVisible(false);
                limpiar_campos_btn.setVisible(false);
                asignatura_label.setVisible(false);
                asignatura_cmb.setVisible(false);
                seccion_label.setVisible(false);
                seccion_cmb.setVisible(false);
            }
            case 1 -> {
                limpiar_campos_btn.setVisible(true);
                asignatura_label.setVisible(true);
                asignatura_cmb.setVisible(true);
                seccion_label.setVisible(false);
                seccion_cmb.setVisible(false);
                asignatura_cmb.setSelectedIndex(0);
            }
            case 2 -> {
                seccion_label.setVisible(true);
                seccion_cmb.setVisible(true);
            }
            case 3 -> {
                asignar_btn.setVisible(true);
            }
        }
    }
    
    public void limpiarVista() {
        asignar_btn.setVisible(false);
        limpiar_campos_btn.setVisible(false);
        asignatura_label.setVisible(false);
        asignatura_cmb.setVisible(false);
        seccion_label.setVisible(false);
        seccion_cmb.setVisible(false);
        profesor_cmb.setSelectedIndex(0);
        asignatura_cmb.setSelectedIndex(0);
    }
    
    public JButton getAsignar_btn() {
        return asignar_btn;
    }
    
    public JComboBox<Object> getAsignatura_cmb() {
        return asignatura_cmb;
    }
    
    public JButton getBack_button() {
        return botonBean2;
    }
    
    public JComboBox<Object> getProfesor_cmb() {
        return profesor_cmb;
    }
    
    public JComboBox<Object> getSeccion_cmb() {
        return seccion_cmb;
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
        botonBean2 = new ComponenteBean.BotonBean();
        main_body_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        instruction_title_label = new javax.swing.JLabel();
        fields_panel = new javax.swing.JPanel();
        profesor_label = new javax.swing.JLabel();
        profesor_cmb = new javax.swing.JComboBox<>();
        asignatura_label = new javax.swing.JLabel();
        asignatura_cmb = new javax.swing.JComboBox<>();
        seccion_label = new javax.swing.JLabel();
        seccion_cmb = new javax.swing.JComboBox<>();
        opciones_buttons_panel = new javax.swing.JPanel();
        asignar_btn = new javax.swing.JButton();
        limpiar_campos_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(242, 242, 242));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Asignar sección");

        botonBean2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        botonBean2.setForeground(new java.awt.Color(59, 158, 220));
        botonBean2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonBean2.setMaximumSize(new java.awt.Dimension(59, 25));
        botonBean2.setMinimumSize(new java.awt.Dimension(59, 25));

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(botonBean2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBean2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_label))
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
        instruction_title_label.setText("Escoge un profesor");
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
        jPanel2Layout.rowHeights = new int[] {0, 8, 0, 8, 0};
        fields_panel.setLayout(jPanel2Layout);

        profesor_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        profesor_label.setText("Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(profesor_label, gridBagConstraints);

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
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(profesor_cmb, gridBagConstraints);

        asignatura_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        asignatura_label.setText("Asignatura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(asignatura_label, gridBagConstraints);

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        fields_panel.add(asignatura_cmb, gridBagConstraints);

        seccion_label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        seccion_label.setText("Seccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(seccion_label, gridBagConstraints);

        seccion_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        seccion_cmb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        seccion_cmb.setMaximumSize(new java.awt.Dimension(32767, 80));
        seccion_cmb.setMinimumSize(new java.awt.Dimension(214, 80));
        seccion_cmb.setPreferredSize(new java.awt.Dimension(214, 32));
        seccion_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seccion_cmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(seccion_cmb, gridBagConstraints);

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

        asignar_btn.setBackground(new java.awt.Color(58, 159, 220));
        asignar_btn.setForeground(new java.awt.Color(255, 255, 255));
        asignar_btn.setText("Asignar");
        asignar_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        asignar_btn.setMaximumSize(new java.awt.Dimension(80, 20));
        asignar_btn.setPreferredSize(new java.awt.Dimension(80, 20));
        asignar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        opciones_buttons_panel.add(asignar_btn, gridBagConstraints);

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
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
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

    private void seccion_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seccion_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seccion_cmbActionPerformed

    private void asignar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignar_btnActionPerformed

    private void asignatura_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignatura_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignatura_cmbActionPerformed

    private void profesor_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesor_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesor_cmbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignar_btn;
    public javax.swing.JComboBox<Object> asignatura_cmb;
    public javax.swing.JLabel asignatura_label;
    private ComponenteBean.BotonBean botonBean2;
    private javax.swing.JPanel fields_panel;
    private javax.swing.JLabel instruction_title_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar_campos_btn;
    private javax.swing.JPanel main_body_panel;
    private javax.swing.JPanel opciones_buttons_panel;
    public javax.swing.JComboBox<Object> profesor_cmb;
    public javax.swing.JLabel profesor_label;
    public javax.swing.JComboBox<Object> seccion_cmb;
    public javax.swing.JLabel seccion_label;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
