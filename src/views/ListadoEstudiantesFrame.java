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

import controllers.ListadoEstudiantesController;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.TresColumnasModel;
import util.ListadoEstudianteTresTableModel;

public class ListadoEstudiantesFrame extends javax.swing.JFrame {

    public ListadoEstudiantesController controller;
    
    public ListadoEstudiantesFrame(ListadoEstudiantesController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;
        initComponents();
        displayUI(false);
        cmb_listado_estudiantes.setBackground(Color.white);
        agregarListener(controller);
    }

    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        cmb_listado_estudiantes.addActionListener(accion);
    }

    public void displayUI(boolean should) {
        table_panel.setVisible(should);
    }
    
    public void setupComboBox(List<String> opciones) {
        cmb_listado_estudiantes.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
    }

    public void setupTable(List<TresColumnasModel> datasource, String type) {
        limpiarTabla();

        // Instanciar el modelo para pintar la tabla.
        ListadoEstudianteTresTableModel model = new ListadoEstudianteTresTableModel(datasource, type);
        table_listado_estudiante.setModel(model);
        table_listado_estudiante.setPreferredScrollableViewportSize(table_listado_estudiante.getPreferredSize());

        configurarColumnas();
    }

    public void limpiarTabla() {
        // Limpiar la tabla para evitar duplicados.
        cmb_listado_estudiantes.setSelectedItem("Seleccione listado");
//        table_listado_estudiante.setModel(null);
        if (table_listado_estudiante.getModel().getRowCount() > 0) {
            TableColumnModel columnModel = table_listado_estudiante.getColumnModel();
            while (columnModel.getColumnCount() > 0) {
                TableColumn column = columnModel.getColumn(0);
                columnModel.removeColumn(column);
            }
        }
    }

    private void configurarColumnas() {
        // Asignar un ancho mayor a la primera columna
        TableColumnModel columnModel = table_listado_estudiante.getColumnModel();
        TableColumn firstColumn = columnModel.getColumn(0);
        firstColumn.setPreferredWidth(100);
        TableColumn secondColumn = columnModel.getColumn(1);
        secondColumn.setPreferredWidth(200);
        TableColumn thirdColumn = columnModel.getColumn(2);
        thirdColumn.setPreferredWidth(200);

        // Centrar el contenido de las columnas.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < table_listado_estudiante.getColumnCount(); x++) {
            if (x != 3) {
                table_listado_estudiante.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmb_listado_estudiantes = new javax.swing.JComboBox<>();
        table_panel = new javax.swing.JPanel();
        estudiantes_title_label = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_listado_estudiante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(58, 159, 220));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(623, 94));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(242, 242, 242));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Listado de Estudiantes");

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(58, 159, 220));
        back_button.setText("< Volver");
        back_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 189, Short.MAX_VALUE)
                .addComponent(title_label)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(title_label)
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Aplicar filtro");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 32));

        cmb_listado_estudiantes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        cmb_listado_estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_listado_estudiantesActionPerformed(evt);
            }
        });

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        estudiantes_title_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        estudiantes_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estudiantes_title_label.setText("Listado de estudiantes");
        estudiantes_title_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        estudiantes_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        jScrollPane3.setBorder(null);

        table_listado_estudiante.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        table_listado_estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Extra"
            }
        ));
        table_listado_estudiante.setFocusable(false);
        table_listado_estudiante.setGridColor(new java.awt.Color(37, 92, 125));
        table_listado_estudiante.setRequestFocusEnabled(false);
        table_listado_estudiante.setRowHeight(48);
        table_listado_estudiante.setRowSelectionAllowed(false);
        table_listado_estudiante.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_listado_estudiante.setShowGrid(true);
        table_listado_estudiante.getTableHeader().setReorderingAllowed(false);
        table_listado_estudiante.setUpdateSelectionOnSort(false);
        table_listado_estudiante.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(table_listado_estudiante);

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(estudiantes_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(estudiantes_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_listado_estudiantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_listado_estudiantes))
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed

    private void cmb_listado_estudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_listado_estudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_listado_estudiantesActionPerformed

    public JButton getBack_button() {
        return back_button;
    }

    public JComboBox<Object> getCmb_listado_estudiantes() {
        return cmb_listado_estudiantes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JComboBox<Object> cmb_listado_estudiantes;
    private javax.swing.JLabel estudiantes_title_label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_listado_estudiante;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}
