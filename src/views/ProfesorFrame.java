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

import controllers.ProfesorController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import models.Profesor;


public class ProfesorFrame extends javax.swing.JFrame {
    public ProfesorController controller;
    
    public ProfesorFrame(ProfesorController controller) {
        this.controller = controller;
        initComponents();
        agregarListener(controller);
    }
    
    private void agregarListener(ActionListener accion){
        volver_prof_btn.addActionListener(accion);
        cedula_profesor_btn.addActionListener(accion);
        agg_prof_Btn.addActionListener(accion);
        eliminar_prof_Btn.addActionListener(accion);
        modif_prof_Btn.addActionListener(accion);
        limpiar_prof_Btn.addActionListener(accion);
    }
    
    public void mostrarEstadoInicial() {
        info_prof_Panel.setVisible(false);
    }
    
    public void rellenarInfoInicial(Profesor profesor) {
        nomb_prof_Label.setText(profesor.getNombre());
        correo_prof_Label.setText(profesor.getCorreo());
        edad_prof_Label.setText(Integer.toString(profesor.getEdad()));
        genero_profe_Label.setText(profesor.getSexo());
        especialidad_Label.setText(profesor.getEspecialidad());
        info_prof_Panel.setVisible(true);
    }
    
    public String getCedula() {
        return cedula_prof_TextField.getText();
    }
    
    public JButton getVolver_prof_btn() {
        return volver_prof_btn;
    }
    
    public JButton getCedula_profesor_btn() {
        return cedula_profesor_btn;
    }
    
    public JButton getAgg_prof_Btn() {
        return agg_prof_Btn;
    }
    
    public JButton getEliminar_prof_Btn() {
        return eliminar_prof_Btn;
    }
    
    public JButton getModif_prof_Btn() {
        return modif_prof_Btn;
    }
    
    public JButton getLimpiar_prof_Btn() {
        return limpiar_prof_Btn;
    }

   
    public ProfesorFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_panel1 = new javax.swing.JPanel();
        title_Label = new javax.swing.JLabel();
        volver_prof_btn = new javax.swing.JButton();
        body_prof_Panel = new javax.swing.JPanel();
        ID_prof_Panel = new javax.swing.JPanel();
        ingresar_label = new javax.swing.JLabel();
        cedula_prof_TextField = new javax.swing.JTextField();
        cedula_profesor_btn = new javax.swing.JButton();
        crud_prof_Panel = new javax.swing.JPanel();
        nombre_prof_Label = new javax.swing.JLabel();
        correo_prof_Label = new javax.swing.JLabel();
        edad_prof_Label = new javax.swing.JLabel();
        sexo_prof_Label = new javax.swing.JLabel();
        especialidad_prof_Label = new javax.swing.JLabel();
        nombre_prof_TextField = new javax.swing.JTextField();
        correo_prof_TextField = new javax.swing.JTextField();
        edad_prof_TextField = new javax.swing.JTextField();
        sexo_prof_TextField = new javax.swing.JTextField();
        especialidad_prof_TextField = new javax.swing.JTextField();
        opciones_prof_Panel = new javax.swing.JPanel();
        agg_prof_Btn = new javax.swing.JButton();
        eliminar_prof_Btn = new javax.swing.JButton();
        modif_prof_Btn = new javax.swing.JButton();
        limpiar_prof_Btn = new javax.swing.JButton();
        info_prof_Panel = new javax.swing.JPanel();
        nombre_prof_title_Label = new javax.swing.JLabel();
        nomb_prof_Label = new javax.swing.JLabel();
        correo_prof_title_Label = new javax.swing.JLabel();
        correo_profe_Label = new javax.swing.JLabel();
        edad_title_prof_Label = new javax.swing.JLabel();
        edad_profe_Label = new javax.swing.JLabel();
        genero_title_prof_Label = new javax.swing.JLabel();
        genero_profe_Label = new javax.swing.JLabel();
        especialidad_title_Label = new javax.swing.JLabel();
        especialidad_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_panel1.setBackground(new java.awt.Color(58, 159, 220));
        title_panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        title_Label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title_Label.setForeground(new java.awt.Color(242, 242, 242));
        title_Label.setText("Profesor");

