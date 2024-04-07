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
/*
import controllers.AsignarNotaController;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
*/

public class ProfesorFrame extends javax.swing.JFrame {

    //public AsignarNotaController controller;

    public ProfesorFrame() {
       // this.controller = controller;
        initComponents();
       // agregarListener(controller);
    }

    /*private void agregarListener(ActionListener accion) {
        back_button.addActionListener(accion);
        save_button.addActionListener(accion);
        cmb_asignatura.addActionListener(accion);
        save_button.addActionListener(accion);
    }

    public void mostrarEstadoInicial() {
        content_panel.setVisible(false);
        info_panel.setVisible(false);
    }

    public void limpiarTabla() {
        table_panel.setVisible(false);
        save_button.setVisible(false);
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
        save_button.setVisible(false);
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
        NotaEstudianteListTableModel model = new NotaEstudianteListTableModel(datasource, controller);
        estudiantes_table.setModel(model);
        actualizarUI(option);
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
        save_button.setVisible(true);
    }
    public JTable getAsignaturas_table() {
        return profesores_table;
    }

    public String getCedula() {
        return cedula_textfield.getText();
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getCedula_button() {
        return save_button;
    }

    public JButton getSave_button() {
        return save_button;
    }

    public JTable getEstudiantes_table() {
        return profesores_table;
    }*/


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        crud_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre_textfield = new javax.swing.JTextField();
        edad_textfield = new javax.swing.JTextField();
        correo_textfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sexo_textfield = new javax.swing.JTextField();
        especialidad_textfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        content_panel = new javax.swing.JPanel();
        table_panel = new javax.swing.JPanel();
        profesores_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profesores_table = new javax.swing.JTable();
        opcion_panel = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        modificar_button = new javax.swing.JButton();
        eliminar_button = new javax.swing.JButton();
        limpiar_button = new javax.swing.JButton();
        buscar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel.setBackground(new java.awt.Color(58, 159, 220));
        title_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        title_panel.setPreferredSize(new java.awt.Dimension(623, 94));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profesor");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        title_panelLayout.setVerticalGroup(
            title_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title_panelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        crud_panel.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel2.setText("ID");

        jLabel3.setText("Nombre");

        jLabel4.setText("Edad");

