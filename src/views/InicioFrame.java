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
    
    public JButton getEstudiante_Button(){
        return estudiante_button;
    }
    
    public JButton getProfesor_Button() {
        return profesor_button;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        title_label2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title_label3 = new javax.swing.JLabel();
        inscripcion_button = new javax.swing.JButton();
        listado_estudiante_button = new javax.swing.JButton();
        retirar_materia_button = new javax.swing.JButton();
        asignar_nota_button = new javax.swing.JButton();
        listado_seccion_button = new javax.swing.JButton();
        estudiante_button = new javax.swing.JButton();
        profesor_button = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(1214, 598));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 24, 24));

        title_label3.setBackground(new java.awt.Color(153, 0, 51));
        title_label3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        title_label3.setForeground(new java.awt.Color(51, 51, 51));
        title_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label3.setText("Opciones disponibles");
        title_label3.setMaximumSize(new java.awt.Dimension(1000000, 28));
        title_label3.setMinimumSize(new java.awt.Dimension(624, 28));
        title_label3.setPreferredSize(new java.awt.Dimension(948, 60));
        jPanel2.add(title_label3);

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
        jPanel2.add(inscripcion_button);

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
        jPanel2.add(listado_estudiante_button);

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
        jPanel2.add(retirar_materia_button);

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
        jPanel2.add(asignar_nota_button);

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
        jPanel2.add(listado_seccion_button);

        estudiante_button.setBackground(new java.awt.Color(58, 159, 220));
        estudiante_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        estudiante_button.setForeground(new java.awt.Color(255, 255, 255));
        estudiante_button.setText("Estudiante");
        estudiante_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        estudiante_button.setPreferredSize(new java.awt.Dimension(300, 70));
        estudiante_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudiante_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(estudiante_button);

        profesor_button.setBackground(new java.awt.Color(58, 159, 220));
        profesor_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        profesor_button.setForeground(new java.awt.Color(255, 255, 255));
        profesor_button.setText("Profesor");
        profesor_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        profesor_button.setPreferredSize(new java.awt.Dimension(300, 70));
        profesor_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesor_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(profesor_button);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
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

    private void estudiante_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudiante_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estudiante_buttonActionPerformed

    private void profesor_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesor_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesor_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignar_nota_button;
    private javax.swing.JButton estudiante_button;
    private javax.swing.JButton inscripcion_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton listado_estudiante_button;
    private javax.swing.JButton listado_seccion_button;
    private javax.swing.JButton profesor_button;
    private javax.swing.JButton retirar_materia_button;
    private javax.swing.JLabel title_label2;
    private javax.swing.JLabel title_label3;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
