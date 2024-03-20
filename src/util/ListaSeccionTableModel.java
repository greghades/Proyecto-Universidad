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
package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.ListadoSeccionModel;
import java.util.Arrays;

public class ListaSeccionTableModel extends AbstractTableModel{
    private final List<ListadoSeccionModel> listadoSeccion;
    private static final String[] columnNames = {"Seccion", "Asignatura", "Docente", "Carrera","Decanato","Promedio seccion","Numero Aprobados","Numero Aplazados","Estudiantes Por Encima del Promedio","Estudiantes Por Debajo del Promedio"};
    

    public ListaSeccionTableModel(List<ListadoSeccionModel> listadoSeccion) {
        this.listadoSeccion = listadoSeccion;
        
    }

    public void removeRow(int row) {
        // remove a row from your internal data structure
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return listadoSeccion.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListadoSeccionModel lSeccion = listadoSeccion.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                lSeccion.getSeccion();
            case 1 ->
                lSeccion.getAsignatura();
            case 2 ->
                lSeccion.getDocente();
            case 3 ->
                lSeccion.getCarrera();
            case 4 ->
                lSeccion.getDecanato();
            case 5 ->
                lSeccion.getPromedio_seccion();
            case 6 ->
                lSeccion.getNumero_aprobados();
            case 7 ->
                lSeccion.getNumero_aplazados();
            case 8 ->
                Arrays.toString(lSeccion.getEstudiantesPorEncimaPromedio());
            case 9 ->
                Arrays.toString(lSeccion.getEstudiantesPorDebajoPromedio());
            default ->
                null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                String.class;
            case 1 ->
                String.class;
            case 2 ->
                String.class;
            case 3 ->
                String.class;
            case 4 ->
                String.class;
            case 5 ->
                Float.class;
            case 6 ->
                Integer.class;
            case 7 ->
                Integer.class;
            case 8 ->
                String.class;
            case 9 ->
                String.class;
            default ->
                null;
        };
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;// Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
       
    }

   
}