        volver_prof_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volver_prof_btn.setForeground(new java.awt.Color(58, 159, 220));
        volver_prof_btn.setText("<Volver");
        volver_prof_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout title_panel1Layout = new javax.swing.GroupLayout(title_panel1);
        title_panel1.setLayout(title_panel1Layout);
        title_panel1Layout.setHorizontalGroup(
            title_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(volver_prof_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(title_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(340, 340, 340))
        );
        title_panel1Layout.setVerticalGroup(
            title_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_panel1Layout.createSequentialGroup()
                .addGroup(title_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(title_panel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(volver_prof_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(title_panel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(title_Label)))
                .addGap(35, 35, 35))
        );

        body_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        body_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        ID_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));

        ingresar_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ingresar_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar_label.setText("Ingresar ID del profesor");
        ingresar_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cedula_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula_prof_TextField.setText("ID");
        cedula_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        cedula_profesor_btn.setBackground(new java.awt.Color(58, 159, 220));
        cedula_profesor_btn.setForeground(new java.awt.Color(255, 255, 255));
        cedula_profesor_btn.setText("Buscar");
        cedula_profesor_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout ID_prof_PanelLayout = new javax.swing.GroupLayout(ID_prof_Panel);
        ID_prof_Panel.setLayout(ID_prof_PanelLayout);
        ID_prof_PanelLayout.setHorizontalGroup(
            ID_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ID_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(ID_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ID_prof_PanelLayout.createSequentialGroup()
                        .addComponent(ingresar_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ID_prof_PanelLayout.createSequentialGroup()
                        .addComponent(cedula_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(cedula_profesor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        ID_prof_PanelLayout.setVerticalGroup(
            ID_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ID_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ingresar_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(ID_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_profesor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        crud_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));

        nombre_prof_Label.setText("Nombre:");

        correo_prof_Label.setText("Correo:");

        edad_prof_Label.setText("Edad:");

        sexo_prof_Label.setText("Sexo:");

        especialidad_prof_Label.setText("Especialidad:");

        nombre_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        nombre_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_prof_TextField.setText("Nombre");
        nombre_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        correo_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        correo_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo_prof_TextField.setText("Correo");
        correo_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        edad_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        edad_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad_prof_TextField.setText("Edad");
        edad_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        sexo_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        sexo_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sexo_prof_TextField.setText("Sexo");
        sexo_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        especialidad_prof_TextField.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        especialidad_prof_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        especialidad_prof_TextField.setText("Especialidad");
        especialidad_prof_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout crud_prof_PanelLayout = new javax.swing.GroupLayout(crud_prof_Panel);
        crud_prof_Panel.setLayout(crud_prof_PanelLayout);
        crud_prof_PanelLayout.setHorizontalGroup(
            crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(especialidad_prof_Label)
                    .addComponent(sexo_prof_Label)
                    .addComponent(edad_prof_Label)
                    .addComponent(correo_prof_Label)
                    .addComponent(nombre_prof_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_prof_TextField)
                    .addComponent(correo_prof_TextField)
                    .addComponent(edad_prof_TextField)
                    .addComponent(sexo_prof_TextField)
                    .addComponent(especialidad_prof_TextField)))
        );
        crud_prof_PanelLayout.setVerticalGroup(
            crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crud_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_prof_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_prof_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edad_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_prof_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexo_prof_Label))
                .addGap(16, 16, 16)
                .addGroup(crud_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especialidad_prof_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidad_prof_Label))
                .addGap(16, 16, 16))
        );

        opciones_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));

        agg_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        agg_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        agg_prof_Btn.setText("Agregar");
        agg_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        eliminar_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        eliminar_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_prof_Btn.setText("Eliminar");
        eliminar_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        modif_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        modif_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        modif_prof_Btn.setText("Modificar");
        modif_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        limpiar_prof_Btn.setBackground(new java.awt.Color(58, 159, 220));
        limpiar_prof_Btn.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_prof_Btn.setText("Limpiar");
        limpiar_prof_Btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        javax.swing.GroupLayout opciones_prof_PanelLayout = new javax.swing.GroupLayout(opciones_prof_Panel);
        opciones_prof_Panel.setLayout(opciones_prof_PanelLayout);
        opciones_prof_PanelLayout.setHorizontalGroup(
            opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opciones_prof_PanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agg_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175)
                .addGroup(opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modif_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        opciones_prof_PanelLayout.setVerticalGroup(
            opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opciones_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agg_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modif_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(opciones_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_prof_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        info_prof_Panel.setBackground(new java.awt.Color(255, 255, 255));
        info_prof_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 92, 125), 2, true));

        nombre_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombre_prof_title_Label.setText("Nombre:");

        nomb_prof_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomb_prof_Label.setText("Nombre Profesor");

        correo_prof_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        correo_prof_title_Label.setText("Correo:");

        correo_profe_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        correo_profe_Label.setText("Correo Profesor");

        edad_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        edad_title_prof_Label.setText("Edad:");

        edad_profe_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        edad_profe_Label.setText("Edad Profesor");

        genero_title_prof_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        genero_title_prof_Label.setText("Género:");

        genero_profe_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        genero_profe_Label.setText("Género Profesor");

        especialidad_title_Label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        especialidad_title_Label.setText("Especialidad:");

        especialidad_Label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        especialidad_Label.setText("Especialidad Profesor");

        javax.swing.GroupLayout info_prof_PanelLayout = new javax.swing.GroupLayout(info_prof_Panel);
        info_prof_Panel.setLayout(info_prof_PanelLayout);
        info_prof_PanelLayout.setHorizontalGroup(
            info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info_prof_PanelLayout.createSequentialGroup()
                        .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomb_prof_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(nombre_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genero_profe_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correo_prof_title_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(correo_profe_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(especialidad_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(especialidad_title_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(genero_title_prof_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edad_title_prof_Label)
                    .addComponent(edad_profe_Label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        info_prof_PanelLayout.setVerticalGroup(
            info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_prof_title_Label)
                    .addComponent(correo_prof_title_Label)
                    .addComponent(edad_title_prof_Label))
                .addGap(6, 6, 6)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomb_prof_Label)
                    .addComponent(correo_profe_Label)
                    .addComponent(edad_profe_Label))
                .addGap(16, 16, 16)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_title_prof_Label)
                    .addComponent(especialidad_title_Label))
                .addGap(6, 6, 6)
                .addGroup(info_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_profe_Label)
                    .addComponent(especialidad_Label))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout body_prof_PanelLayout = new javax.swing.GroupLayout(body_prof_Panel);
        body_prof_Panel.setLayout(body_prof_PanelLayout);
        body_prof_PanelLayout.setHorizontalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addGroup(body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, body_prof_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(crud_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ID_prof_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opciones_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(body_prof_PanelLayout.createSequentialGroup()
                        .addComponent(info_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        body_prof_PanelLayout.setVerticalGroup(
            body_prof_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_prof_PanelLayout.createSequentialGroup()
                .addComponent(ID_prof_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(crud_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_prof_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(info_prof_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(opciones_prof_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(body_prof_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ID_prof_Panel;
    private javax.swing.JButton agg_prof_Btn;
    private javax.swing.JPanel body_prof_Panel;
    public javax.swing.JTextField cedula_prof_TextField;
    private javax.swing.JButton cedula_profesor_btn;
    private javax.swing.JLabel correo_prof_Label;
    public javax.swing.JTextField correo_prof_TextField;
    private javax.swing.JLabel correo_prof_title_Label;
    private javax.swing.JLabel correo_profe_Label;
    private javax.swing.JPanel crud_prof_Panel;
    private javax.swing.JLabel edad_prof_Label;
    public javax.swing.JTextField edad_prof_TextField;
    private javax.swing.JLabel edad_profe_Label;
    private javax.swing.JLabel edad_title_prof_Label;
    private javax.swing.JButton eliminar_prof_Btn;
    private javax.swing.JLabel especialidad_Label;
    private javax.swing.JLabel especialidad_prof_Label;
    public javax.swing.JTextField especialidad_prof_TextField;
    private javax.swing.JLabel especialidad_title_Label;
    private javax.swing.JLabel genero_profe_Label;
    private javax.swing.JLabel genero_title_prof_Label;
    private javax.swing.JPanel info_prof_Panel;
    private javax.swing.JLabel ingresar_label;
    private javax.swing.JButton limpiar_prof_Btn;
    private javax.swing.JButton modif_prof_Btn;
    private javax.swing.JLabel nomb_prof_Label;
    private javax.swing.JLabel nombre_prof_Label;
    public javax.swing.JTextField nombre_prof_TextField;
    private javax.swing.JLabel nombre_prof_title_Label;
    private javax.swing.JPanel opciones_prof_Panel;
    private javax.swing.JLabel sexo_prof_Label;
    public javax.swing.JTextField sexo_prof_TextField;
    private javax.swing.JLabel title_Label;
    private javax.swing.JPanel title_panel1;
    private javax.swing.JButton volver_prof_btn;
    // End of variables declaration//GEN-END:variables

   /* public void mostrarEstadoInicial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getCedula() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}*/
