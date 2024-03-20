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

import controllers.ListaSeccionController;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.ListadoSeccionModel;
import util.ListaSeccionTableModel;

public class ListaSeccionFrame extends javax.swing.JFrame {

    public ListaSeccionController controller;

    public ListaSeccionFrame(ListaSeccionController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;
        
        initComponents();
        displayUI(false);
        agregarListener(controller);

    }
    public void displayUI(boolean should) {
        table_panel.setVisible(should);
    }
    
    public void setupTable(List<ListadoSeccionModel> listadoSeccion) {
        limpiarTabla();
        Iterable<ListadoSeccionModel> secciones = listadoSeccion;
        System.out.println(secciones);
        for (ListadoSeccionModel seccion : secciones) {
                System.out.println("Número de Sección: " + seccion.getSeccion());
                System.out.println("Nombre de Asignatura: " + seccion.getAsignatura());
                System.out.println("Nombre de Carrera: " + seccion.getCarrera());
                System.out.println("Nombre de Decanato: " + seccion.getDecanato());
                System.out.println("Promedio de la Sección: " + seccion.getPromedio_seccion());
                System.out.println("Número de Aprobados: " + seccion.getNumero_aprobados());
                System.out.println("Número de Reprobados: " + seccion.getNumero_aplazados());
                System.out.println("Estudiantes Encima del Promedio: " + Arrays.toString(seccion.getEstudiantesPorEncimaPromedio()));
                System.out.println("Estudiantes Debajo del Promedio: " + Arrays.toString(seccion.getEstudiantesPorDebajoPromedio()));
                System.out.println("----------------------------------------");
        }
        // Instanciar el modelo para pintar la tabla.
        ListaSeccionTableModel model = new ListaSeccionTableModel(listadoSeccion);
        secciones_table.setModel(model);
        
        configurarColumnas();
        
    }

    
    public void limpiarTabla() {
        // Limpiar la tabla para evitar duplicados.
        if (secciones_table.getModel().getRowCount() > 0) {
            TableColumnModel columnModel = secciones_table.getColumnModel();
            while (columnModel.getColumnCount() > 0) {
                TableColumn column = columnModel.getColumn(0); // Get the first column
                columnModel.removeColumn(column);
            }
        }
    }
        
    private void configurarColumnas() {
        // Asignar un ancho mayor a la primera columna
        TableColumnModel columnModel = secciones_table.getColumnModel();
        TableColumn firstColumn = columnModel.getColumn(0);
        firstColumn.setPreferredWidth(150);
        TableColumn secondColumn = columnModel.getColumn(1);
        secondColumn.setMinWidth(12);
        TableColumn thirdColumn = columnModel.getColumn(2);
        thirdColumn.setMinWidth(12);
        TableColumn fourthColumn = columnModel.getColumn(3);
        fourthColumn.setMinWidth(12);

        // Centrar el contenido de las columnas.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < secciones_table.getColumnCount(); x++) {
            if (x != 3) {
                secciones_table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        }
    }
    private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        conteiner_panel = new javax.swing.JPanel();
        table_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        secciones_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("Lista de secciones");

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
                .addContainerGap()
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGroup(title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(title_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(title_panelLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(title_label)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        conteiner_panel.setBackground(new java.awt.Color(255, 255, 255));
        conteiner_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        secciones_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(secciones_table);

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

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel conteiner_panel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable secciones_table;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
