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

import java.awt.event.ActionListener;
import javax.swing.*;
import controllers.RetirarMateriaController;

public class RetirarMateriaFrame extends javax.swing.JFrame {

    public RetirarMateriaController controller;

    public RetirarMateriaFrame(RetirarMateriaController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;
        initComponents();
        displayUI(false);
        agregarListeners(controller);

    }

    public void displayUI(boolean should) {
        info_panel.setVisible(should);

    }

    private void agregarListeners(ActionListener accion) {
        cedula_button.addActionListener(accion);
        back_button.addActionListener(accion);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        info_panel = new javax.swing.JPanel();
        nombre_title_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        sex_title_label = new javax.swing.JLabel();
        sex_label = new javax.swing.JLabel();
        carrera_title_label = new javax.swing.JLabel();
        carrera_label = new javax.swing.JLabel();
        edad_title_label = new javax.swing.JLabel();
        edad_label = new javax.swing.JLabel();
        correo_title_label = new javax.swing.JLabel();
        correo_label = new javax.swing.JLabel();
        cedula_button = new javax.swing.JButton();
        cedula_textfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        materias_table = new javax.swing.JTable();
        title_panel = new javax.swing.JPanel();
        title_label2 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Retirar Asignatura");

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

        nombre_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_title_label.setText("Nombre Completo");
        nombre_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        nombre_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_label.setText("NombreEstudiante");
        nombre_label.setPreferredSize(new java.awt.Dimension(120, 32));

        sex_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sex_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sex_title_label.setText("Género");
        sex_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        sex_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sex_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sex_label.setText("GéneroEstudiante");
        sex_label.setPreferredSize(new java.awt.Dimension(120, 32));

        carrera_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        carrera_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carrera_title_label.setText("Carrera");
        carrera_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        carrera_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        carrera_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carrera_label.setText("CarreraEstudiante");
        carrera_label.setPreferredSize(new java.awt.Dimension(120, 32));

        edad_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_title_label.setText("Edad");
        edad_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        edad_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_label.setText("Edad");
        edad_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_title_label.setText("Correo");
        correo_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_label.setText("CorreoEstudiante");
        correo_label.setPreferredSize(new java.awt.Dimension(120, 32));

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(correo_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(correo_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edad_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sex_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carrera_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 104, Short.MAX_VALUE))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(edad_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sex_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correo_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        cedula_button.setBackground(new java.awt.Color(58, 159, 220));
        cedula_button.setForeground(new java.awt.Color(255, 255, 255));
        cedula_button.setText("Buscar");
        cedula_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_buttonActionPerformed(evt);
            }
        });

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("Cedula");
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

        jScrollPane1.setBorder(null);

        materias_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        materias_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Carga académica", "Inclusión", "Sección"
            }
        ));
        materias_table.setFocusable(false);
        materias_table.setGridColor(new java.awt.Color(37, 92, 125));
        materias_table.setRequestFocusEnabled(false);
        materias_table.setRowHeight(48);
        materias_table.setRowSelectionAllowed(false);
        materias_table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        materias_table.setShowGrid(true);
        materias_table.getTableHeader().setReorderingAllowed(false);
        materias_table.setUpdateSelectionOnSort(false);
        materias_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(materias_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(944, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 502, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(571, 571, 571))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(803, 94));
        title_panel.setLayout(new java.awt.BorderLayout());

        title_label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label2.setForeground(new java.awt.Color(255, 255, 255));
        title_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label2.setText("Retirar Materias");
        title_panel.add(title_label2, java.awt.BorderLayout.CENTER);

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("< Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        back_button.setRequestFocusEnabled(false);
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });
        title_panel.add(back_button, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed

    private void cedula_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_buttonActionPerformed

    }//GEN-LAST:event_cedula_buttonActionPerformed

    private void cedula_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_textfieldActionPerformed

    }//GEN-LAST:event_cedula_textfieldActionPerformed
    public void setCarrera(String text) {
        this.carrera_label.setText(text);
    }

    public void setCorreo(String text) {
        this.correo_label.setText(text);
    }

    public void setEdad(String text) {
        this.edad_label.setText(text);
    }

    public void setNombre(String text) {
        this.nombre_label.setText(text);
    }

    public void setSexo(String text) {
        this.sex_label.setText(text);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JLabel carrera_label;
    private javax.swing.JLabel carrera_title_label;
    private javax.swing.JButton cedula_button;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JLabel correo_label;
    private javax.swing.JLabel correo_title_label;
    private javax.swing.JLabel edad_label;
    private javax.swing.JLabel edad_title_label;
    private javax.swing.JPanel info_panel;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable materias_table;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nombre_title_label;
    private javax.swing.JLabel sex_label;
    private javax.swing.JLabel sex_title_label;
    private javax.swing.JLabel title_label2;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