        nombre_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        nombre_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_textfield.setText("nombre");
        nombre_textfield.setToolTipText("Introduce tu cedula");
        nombre_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        nombre_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        nombre_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        nombre_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        nombre_textfield.setName(""); // NOI18N
        nombre_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_textfieldActionPerformed(evt);
            }
        });

        edad_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        edad_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad_textfield.setText("edad");
        edad_textfield.setToolTipText("Introduce tu cedula");
        edad_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        edad_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        edad_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        edad_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        edad_textfield.setName(""); // NOI18N
        edad_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edad_textfieldActionPerformed(evt);
            }
        });

        correo_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        correo_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo_textfield.setText("correo");
        correo_textfield.setToolTipText("Introduce tu cedula");
        correo_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        correo_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        correo_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        correo_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        correo_textfield.setName(""); // NOI18N
        correo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo_textfieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo");

        jLabel6.setText("Sexo");

        sexo_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        sexo_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sexo_textfield.setText("sexo");
        sexo_textfield.setToolTipText("Introduce tu cedula");
        sexo_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        sexo_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        sexo_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        sexo_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        sexo_textfield.setName(""); // NOI18N
        sexo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexo_textfieldActionPerformed(evt);
            }
        });

        especialidad_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        especialidad_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        especialidad_textfield.setText("especialidad");
        especialidad_textfield.setToolTipText("Introduce tu cedula");
        especialidad_textfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        especialidad_textfield.setMargin(new java.awt.Insets(8, 8, 8, 8));
        especialidad_textfield.setMaximumSize(new java.awt.Dimension(100, 20));
        especialidad_textfield.setMinimumSize(new java.awt.Dimension(100, 20));
        especialidad_textfield.setName(""); // NOI18N
        especialidad_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especialidad_textfieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Especialidad");

        javax.swing.GroupLayout crud_panelLayout = new javax.swing.GroupLayout(crud_panel);
        crud_panel.setLayout(crud_panelLayout);
        crud_panelLayout.setHorizontalGroup(
            crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crud_panelLayout.createSequentialGroup()
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(crud_panelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(crud_panelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(edad_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(38, 38, 38)
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidad_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        crud_panelLayout.setVerticalGroup(
            crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crud_panelLayout.createSequentialGroup()
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edad_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(crud_panelLayout.createSequentialGroup()
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(crud_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especialidad_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        nombre_textfield.getAccessibleContext().setAccessibleDescription("");

        content_panel.setBackground(new java.awt.Color(255, 255, 255));
        content_panel.setPreferredSize(new java.awt.Dimension(572, 500));

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        profesores_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        profesores_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profesores_label.setText("Listado de Profesores");
        profesores_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        profesores_label.setPreferredSize(new java.awt.Dimension(120, 32));

        profesores_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        profesores_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Profesor", "Edad", "Correo", "Sexo", "Especialidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        profesores_table.setFocusable(false);
        profesores_table.setGridColor(new java.awt.Color(37, 92, 125));
        profesores_table.setRequestFocusEnabled(false);
        profesores_table.setRowHeight(48);
        profesores_table.setRowSelectionAllowed(false);
        profesores_table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        profesores_table.setShowGrid(true);
        profesores_table.getTableHeader().setReorderingAllowed(false);
        profesores_table.setUpdateSelectionOnSort(false);
        profesores_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(profesores_table);

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profesores_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(profesores_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout content_panelLayout = new javax.swing.GroupLayout(content_panel);
        content_panel.setLayout(content_panelLayout);
        content_panelLayout.setHorizontalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(table_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        content_panelLayout.setVerticalGroup(
            content_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        opcion_panel.setBackground(new java.awt.Color(255, 255, 255));
        opcion_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

        save_button.setBackground(new java.awt.Color(58, 159, 220));
        save_button.setForeground(new java.awt.Color(255, 255, 255));
        save_button.setText("Guardar");
        save_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        modificar_button.setBackground(new java.awt.Color(58, 159, 220));
        modificar_button.setForeground(new java.awt.Color(255, 255, 255));
        modificar_button.setText("modificar");
        modificar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        modificar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_buttonActionPerformed(evt);
            }
        });

        eliminar_button.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_button.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_button.setText("Eliminar");
        eliminar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        eliminar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_buttonActionPerformed(evt);
            }
        });

        limpiar_button.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_button.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_button.setText("Limpiar");
        limpiar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        limpiar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_buttonActionPerformed(evt);
            }
        });

        buscar_button.setBackground(new java.awt.Color(58, 159, 220));
        buscar_button.setForeground(new java.awt.Color(255, 255, 255));
        buscar_button.setText("Bucar");
        buscar_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        buscar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcion_panelLayout = new javax.swing.GroupLayout(opcion_panel);
        opcion_panel.setLayout(opcion_panelLayout);
        opcion_panelLayout.setHorizontalGroup(
            opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcion_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(buscar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        opcion_panelLayout.setVerticalGroup(
            opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcion_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(opcion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(content_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                        .addComponent(opcion_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(crud_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(crud_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(opcion_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
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

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

    }//GEN-LAST:event_save_buttonActionPerformed

    private void modificar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_buttonActionPerformed

    private void eliminar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminar_buttonActionPerformed

    private void limpiar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiar_buttonActionPerformed

    private void buscar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_buttonActionPerformed

    private void nombre_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_textfieldActionPerformed

    private void edad_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edad_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edad_textfieldActionPerformed

    private void correo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo_textfieldActionPerformed

    private void sexo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexo_textfieldActionPerformed

    private void especialidad_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_especialidad_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_especialidad_textfieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JButton buscar_button;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JPanel content_panel;
    private javax.swing.JTextField correo_textfield;
    private javax.swing.JPanel crud_panel;
    private javax.swing.JTextField edad_textfield;
    private javax.swing.JButton eliminar_button;
    private javax.swing.JTextField especialidad_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_button;
    private javax.swing.JButton modificar_button;
    private javax.swing.JTextField nombre_textfield;
    private javax.swing.JPanel opcion_panel;
    private javax.swing.JLabel profesores_label;
    private javax.swing.JTable profesores_table;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField sexo_textfield;
    private javax.swing.JPanel table_panel;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
