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
import sql.ConexionSQL;


public class JFrame_AsignarNota extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_ConsultarNota
     */
    ConexionSQL conn = new ConexionSQL();
    
    public JFrame_AsignarNota() {
        initComponents();

        // Aqui va toda la logica programatica que quiera agegarse
        conn.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cedulaLabel = new javax.swing.JLabel();
        asignaturaLabel = new javax.swing.JLabel();
        calificacionLabel = new javax.swing.JLabel();
        asignaturaTextField = new javax.swing.JTextField();
        cedulaTextField = new javax.swing.JTextField();
        calificacionTextField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        buscarEstudianteButton = new javax.swing.JButton();
        buscarNotasButton = new javax.swing.JButton();
        periodoLabel = new javax.swing.JLabel();
        seccionLabel = new javax.swing.JLabel();
        historialLabel = new javax.swing.JLabel();
        asignarNotaButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        seccionValueLabel = new javax.swing.JLabel();
        nombreValueLabel = new javax.swing.JLabel();
        periodoValueLabel = new javax.swing.JLabel();
        primeroValueLabel = new javax.swing.JLabel();
        primeroLabel = new javax.swing.JLabel();
        segundoLabel = new javax.swing.JLabel();
        terceroLabel = new javax.swing.JLabel();
        terceroValueLabel = new javax.swing.JLabel();
        segundoValueLabel = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 134, 197));

        jPanel3.setBackground(new java.awt.Color(13, 13, 13));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(242, 242, 242))); // NOI18N

        cedulaLabel.setForeground(new java.awt.Color(217, 243, 255));
        cedulaLabel.setText("Cedula");

        asignaturaLabel.setForeground(new java.awt.Color(217, 243, 255));
        asignaturaLabel.setText("Asignatura");

        calificacionLabel.setForeground(new java.awt.Color(217, 243, 255));
        calificacionLabel.setText("Calificacion");

        asignaturaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignaturaTextFieldActionPerformed(evt);
            }
        });

        cedulaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaTextFieldActionPerformed(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(150, 212, 241));
        nombreLabel.setText("Nombre:");

        buscarEstudianteButton.setBackground(new java.awt.Color(44, 134, 197));
        buscarEstudianteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscarEstudianteButton.setForeground(new java.awt.Color(242, 242, 242));
        buscarEstudianteButton.setText("Buscar estudiante");
        buscarEstudianteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEstudianteButtonActionPerformed(evt);
            }
        });

        buscarNotasButton.setBackground(new java.awt.Color(44, 134, 197));
        buscarNotasButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscarNotasButton.setForeground(new java.awt.Color(242, 242, 242));
        buscarNotasButton.setText("Buscar asignatura");
        buscarNotasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNotasButtonActionPerformed(evt);
            }
        });

        periodoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        periodoLabel.setForeground(new java.awt.Color(150, 212, 241));
        periodoLabel.setText("Periodo Academico: ");

        seccionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seccionLabel.setForeground(new java.awt.Color(150, 212, 241));
        seccionLabel.setText("Seccion:");

        historialLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        historialLabel.setForeground(new java.awt.Color(236, 226, 226));
        historialLabel.setText("Historial de notas");

        asignarNotaButton.setBackground(new java.awt.Color(44, 134, 197));
        asignarNotaButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        asignarNotaButton.setForeground(new java.awt.Color(242, 242, 242));
        asignarNotaButton.setText("Asignar nota");
        asignarNotaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarNotaButtonActionPerformed(evt);
            }
        });

        seccionValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        seccionValueLabel.setText("1");

        nombreValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        nombreValueLabel.setText("Ernesto Contreras");

        periodoValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        periodoValueLabel.setText("Quinto");

        primeroValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        primeroValueLabel.setText("05");

        primeroLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        primeroLabel.setForeground(new java.awt.Color(150, 212, 241));
        primeroLabel.setText("Primer corte:");

        segundoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        segundoLabel.setForeground(new java.awt.Color(150, 212, 241));
        segundoLabel.setText("Segundo corte:");

        terceroLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        terceroLabel.setForeground(new java.awt.Color(150, 212, 241));
        terceroLabel.setText("Tercer corte:");

        terceroValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        terceroValueLabel.setText("??");

        segundoValueLabel.setForeground(new java.awt.Color(217, 243, 255));
        segundoValueLabel.setText("26");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asignaturaLabel)
                            .addComponent(asignaturaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarNotasButton))
                        .addGap(85, 85, 85)
                        .addComponent(historialLabel)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cedulaLabel)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cedulaTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buscarEstudianteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(seccionLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(seccionValueLabel))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(nombreLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(nombreValueLabel))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(periodoLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(periodoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(segundoLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(segundoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(terceroLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(terceroValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(primeroLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(primeroValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(asignarNotaButton)
                                    .addComponent(calificacionLabel)
                                    .addComponent(calificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cedulaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cedulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buscarEstudianteButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seccionLabel)
                            .addComponent(seccionValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreLabel)
                            .addComponent(nombreValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(periodoLabel)
                            .addComponent(periodoValueLabel))))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(asignaturaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asignaturaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarNotasButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(historialLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primeroLabel)
                            .addComponent(primeroValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(segundoLabel)
                            .addComponent(segundoValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(terceroLabel)
                            .addComponent(terceroValueLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calificacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(asignarNotaButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tituloLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(236, 226, 226));
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("Asignar calificación a un Estudiante");
        tituloLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaTextFieldActionPerformed

    private void asignaturaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignaturaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignaturaTextFieldActionPerformed

    private void buscarEstudianteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEstudianteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarEstudianteButtonActionPerformed

    private void buscarNotasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNotasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarNotasButtonActionPerformed

    private void asignarNotaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarNotaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignarNotaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_AsignarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_AsignarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_AsignarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_AsignarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrame_AsignarNota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarNotaButton;
    private javax.swing.JLabel asignaturaLabel;
    private javax.swing.JTextField asignaturaTextField;
    private javax.swing.JButton buscarEstudianteButton;
    private javax.swing.JButton buscarNotasButton;
    private javax.swing.JLabel calificacionLabel;
    private javax.swing.JTextField calificacionTextField;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JTextField cedulaTextField;
    private static javax.swing.JLabel historialLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private static javax.swing.JLabel nombreLabel;
    private static javax.swing.JLabel nombreValueLabel;
    private static javax.swing.JLabel periodoLabel;
    private static javax.swing.JLabel periodoValueLabel;
    private static javax.swing.JLabel primeroLabel;
    private static javax.swing.JLabel primeroValueLabel;
    private static javax.swing.JLabel seccionLabel;
    private static javax.swing.JLabel seccionValueLabel;
    private static javax.swing.JLabel segundoLabel;
    private static javax.swing.JLabel segundoValueLabel;
    private static javax.swing.JLabel terceroLabel;
    private static javax.swing.JLabel terceroValueLabel;
    private static javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
