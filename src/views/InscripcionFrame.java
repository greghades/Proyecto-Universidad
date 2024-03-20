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

import util.InscripcionTableModel;
import controllers.InscripcionController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Asignatura;
import models.Profesor;
import models.Seccion;

public class InscripcionFrame extends javax.swing.JFrame {

    public InscripcionController controller;
    public ArrayList<JPanel> materiaPanels = new ArrayList<JPanel>();

    public InscripcionFrame(InscripcionController controller) {
        super("Proyecto: Universidad Central de Lara");
        this.controller = controller;

        initComponents();
        displayUI(false);
        agregarListeners(controller);
        configuracionInicial();
    }

    public void actualizarPanelDeMaterias(boolean mostrar, Asignatura asignatura, Profesor profesor, ArrayList<Seccion> secciones) {
        toggle_panel.setVisible(true);
        String asignaturaFormateada = String.format("<html><font size=\"4\" color=\"#3A9FDC\">Materia:</font> %s</html>", asignatura.getNombre());
        if (mostrar) {
            // Create a container panel to hold entryPanel and separatorPanel
            JPanel containerPanel = new JPanel();
            containerPanel.setBackground(Color.WHITE);
            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

            // Create entryPanel as before
            JPanel entryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            entryPanel.setBackground(Color.WHITE);
            JLabel materiaLabel = new JLabel();
            materiaLabel.setText(asignaturaFormateada);
            materiaLabel.setPreferredSize(new Dimension(200, materiaLabel.getPreferredSize().height));
            JLabel profesorLabel = new JLabel("<html><font size=\"4\" color=\"#3A9FDC\">Profesor:</font> " + profesor.getNombre() + "</html>");
            profesorLabel.setPreferredSize(new Dimension(180, materiaLabel.getPreferredSize().height));

            entryPanel.add(materiaLabel);
            entryPanel.add(Box.createHorizontalStrut(12));
            entryPanel.add(profesorLabel);

            // Create a JComboBox with the values of the secciones array
            String[] numerosDeSeccion = secciones.stream().map(seccion -> String.format("Seccion %s", seccion.getNumero())).toArray(String[]::new);
            JComboBox<String> comboBox = new JComboBox<>(numerosDeSeccion);
            comboBox.addActionListener(controller);
            comboBox.putClientProperty("asignatura", asignatura);
            comboBox.putClientProperty("secciones", secciones);

            entryPanel.add(Box.createHorizontalStrut(12));
            entryPanel.add(comboBox);

            // Add entryPanel to containerPanel
            containerPanel.add(Box.createVerticalStrut(4));
            containerPanel.add(entryPanel);
            containerPanel.add(Box.createVerticalStrut(8));

            // Create separator panel as before (assuming createSeparatorPanel() returns a JPanel)
            containerPanel.add(createSeparatorPanel());
            containerPanel.add(Box.createVerticalStrut(4));

            // Add containerPanel to toggle_panel
            toggle_panel.add(containerPanel);
            materiaPanels.add(containerPanel);
            toggle_panel.revalidate();
            toggle_panel.repaint();
        } else {
            Component[] components = toggle_panel.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel containerPanel) {
                    JPanel entryPanel = (JPanel) containerPanel.getComponent(1);
                    JLabel materiaLabel = (JLabel) entryPanel.getComponent(0);
                    if (materiaLabel.getText().equals(asignaturaFormateada)) {
                        toggle_panel.remove(containerPanel);
                        materiaPanels.remove(containerPanel);
                        toggle_panel.revalidate();
                        toggle_panel.repaint();
                        break;
                    }
                }
            }
        }

        if (toggle_panel.getComponents().length == 0) {
            toggle_panel.setVisible(false);
            inscripcion_button.setVisible(false);
        } else {
            toggle_panel.setVisible(true);
            inscripcion_button.setVisible(true);
        }
    }

    public void displayUI(boolean should) {
        info_panel.setVisible(should);
        table_panel.setVisible(should);
    }

    private void configuracionInicial() {
        inscripcion_button.setVisible(false);
        toggle_panel.setVisible(false);
        toggle_panel.setLayout(new BoxLayout(toggle_panel, BoxLayout.Y_AXIS));
        // Obtiene el borde actual del toggle_panel
        Border existingBorder = toggle_panel.getBorder();
        // Crea un EmptyBorder con el margen interno de 20 píxeles
        Border emptyBorder = BorderFactory.createEmptyBorder(16, 12, 16, 12);
        // Combina el borde existente con el borde interno
        Border compoundBorder = BorderFactory.createCompoundBorder(existingBorder, emptyBorder);
        // Establece el borde compuesto en el toggle_panel
        toggle_panel.setBorder(compoundBorder);
    }

    public void setupTable(List<Asignatura> asignaturas) {
        limpiarTabla();

        // Instanciar el modelo para pintar la tabla.
        InscripcionTableModel model = new InscripcionTableModel(asignaturas, controller);
        materias_table.setModel(model);

        configurarColumnas();
    }

    private JSeparator createSeparatorPanel() {
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.LIGHT_GRAY); // Set foreground color for the line
        return separator;
    }

    public void limpiarTabla() {
        // Limpiar la tabla para evitar duplicados.
        if (materias_table.getModel().getRowCount() > 0) {
            TableColumnModel columnModel = materias_table.getColumnModel();
            while (columnModel.getColumnCount() > 0) {
                TableColumn column = columnModel.getColumn(0); // Get the first column
                columnModel.removeColumn(column);
            }

            materiaPanels.removeAll(materiaPanels);
            inscripcion_button.setVisible(false);
            toggle_panel.removeAll();
            toggle_panel.setVisible(false);
            toggle_panel.revalidate();
            toggle_panel.repaint();
        }
    }

    private void configurarColumnas() {
        // Asignar un ancho mayor a la primera columna
        TableColumnModel columnModel = materias_table.getColumnModel();
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
        for (int x = 0; x < materias_table.getColumnCount(); x++) {
            if (x != 3) {
                materias_table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        }
    }

    private void agregarListeners(ActionListener accion) {
        cedula_button.addActionListener(accion);
        back_button.addActionListener(accion);
        inscripcion_button.addActionListener(accion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        title_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        body_panel = new javax.swing.JPanel();
        info_panel = new javax.swing.JPanel();
        nombre_title_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        sex_title_label = new javax.swing.JLabel();
        sex_label = new javax.swing.JLabel();
        carrera_title_label = new javax.swing.JLabel();
        carrera_label = new javax.swing.JLabel();
        edad_title_label = new javax.swing.JLabel();
        edad_label = new javax.swing.JLabel();
        correo_title_label = new javax.swing.JLabel();
        correo_label = new javax.swing.JLabel();
        table_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        materias_table = new javax.swing.JTable();
        toggle_panel = new javax.swing.JPanel();
        materias_label = new javax.swing.JLabel();
        inscripcion_button = new javax.swing.JButton();
        cedula_panel = new javax.swing.JPanel();
        cedula_textfield = new javax.swing.JTextField();
        cedula_label = new javax.swing.JLabel();
        cedula_button = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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
                .addContainerGap()
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title_label)
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
                        .addGap(24, 24, 24)
                        .addComponent(title_label)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        body_panel.setBackground(new java.awt.Color(255, 255, 255));
        body_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        info_panel.setBackground(new java.awt.Color(255, 255, 255));
        info_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 92, 125), 2));

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

        edad_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_title_label.setText("Edad");
        edad_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        edad_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edad_label.setText("Edad");
        edad_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_title_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_title_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_title_label.setText("Correo");
        correo_title_label.setPreferredSize(new java.awt.Dimension(120, 32));

        correo_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo_label.setText("CorreoEstudiante");
        correo_label.setPreferredSize(new java.awt.Dimension(120, 32));

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(correo_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(correo_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edad_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edad_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sex_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carrera_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 107, Short.MAX_VALUE))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addComponent(edad_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sex_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info_panelLayout.createSequentialGroup()
                        .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addComponent(carrera_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carrera_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(info_panelLayout.createSequentialGroup()
                                .addComponent(nombre_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correo_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        table_panel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        materias_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        materias_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Carga académica", "Inclusión", "Sección"
            }
        ));
        materias_table.setFocusable(false);
        materias_table.setGridColor(new java.awt.Color(37, 92, 125));
        materias_table.setRequestFocusEnabled(false);
        materias_table.setRowHeight(48);
        materias_table.setRowSelectionAllowed(false);
        materias_table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        materias_table.setShowGrid(true);
        materias_table.getTableHeader().setReorderingAllowed(false);
        materias_table.setUpdateSelectionOnSort(false);
        materias_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(materias_table);

        toggle_panel.setBackground(new java.awt.Color(255, 255, 255));
        toggle_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout toggle_panelLayout = new javax.swing.GroupLayout(toggle_panel);
        toggle_panel.setLayout(toggle_panelLayout);
        toggle_panelLayout.setHorizontalGroup(
            toggle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        toggle_panelLayout.setVerticalGroup(
            toggle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        materias_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        materias_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        materias_label.setText("Listado de materias");
        materias_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        materias_label.setPreferredSize(new java.awt.Dimension(120, 32));

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggle_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(materias_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(materias_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(toggle_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        inscripcion_button.setBackground(new java.awt.Color(58, 159, 220));
        inscripcion_button.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        inscripcion_button.setForeground(new java.awt.Color(255, 255, 255));
        inscripcion_button.setText("Inscribir materias");
        inscripcion_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));
        inscripcion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscripcion_buttonActionPerformed(evt);
            }
        });

        cedula_panel.setBackground(new java.awt.Color(255, 255, 255));

        cedula_textfield.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_textfield.setText("Cedula");
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

        javax.swing.GroupLayout cedula_panelLayout = new javax.swing.GroupLayout(cedula_panel);
        cedula_panel.setLayout(cedula_panelLayout);
        cedula_panelLayout.setHorizontalGroup(
            cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedula_panelLayout.createSequentialGroup()
                .addGroup(cedula_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cedula_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cedula_panelLayout.createSequentialGroup()
                        .addComponent(cedula_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(cedula_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inscripcion_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(body_panelLayout.createSequentialGroup()
                        .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(table_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(inscripcion_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jScrollPane2.setViewportView(body_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cedula_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_textfieldActionPerformed

    }//GEN-LAST:event_cedula_textfieldActionPerformed

    public void setCarrera(String text) {
        this.carrera_label.setText(text);
    }

    public void setCorreo(String text) {
        this.correo_label.setText(text);
    }

    public void setEdad(String text) {
        this.edad_label.setText(text);
    }

    public void setNombre(String text) {
        this.nombre_label.setText(text);
    }

    public void setSexo(String text) {
        this.sex_label.setText(text);
    }

    public String getCedula() {
        return cedula_textfield.getText();
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JButton getCedula_button() {
        return cedula_button;
    }

    public JButton getInscripcion_button() {
        return inscripcion_button;
    }

    private void cedula_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_buttonActionPerformed

    }//GEN-LAST:event_cedula_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed

    }//GEN-LAST:event_back_buttonActionPerformed

    private void inscripcion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscripcion_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inscripcion_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel body_panel;
    private javax.swing.JLabel carrera_label;
    private javax.swing.JLabel carrera_title_label;
    private javax.swing.JButton cedula_button;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JPanel cedula_panel;
    private javax.swing.JTextField cedula_textfield;
    private javax.swing.JLabel correo_label;
    private javax.swing.JLabel correo_title_label;
    private javax.swing.JLabel edad_label;
    private javax.swing.JLabel edad_title_label;
    private javax.swing.JPanel info_panel;
    private javax.swing.JButton inscripcion_button;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel materias_label;
    private javax.swing.JTable materias_table;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nombre_title_label;
    private javax.swing.JLabel sex_label;
    private javax.swing.JLabel sex_title_label;
    private javax.swing.JPanel table_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_panel;
    private javax.swing.JPanel toggle_panel;
    // End of variables declaration//GEN-END:variables

    public Object getButton1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getButton2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
