package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Subject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class JFrame_Inscripcion extends javax.swing.JFrame {
    /**
     * Creates new form JFrame_Inscripcion
     */
    public JFrame_Inscripcion() {
        initComponents();
        setupTable();
    }
    
    private void setupTable() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Matematicas", 3, true, ""));
        subjects.add(new Subject("Fisica", 4, false, "Seccion A"));
        subjects.add(new Subject("Quimica", 3, true, "Seccion B"));

        SubjectTableModel model = new SubjectTableModel(subjects);
        subject_table.setModel(model);

        TableColumnModel columnModel = subject_table.getColumnModel();
        int seccionColumnIndex = columnModel.getColumnCount() - 1;
        TableColumn seccionColumn = columnModel.getColumn(seccionColumnIndex);
        seccionColumn.setCellEditor(new SeccionCellEditor());
        seccionColumn.setCellRenderer(new SeccionCellRenderer());        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<subject_table.getColumnCount();x++){
            if(x != 2) {            
             subject_table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        body_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        cedula_label = new javax.swing.JLabel();
        cedula_label1 = new javax.swing.JLabel();
        cedula_label2 = new javax.swing.JLabel();
        cedula_label3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Inscripción");

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(148, 148, 148))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cedula_textfield.setToolTipText("Introduce tu cedula");
        cedula_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        cedula_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        cedula_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        cedula_textfield.setName(""); // NOI18N
        cedula_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_textfieldActionPerformed(evt);
            }
        });

        cedula_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label.setText("Cedula ");
        cedula_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_label.setPreferredSize(new java.awt.Dimension(120, 32));

        cedula_label1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label1.setText("Materias");
        cedula_label1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_label1.setPreferredSize(new java.awt.Dimension(120, 32));

        cedula_label2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label2.setText("Semestre");
        cedula_label2.setPreferredSize(new java.awt.Dimension(120, 32));

        cedula_label3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cedula_label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label3.setText("IV");
        cedula_label3.setPreferredSize(new java.awt.Dimension(120, 32));

        subject_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        subject_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Materia", "Carga académica", "Inclusión", "Sección"
            }
        ));
        subject_table.setFocusable(false);
        subject_table.setRequestFocusEnabled(false);
        subject_table.setRowHeight(48);
        subject_table.setRowSelectionAllowed(false);
        subject_table.setRowSorter(null);
        subject_table.setShowGrid(true);
        subject_table.setUpdateSelectionOnSort(false);
        subject_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(subject_table);

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(cedula_label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                        .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(body_panelLayout.createSequentialGroup()
                                .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cedula_label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                                        .addComponent(cedula_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))))
                        .addGap(16, 16, 16))))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(cedula_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cedula_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedula_label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cedula_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_textfieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JLabel cedula_label1;
    private javax.swing.JLabel cedula_label2;
    private javax.swing.JLabel cedula_label3;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable subject_table;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
