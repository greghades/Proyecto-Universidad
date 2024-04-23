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

import javax.swing.*;
import controllers.InicioController;
import java.awt.event.*;

public class InicioFrame extends javax.swing.JFrame {

    public InicioController controller; // Reference to the controller

    public InicioFrame(InicioController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;
        initComponents();
        agregarListeners(controller);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void agregarListeners(ActionListener accion) {
        inscripcion_button.addActionListener(accion);
        listado_seccion_button.addActionListener(accion);
        listado_estudiante_button.addActionListener(accion);
        retirar_materia_button.addActionListener(accion);
        asignar_nota_button.addActionListener(accion);
        estudiante_button.addActionListener(accion);
        profesor_button.addActionListener(accion);
        universidad_button.addActionListener(accion);
        asignar_seccion_button.addActionListener(accion);
    }

    public JButton getInscripcion_button() {
        return inscripcion_button;
    }

    public JButton getAsignar_nota_button() {
        return asignar_nota_button;
    }

    public JButton getListado_estudiante_button() {
        return listado_estudiante_button;
    }

    public JButton getListado_seccion_button() {
        return listado_seccion_button;
    }

    public JButton getRetirar_materia_button() {
        return retirar_materia_button;
    }

    public JButton getEstudiante_Button() {
        return estudiante_button;
    }

    public JButton getProfesor_Button() {
        return profesor_button;
    }

    public JButton getUniversidad_Button() {
        return universidad_button;
    }

    public JButton getAsignar_Seccion_Button() {
        return asignar_seccion_button;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title_panel = new javax.swing.JPanel();
        title_label2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        title_label3 = new javax.swing.JLabel();
        inscripcion_button = new javax.swing.JButton();
        listado_estudiante_button = new javax.swing.JButton();
        retirar_materia_button = new javax.swing.JButton();
        asignar_nota_button = new javax.swing.JButton();
        listado_seccion_button = new javax.swing.JButton();
        universidad_button = new javax.swing.JButton();
        profesor_button = new javax.swing.JButton();
        estudiante_button = new javax.swing.JButton();
        asignar_seccion_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(803, 94));
        title_panel.setLayout(new java.awt.BorderLayout());

        title_label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label2.setForeground(new java.awt.Color(255, 255, 255));
        title_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label2.setText("Sistema de gestion UCLA");
        title_panel.add(title_label2, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 16, 0, 16, 0, 16, 0};
        jPanel2Layout.rowHeights = new int[] {0, 16, 0, 16, 0, 16, 0, 16, 0};
        jPanel2.setLayout(jPanel2Layout);

        title_label3.setBackground(new java.awt.Color(153, 0, 51));
        title_label3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        title_label3.setForeground(new java.awt.Color(51, 51, 51));
        title_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label3.setText("Opciones disponibles");
        title_label3.setMaximumSize(new java.awt.Dimension(1000000, 28));
        title_label3.setMinimumSize(new java.awt.Dimension(624, 28));
        title_label3.setPreferredSize(new java.awt.Dimension(948, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(title_label3, gridBagConstraints);

        inscripcion_button.setBackground(new java.awt.Color(58, 159, 220));
        inscripcion_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inscripcion_button.setForeground(new java.awt.Color(255, 255, 255));
        inscripcion_button.setText("Inscribir estudiante");
        inscripcion_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        inscripcion_button.setPreferredSize(new java.awt.Dimension(300, 70));
        inscripcion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscripcion_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(inscripcion_button, gridBagConstraints);

        listado_estudiante_button.setBackground(new java.awt.Color(58, 159, 220));
        listado_estudiante_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        listado_estudiante_button.setForeground(new java.awt.Color(255, 255, 255));
        listado_estudiante_button.setText("Listados por estudiante");
        listado_estudiante_button.setActionCommand("");
        listado_estudiante_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        listado_estudiante_button.setPreferredSize(new java.awt.Dimension(300, 70));
        listado_estudiante_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listado_estudiante_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(listado_estudiante_button, gridBagConstraints);

        retirar_materia_button.setBackground(new java.awt.Color(58, 159, 220));
        retirar_materia_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        retirar_materia_button.setForeground(new java.awt.Color(255, 255, 255));
        retirar_materia_button.setText("Retirar materia");
        retirar_materia_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        retirar_materia_button.setPreferredSize(new java.awt.Dimension(300, 70));
        retirar_materia_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirar_materia_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(retirar_materia_button, gridBagConstraints);

        asignar_nota_button.setBackground(new java.awt.Color(58, 159, 220));
        asignar_nota_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        asignar_nota_button.setForeground(new java.awt.Color(255, 255, 255));
        asignar_nota_button.setText("Asignar nota estudiante");
        asignar_nota_button.setToolTipText("");
        asignar_nota_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        asignar_nota_button.setPreferredSize(new java.awt.Dimension(300, 70));
        asignar_nota_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_nota_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(asignar_nota_button, gridBagConstraints);

        listado_seccion_button.setBackground(new java.awt.Color(58, 159, 220));
        listado_seccion_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        listado_seccion_button.setForeground(new java.awt.Color(255, 255, 255));
        listado_seccion_button.setText("Listados por seccion");
        listado_seccion_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        listado_seccion_button.setPreferredSize(new java.awt.Dimension(300, 70));
        listado_seccion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listado_seccion_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(listado_seccion_button, gridBagConstraints);

        universidad_button.setBackground(new java.awt.Color(58, 159, 220));
        universidad_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        universidad_button.setForeground(new java.awt.Color(255, 255, 255));
        universidad_button.setText("Gestionar universidad");
        universidad_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        universidad_button.setPreferredSize(new java.awt.Dimension(300, 70));
        universidad_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universidad_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        jPanel2.add(universidad_button, gridBagConstraints);

        profesor_button.setBackground(new java.awt.Color(58, 159, 220));
        profesor_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        profesor_button.setForeground(new java.awt.Color(255, 255, 255));
        profesor_button.setText("Gestionar profesor");
        profesor_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        profesor_button.setPreferredSize(new java.awt.Dimension(300, 70));
        profesor_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesor_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(profesor_button, gridBagConstraints);

        estudiante_button.setBackground(new java.awt.Color(58, 159, 220));
        estudiante_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        estudiante_button.setForeground(new java.awt.Color(255, 255, 255));
        estudiante_button.setText("Gestionar estudiante");
        estudiante_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        estudiante_button.setPreferredSize(new java.awt.Dimension(300, 70));
        estudiante_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudiante_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(estudiante_button, gridBagConstraints);

        asignar_seccion_button.setBackground(new java.awt.Color(58, 159, 220));
        asignar_seccion_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        asignar_seccion_button.setForeground(new java.awt.Color(255, 255, 255));
        asignar_seccion_button.setText("Asignar seccion profesor");
        asignar_seccion_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        asignar_seccion_button.setPreferredSize(new java.awt.Dimension(300, 70));
        asignar_seccion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_seccion_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        jPanel2.add(asignar_seccion_button, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inscripcion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscripcion_buttonActionPerformed

    }//GEN-LAST:event_inscripcion_buttonActionPerformed

    private void asignar_nota_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_nota_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignar_nota_buttonActionPerformed

    private void listado_seccion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listado_seccion_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listado_seccion_buttonActionPerformed

    private void retirar_materia_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirar_materia_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retirar_materia_buttonActionPerformed

    private void listado_estudiante_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listado_estudiante_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listado_estudiante_buttonActionPerformed

    private void universidad_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universidad_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_universidad_buttonActionPerformed

    private void profesor_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesor_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesor_buttonActionPerformed

    private void estudiante_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudiante_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estudiante_buttonActionPerformed

    private void asignar_seccion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_seccion_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignar_seccion_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignar_nota_button;
    private javax.swing.JButton asignar_seccion_button;
    private javax.swing.JButton estudiante_button;
    private javax.swing.JButton inscripcion_button;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton listado_estudiante_button;
    private javax.swing.JButton listado_seccion_button;
    private javax.swing.JButton profesor_button;
    private javax.swing.JButton retirar_materia_button;
    private javax.swing.JLabel title_label2;
    private javax.swing.JLabel title_label3;
    private javax.swing.JPanel title_panel;
    private javax.swing.JButton universidad_button;
    // End of variables declaration//GEN-END:variables
}
