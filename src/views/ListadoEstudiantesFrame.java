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
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import models.CincoColumnasModel;
import models.CuatroColumnasModel;
import models.TresColumnasModel;
import util.ListadoEstudianteCincoTableModel;
import util.ListadoEstudianteCuatroTableModel;
import util.ListadoEstudianteTresTableModel;

public class ListadoEstudiantesFrame extends javax.swing.JFrame {
    
    public ListadoEstudiantesController controller;
    private TableRowSorter sorter;
    
    public ListadoEstudiantesFrame(ListadoEstudiantesController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;
        initComponents();
        cmb_listado_estudiantes.setBackground(Color.white);
        agregarListener(controller);
    }
    
    private void agregarListener(ActionListener accion) {
        botonBean1.addActionListener(accion);
        cmb_listado_estudiantes.addActionListener(accion);
        search_button.addActionListener(accion);
    }
    
    public void mostrarUI(boolean should) {
        table_panel.setVisible(should);
    }
    
    public void setupComboBox(List<String> opciones) {
        cmb_listado_estudiantes.setModel(new DefaultComboBoxModel<>(opciones.toArray()));
    }
    
    public void search() {
        String str = searchTextField.getText();
        String padding = "   ";
        if (str.length() == 0) {
            sorter.setRowFilter(null);
            searchTextField.setText(padding + "Busca por la columna que desees");
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(str));
        }
    }
    
    private void actualizarUI(String option, AbstractTableModel model) {
        cmb_listado_estudiantes.setSelectedItem(option);
        table_listado_estudiante.setPreferredScrollableViewportSize(table_listado_estudiante.getPreferredSize());
        sorter = new TableRowSorter<>(model);
        table_listado_estudiante.setRowSorter(sorter);
        configurarColumnas();
    }
    
    public void configurarTablaTresColumnas(List<TresColumnasModel> datasource, String type, String option) {
        limpiarUI();
        ListadoEstudianteTresTableModel model = new ListadoEstudianteTresTableModel(datasource, type);
        table_listado_estudiante.setModel(model);
        actualizarUI(option, model);
    }
    
    public void configurarTablaCuatroColumnas(List<CuatroColumnasModel> datasource, String[] columns, String option) {
        limpiarUI();
        ListadoEstudianteCuatroTableModel model = new ListadoEstudianteCuatroTableModel(datasource, columns);
        table_listado_estudiante.setModel(model);
        actualizarUI(option, model);
    }
    
    public void configurarTablaCincoColumnas(List<CincoColumnasModel> datasource, String option) {
        limpiarUI();
        ListadoEstudianteCincoTableModel model = new ListadoEstudianteCincoTableModel(datasource);
        table_listado_estudiante.setModel(model);
        actualizarUI(option, model);
    }
    
    public void limpiarUI() {
        // Limpiar el UI 
        cmb_listado_estudiantes.setSelectedItem("Seleccione listado");
        mostrarUI(false);
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
        firstColumn.setMaxWidth(50);
        
        for (int i = 1; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setResizable(true);
            columnModel.getColumn(i).setMaxWidth(10000);            
        }

        // Centrar el contenido de las columnas.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < table_listado_estudiante.getColumnCount(); x++) {
            table_listado_estudiante.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        mostrarUI(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        botonBean1 = new ComponenteBean.BotonBean();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmb_listado_estudiantes = new javax.swing.JComboBox<>();
        table_panel = new javax.swing.JPanel();
        estudiantes_title_label = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_listado_estudiante = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(58, 159, 220));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(623, 94));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(242, 242, 242));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Listado de Estudiantes");

        botonBean1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        botonBean1.setForeground(new java.awt.Color(58, 159, 220));
        botonBean1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(title_label)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_label))
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

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        table_listado_estudiante.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        table_listado_estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Extra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (table_listado_estudiante.getColumnModel().getColumnCount() > 0) {
            table_listado_estudiante.getColumnModel().getColumn(0).setResizable(false);
            table_listado_estudiante.getColumnModel().getColumn(1).setResizable(false);
            table_listado_estudiante.getColumnModel().getColumn(2).setResizable(false);
        }

        searchTextField.setText("   Busca por la columna que desees");
        searchTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        search_button.setBackground(new java.awt.Color(58, 159, 220));
        search_button.setForeground(new java.awt.Color(255, 255, 255));
        search_button.setText("Buscar");
        search_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addComponent(estudiantes_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, table_panelLayout.createSequentialGroup()
                .addComponent(searchTextField)
                .addGap(8, 8, 8)
                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(estudiantes_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        searchTextField.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
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

    private void cmb_listado_estudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_listado_estudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_listado_estudiantesActionPerformed

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed

    }//GEN-LAST:event_search_buttonActionPerformed
    
    public JButton getBack_button() {
        return botonBean1;
    }
    
    public JButton getSearch_button() {
        return search_button;
    }
    
    public JComboBox<Object> getCmb_listado_estudiantes() {
        return cmb_listado_estudiantes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComponenteBean.BotonBean botonBean1;
    private javax.swing.JComboBox<Object> cmb_listado_estudiantes;
    private javax.swing.JLabel estudiantes_title_label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton search_button;
    private javax.swing.JTable table_listado_estudiante;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}
