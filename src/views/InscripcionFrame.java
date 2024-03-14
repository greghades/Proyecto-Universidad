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
import controllers.InscripcionController;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Subject;

public class InscripcionFrame extends javax.swing.JFrame {
    public InscripcionController controller;

  public InscripcionFrame(InscripcionController controller) {
    super("Inscripción");
    this.controller = controller;
    
    initComponents();
    setupTable();
    displayUI();
  }

    private void displayUI() {
        info_panel.setVisible(false);
        table_panel.setVisible(false);
    }
    
    private void setupTable() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Matematicas", 3, true, ""));
        subjects.add(new Subject("Fisica", 4, false, "Seccion A"));
        subjects.add(new Subject("Quimica", 3, true, "Seccion B"));

        SubjectTableModel model = new SubjectTableModel(subjects);
        materias_table.setModel(model);

        TableColumnModel columnModel = materias_table.getColumnModel();
        int seccionColumnIndex = columnModel.getColumnCount() - 1;
        TableColumn seccionColumn = columnModel.getColumn(seccionColumnIndex);
        seccionColumn.setCellEditor(new SeccionCellEditor());
        seccionColumn.setCellRenderer(new SeccionCellRenderer());        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<materias_table.getColumnCount();x++){
            if(x != 2) {            
             materias_table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        cedula_label = new javax.swing.JLabel();
        cedula_button = new javax.swing.JButton();
        info_panel = new javax.swing.JPanel();
        semestre_title_label = new javax.swing.JLabel();
        semestre_label = new javax.swing.JLabel();
        nombre_title_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        sex_title_label = new javax.swing.JLabel();
        sex_label = new javax.swing.JLabel();
        carrera_title_label = new javax.swing.JLabel();
        carrera_label = new javax.swing.JLabel();
        table_panel = new javax.swing.JPanel();
        materias_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        materias_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Inscripción");

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
                .addGap(160, 160, 160)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(148, 148, 148))
            .addGroup(title_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        cedula_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label.setText("Ingresa tu cédula");
        cedula_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_label.setPreferredSize(new java.awt.Dimension(120, 32));

        cedula_button.setBackground(new java.awt.Color(58, 159, 220));
        cedula_button.setForeground(new java.awt.Color(255, 255, 255));
        cedula_button.setText("Buscar");
        cedula_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cedula_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_buttonActionPerformed(evt);
            }
        });

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

        semestre_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        semestre_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        semestre_title_label.setText("Semestre");
        semestre_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        semestre_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        semestre_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        semestre_label.setText("IV");
        semestre_label.setPreferredSize(new java.awt.Dimension(120, 32));

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

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semestre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semestre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sex_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(sex_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        materias_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        materias_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        materias_label.setText("Listado de materias");
        materias_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        materias_label.setPreferredSize(new java.awt.Dimension(120, 32));

        materias_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        materias_table.setModel(new javax.swing.table.DefaultTableModel(
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
        materias_table.setFocusable(false);
        materias_table.setRequestFocusEnabled(false);
        materias_table.setRowHeight(48);
        materias_table.setRowSelectionAllowed(false);
        materias_table.setShowGrid(true);
        materias_table.setUpdateSelectionOnSort(false);
        materias_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(materias_table);

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materias_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materias_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cedula_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

    }//GEN-LAST:event_cedula_textfieldActionPerformed

    private void cedula_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_buttonActionPerformed
        controller.connection.consultarTabla();
    }//GEN-LAST:event_cedula_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        controller.showInicioFrame();
    }//GEN-LAST:event_back_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel carrera_label;
    private javax.swing.JLabel carrera_title_label;
    private javax.swing.JButton cedula_button;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JPanel info_panel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel materias_label;
    private javax.swing.JTable materias_table;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nombre_title_label;
    private javax.swing.JLabel semestre_label;
    private javax.swing.JLabel semestre_title_label;
    private javax.swing.JLabel sex_label;
    private javax.swing.JLabel sex_title_label;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables

    public Object getButton1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getButton2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
