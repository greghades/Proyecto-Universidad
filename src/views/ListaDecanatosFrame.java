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

import compose.ComponenteUniversitario;
import controllers.ListaDecanatosController;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.ListadoDecanatoModel;
import models.ListadoSeccionModel;
import util.ListaDecanatoTableModel;

public class ListaDecanatosFrame extends javax.swing.JFrame {

    public ListaDecanatosController controller;

    public ListaDecanatosFrame(ListaDecanatosController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;

        initComponents();
        displayUI(false);
        agregarListener(controller);

    }

    public void displayUI(boolean should) {
        table_panel.setVisible(should);
    }

    public void setupTable(List<ComponenteUniversitario> listadoDecanato) {
        limpiarTabla();

        ListaDecanatoTableModel model = new ListaDecanatoTableModel(listadoDecanato);
        decanatos_table.setModel(model);

        configurarColumnas();

    }

    public void limpiarTabla() {
        // Limpiar la tabla para evitar duplicados.
        if (decanatos_table.getModel().getRowCount() > 0) {
            TableColumnModel columnModel = decanatos_table.getColumnModel();
            while (columnModel.getColumnCount() > 0) {
                TableColumn column = columnModel.getColumn(0); // Get the first column
                columnModel.removeColumn(column);
            }
        }
    }

    private void configurarColumnas() {
        // Asignar un ancho mayor a la primera columna
        TableColumnModel columnModel = decanatos_table.getColumnModel();
        TableColumn firstColumn = columnModel.getColumn(0);
        firstColumn.setMaxWidth(60);

        for (int i = 1; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setResizable(true);
            columnModel.getColumn(i).setMaxWidth(10000);
        }

        // Centrar el contenido de las columnas.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < decanatos_table.getColumnCount(); x++) {
            if (x != 3) {
                decanatos_table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        }
    }

    private void agregarListener(ActionListener accion) {
        botonBean1.addActionListener(accion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        botonBean1 = new ComponenteBean.BotonBean();
        conteiner_panel = new javax.swing.JPanel();
        table_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        decanatos_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Lista de decanatos");

        botonBean1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        botonBean1.setForeground(new java.awt.Color(58, 159, 220));
        botonBean1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout title_panelLayout = new javax.swing.GroupLayout(title_panel);
        title_panel.setLayout(title_panelLayout);
        title_panelLayout.setHorizontalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_label))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        conteiner_panel.setBackground(new java.awt.Color(255, 255, 255));
        conteiner_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        decanatos_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        decanatos_table.setGridColor(new java.awt.Color(37, 92, 125));
        decanatos_table.setRowHeight(48);
        decanatos_table.setShowGrid(true);
        decanatos_table.setUpdateSelectionOnSort(false);
        decanatos_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(decanatos_table);

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, table_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout conteiner_panelLayout = new javax.swing.GroupLayout(conteiner_panel);
        conteiner_panel.setLayout(conteiner_panelLayout);
        conteiner_panelLayout.setHorizontalGroup(
            conteiner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteiner_panelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        conteiner_panelLayout.setVerticalGroup(
            conteiner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteiner_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(conteiner_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(conteiner_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComponenteBean.BotonBean botonBean1;
    private javax.swing.JPanel conteiner_panel;
    private javax.swing.JTable decanatos_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
