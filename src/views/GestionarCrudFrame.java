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

    public GestionarCrudController gestionarProfesorControllerController;

    public GestionarCrudFrame(GestionarCrudController controller) {
        this.gestionarProfesorControllerController = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        cmb_sexo.addActionListener(accion);
        limpiar_prof_Btn.addActionListener(accion);
    }

    public void setupComboBox(List<String> opciones) {
        cmb_sexo.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
    }

    public void configurarRegistro() {
        agg_prof_Btn.setText("Realizar registro");
        instruction_title_label.setText("Llena todos los campos");
        title_label.setText("Registro");
    }
    
    public void configurarModificacion() {
        agg_prof_Btn.setText("Aplicar cambios");
        instruction_title_label.setText("Edita los campos necesarios");
        title_label.setText("Modificación");
    }

    public JButton getAgg_prof_Btn() {
        return agg_prof_Btn;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getLimpiar_prof_Btn() {
        return limpiar_prof_Btn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_prof_Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        instruction_title_label = new javax.swing.JLabel();
        fields_panel = new javax.swing.JPanel();
        nombre_prof_Label = new javax.swing.JLabel();
        nombre_prof_TextField = new javax.swing.JTextField();
        correo_prof_Label = new javax.swing.JLabel();
        correo_prof_TextField = new javax.swing.JTextField();
        edad_prof_Label = new javax.swing.JLabel();
        edad_prof_TextField = new javax.swing.JTextField();
        cmb_sexo = new javax.swing.JComboBox<>();
        sexo_prof_Label = new javax.swing.JLabel();
        especialidad_prof_Label = new javax.swing.JLabel();
        especialidad_prof_TextField = new javax.swing.JTextField();
        opciones_prof_Panel = new javax.swing.JPanel();
        agg_prof_Btn = new javax.swing.JButton();
        limpiar_prof_Btn = new javax.swing.JButton();

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

        body_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        body_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

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
        jPanel2Layout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0};
        fields_panel.setLayout(jPanel2Layout);

        nombre_prof_Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nombre_prof_Label.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(nombre_prof_Label, gridBagConstraints);

        nombre_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        nombre_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_prof_TextField.setText("Nombre");
        nombre_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(nombre_prof_TextField, gridBagConstraints);

        correo_prof_Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        correo_prof_Label.setText("Correo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(correo_prof_Label, gridBagConstraints);

        correo_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        correo_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo_prof_TextField.setText("Correo");
        correo_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(correo_prof_TextField, gridBagConstraints);

        edad_prof_Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        edad_prof_Label.setText("Edad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(edad_prof_Label, gridBagConstraints);

        edad_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        edad_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad_prof_TextField.setText("Edad");
        edad_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(edad_prof_TextField, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(cmb_sexo, gridBagConstraints);

        sexo_prof_Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sexo_prof_Label.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(sexo_prof_Label, gridBagConstraints);

        especialidad_prof_Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        especialidad_prof_Label.setText("Especialidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(especialidad_prof_Label, gridBagConstraints);

        especialidad_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        especialidad_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        especialidad_prof_TextField.setText("Especialidad");
        especialidad_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        fields_panel.add(especialidad_prof_TextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(fields_panel, gridBagConstraints);

        opciones_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        opciones_prof_Panel.setPreferredSize(new java.awt.Dimension(276, 32));
        opciones_prof_Panel.setRequestFocusEnabled(false);
        java.awt.GridBagLayout opciones_prof_PanelLayout = new java.awt.GridBagLayout();
        opciones_prof_PanelLayout.columnWidths = new int[] {0, 16, 0};
        opciones_prof_PanelLayout.rowHeights = new int[] {0};
        opciones_prof_Panel.setLayout(opciones_prof_PanelLayout);

        agg_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        agg_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        agg_prof_Btn.setText("Registrar profesor");
        agg_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        agg_prof_Btn.setMaximumSize(new java.awt.Dimension(80, 20));
        agg_prof_Btn.setPreferredSize(new java.awt.Dimension(80, 20));
        agg_prof_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agg_prof_BtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        opciones_prof_Panel.add(agg_prof_Btn, gridBagConstraints);

        limpiar_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_prof_Btn.setText("Limpiar");
        limpiar_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        limpiar_prof_Btn.setPreferredSize(new java.awt.Dimension(80, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        opciones_prof_Panel.add(limpiar_prof_Btn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 48;
        jPanel1.add(opciones_prof_Panel, gridBagConstraints);

        javax.swing.GroupLayout body_prof_PanelLayout = new javax.swing.GroupLayout(body_prof_Panel);
        body_prof_Panel.setLayout(body_prof_PanelLayout);
        body_prof_PanelLayout.setHorizontalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        body_prof_PanelLayout.setVerticalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_sexoActionPerformed

    private void agg_prof_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agg_prof_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agg_prof_BtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agg_prof_Btn;
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_prof_Panel;
    public javax.swing.JComboBox<Object> cmb_sexo;
    private javax.swing.JLabel correo_prof_Label;
    public javax.swing.JTextField correo_prof_TextField;
    private javax.swing.JLabel edad_prof_Label;
    public javax.swing.JTextField edad_prof_TextField;
    private javax.swing.JLabel especialidad_prof_Label;
    public javax.swing.JTextField especialidad_prof_TextField;
    private javax.swing.JPanel fields_panel;
    private javax.swing.JLabel instruction_title_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar_prof_Btn;
    private javax.swing.JLabel nombre_prof_Label;
    public javax.swing.JTextField nombre_prof_TextField;
    private javax.swing.JPanel opciones_prof_Panel;
    private javax.swing.JLabel sexo_prof_Label;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
