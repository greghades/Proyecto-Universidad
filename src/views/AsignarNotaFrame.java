/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.AsignarNotaController;
import java.awt.event.ActionListener;

/**
 *
 * @author alba
 */
public class AsignarNotaFrame extends javax.swing.JFrame {
    
      public AsignarNotaController controller;

    public AsignarNotaFrame(AsignarNotaController controller) {
        this.controller =  controller;
        initComponents();
        agregarListener(controller);
    }
    
     private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        table_panel = new javax.swing.JPanel();
        estudiantes_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estudiantes_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(623, 94));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignar Notas");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("< Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        estudiantes_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        estudiantes_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estudiantes_label.setText("Listado de estudiantes");
        estudiantes_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        estudiantes_label.setPreferredSize(new java.awt.Dimension(120, 32));

        estudiantes_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        estudiantes_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Estudiante", "Sección", "Calificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estudiantes_table.setFocusable(false);
        estudiantes_table.setGridColor(new java.awt.Color(37, 92, 125));
        estudiantes_table.setRequestFocusEnabled(false);
        estudiantes_table.setRowHeight(48);
        estudiantes_table.setRowSelectionAllowed(false);
        estudiantes_table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        estudiantes_table.setShowGrid(true);
        estudiantes_table.getTableHeader().setReorderingAllowed(false);
        estudiantes_table.setUpdateSelectionOnSort(false);
        estudiantes_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(estudiantes_table);

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estudiantes_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(estudiantes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                    .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel estudiantes_label;
    private javax.swing.JTable estudiantes_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel table_panel;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
