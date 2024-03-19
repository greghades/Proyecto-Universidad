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
        reporte1_button.addActionListener(accion);
        //agregar el escuchador 
        ReporteEstudiante_button.addActionListener(accion);
    }

    public JButton getReporte1_button() {
        return reporte1_button;
    }

    public JButton getInscripcion_button() {
        return inscripcion_button;
    }
    
    //agregando el boton de estudiantes
    public JButton getReporteEstudiante_button(){
        return ReporteEstudiante_button;
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
        jPanel1 = new javax.swing.JPanel();
        inscripcion_button = new javax.swing.JButton();
        title_label = new javax.swing.JLabel();
        reporte1_button = new javax.swing.JButton();
        ReporteEstudiante_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label2.setForeground(new java.awt.Color(255, 255, 255));
        title_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label2.setText("Bienvenido");

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(title_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(176, 176, 176))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(title_label2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 220), 2, true));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        inscripcion_button.setBackground(new java.awt.Color(58, 159, 220));
        inscripcion_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inscripcion_button.setForeground(new java.awt.Color(255, 255, 255));
        inscripcion_button.setText("Inscribir estudiante");
        inscripcion_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        inscripcion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscripcion_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 54, 0, 0);
        jPanel1.add(inscripcion_button, gridBagConstraints);

        title_label.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        title_label.setText("Proyecto Universidad");
        jPanel1.add(title_label, new java.awt.GridBagConstraints());

        reporte1_button.setBackground(new java.awt.Color(58, 159, 220));
        reporte1_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        reporte1_button.setForeground(new java.awt.Color(255, 255, 255));
        reporte1_button.setText("Reporte 1");
        reporte1_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        reporte1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporte1_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 54, 0, 0);
        jPanel1.add(reporte1_button, gridBagConstraints);

        ReporteEstudiante_button.setBackground(new java.awt.Color(58, 159, 220));
        ReporteEstudiante_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ReporteEstudiante_button.setForeground(new java.awt.Color(255, 255, 255));
        ReporteEstudiante_button.setText("Reporte Estudiantes");
        ReporteEstudiante_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        ReporteEstudiante_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteEstudiante_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 54, 6, 0);
        jPanel1.add(ReporteEstudiante_button, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inscripcion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscripcion_buttonActionPerformed

    }//GEN-LAST:event_inscripcion_buttonActionPerformed

    private void reporte1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte1_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reporte1_buttonActionPerformed

    private void ReporteEstudiante_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteEstudiante_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReporteEstudiante_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReporteEstudiante_button;
    private javax.swing.JButton inscripcion_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reporte1_button;
    private javax.swing.JLabel title_label;
    private javax.swing.JLabel title_label2;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
