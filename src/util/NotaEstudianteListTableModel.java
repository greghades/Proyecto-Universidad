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
import models.NotaEstudianteListModel;

public class NotaEstudianteListTableModel extends AbstractTableModel {

    private final List<NotaEstudianteListModel> datasource;
    private String[] columnNames = {"Num", "Cedula", "Nombre", "Correo", "Carrera", "Seccion", "Nota"};

    public NotaEstudianteListTableModel(List<NotaEstudianteListModel> datasource) {
        this.datasource = datasource;
    }

    public void removeRow(int row) {
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return datasource.size();
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
        NotaEstudianteListModel data = datasource.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                rowIndex + 1;
            case 1 ->
                data.getCedula();
            case 2 ->
                data.getNombre();
            case 3 ->
                data.getCorreo();
            case 4 ->
                data.getCarrera();
            case 5 ->
                data.getSeccion();
            case 6 ->
                data.getNota();
            default ->
                null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                Integer.class;
            case 1 ->
                String.class;
            case 2 ->
                String.class;
            case 3 ->
                String.class;
            case 4 ->
                String.class;
            case 5 ->
                String.class;
            case 6 ->
                Float.class;
            default ->
                null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 6; // Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (columnIndex == 6) { // Solo actualizar la última columna
            // Aquí puedes realizar la validación de entrada antes de actualizar el valor
            datasource.get(rowIndex).setNota((Float) value);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
