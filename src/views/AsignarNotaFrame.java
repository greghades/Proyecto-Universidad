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

import controllers.AsignarNotaController;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Asignatura;
import models.NotaEstudianteListModel;
import models.Profesor;
import util.NotaEstudianteListTableModel;

public class AsignarNotaFrame extends javax.swing.JFrame {

    public AsignarNotaController controller;

    public AsignarNotaFrame(AsignarNotaController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        cedula_button.addActionListener(accion);
        cmb_asignatura.addActionListener(accion);
    }

    public void mostrarEstadoInicial() {
        content_panel.setVisible(false);
        info_panel.setVisible(false);
    }

    public void limpiarTabla() {
        table_panel.setVisible(false);
        if (estudiantes_table.getModel().getRowCount() > 0) {
            TableColumnModel columnModel = estudiantes_table.getColumnModel();
            while (columnModel.getColumnCount() > 0) {
                TableColumn column = columnModel.getColumn(0);
                columnModel.removeColumn(column);
            }
        }
    }

    public void rellenarInformacionInicial(Profesor profesor) {
        table_panel.setVisible(false);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccionar asignatura");
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            model.addElement(asignatura.getNombre());
        }
        cmb_asignatura.setModel(model);

        nombre_label.setText(profesor.getNombre());
        especialidad_label.setText(profesor.getEspecialidad());

        info_panel.setVisible(true);
        content_panel.setVisible(true);
    }

    public void configurarTablaEstudiantes(List<NotaEstudianteListModel> datasource, String option) {
        limpiarTabla();
        NotaEstudianteListTableModel model = new NotaEstudianteListTableModel(datasource);
        estudiantes_table.setModel(model);
        actualizarUI(option);
        table_panel.setVisible(true);
    }

    private void actualizarUI(String option) {
        cmb_asignatura.setSelectedItem(option);
        estudiantes_table.setPreferredScrollableViewportSize(estudiantes_table.getPreferredSize());
        configurarColumnas();
    }

    private void configurarColumnas() {
        TableColumnModel columnModel = estudiantes_table.getColumnModel();
        TableColumn firstColumn = columnModel.getColumn(0);
        firstColumn.setMaxWidth(50);

        for (int i = 1; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setResizable(true);
            columnModel.getColumn(i).setMaxWidth(10000);
        }

        // Centrar el contenido de las columnas.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < estudiantes_table.getColumnCount(); x++) {
            estudiantes_table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        table_panel.setVisible(true);
    }

    public JTable getAsignaturas_table() {
        return estudiantes_table;
    }

    public String getCedula() {
        return cedula_textfield.getText();
    }

    public JComboBox<String> getCmb_asignatura() {
        return cmb_asignatura;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getCedula_button() {
        return cedula_button;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        cedula_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        cedula_label = new javax.swing.JLabel();
        cedula_button = new javax.swing.JButton();
        content_panel = new javax.swing.JPanel();
        table_panel = new javax.swing.JPanel();
        estudiantes_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estudiantes_table = new javax.swing.JTable();
        cmb_asignatura = new javax.swing.JComboBox<>();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32), new java.awt.Dimension(32767, 0));
        info_panel = new javax.swing.JPanel();
        nombre_title_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        especialidad_label = new javax.swing.JLabel();
        especialidad_title_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(623, 94));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignar notas");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(214, Short.MAX_VALUE))
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

        cedula_panel.setBackground(new java.awt.Color(255, 255, 255));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("ID");
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

        cedula_label.setBackground(new java.awt.Color(255, 255, 255));
        cedula_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cedula_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedula_label.setText("Ingresar ID de Profesor");
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

        javax.swing.GroupLayout cedula_panelLayout = new javax.swing.GroupLayout(cedula_panel);
        cedula_panel.setLayout(cedula_panelLayout);
        cedula_panelLayout.setHorizontalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cedula_label, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addGroup(cedula_panelLayout.createSequentialGroup()
                        .addComponent(cedula_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        cedula_panelLayout.setVerticalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cedula_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        content_panel.setBackground(new java.awt.Color(255, 255, 255));
        content_panel.setPreferredSize(new java.awt.Dimension(572, 500));

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        estudiantes_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        estudiantes_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estudiantes_label.setText("Listado de secciones de la asignatura seleccionada");
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
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estudiantes_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(estudiantes_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        cmb_asignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar asignatura" }));
        cmb_asignatura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cmb_asignatura.setMaximumSize(new java.awt.Dimension(32767, 80));
        cmb_asignatura.setMinimumSize(new java.awt.Dimension(214, 80));
        cmb_asignatura.setPreferredSize(new java.awt.Dimension(214, 32));
        cmb_asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_asignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout content_panelLayout = new javax.swing.GroupLayout(content_panel);
        content_panel.setLayout(content_panelLayout);
        content_panelLayout.setHorizontalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_panelLayout.createSequentialGroup()
                .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(content_panelLayout.createSequentialGroup()
                        .addComponent(cmb_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        content_panelLayout.setVerticalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

        nombre_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_title_label.setText("Nombre");
        nombre_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        nombre_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre_label.setText("NombreProfesor");
        nombre_label.setPreferredSize(new java.awt.Dimension(120, 32));

        especialidad_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        especialidad_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        especialidad_label.setText("EspecialidadProfesor");
        especialidad_label.setPreferredSize(new java.awt.Dimension(120, 32));

        especialidad_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        especialidad_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        especialidad_title_label.setText("Especialidad");
        especialidad_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombre_label, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(nombre_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(especialidad_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(especialidad_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(especialidad_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(especialidad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cedula_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(body_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
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

    private void cedula_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_textfieldActionPerformed

    }//GEN-LAST:event_cedula_textfieldActionPerformed

    private void cedula_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_buttonActionPerformed

    }//GEN-LAST:event_cedula_buttonActionPerformed

    private void cmb_asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_asignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_asignaturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JButton cedula_button;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JPanel cedula_panel;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JComboBox<String> cmb_asignatura;
    private javax.swing.JPanel content_panel;
    private javax.swing.JLabel especialidad_label;
    private javax.swing.JLabel especialidad_title_label;
    private javax.swing.JLabel estudiantes_label;
    private javax.swing.JTable estudiantes_table;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel info_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nombre_title_label;
    private javax.swing.JPanel table_panel;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
