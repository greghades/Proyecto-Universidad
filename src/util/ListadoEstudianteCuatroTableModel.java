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

import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.CuatroColumnasModel;

public class ListadoEstudianteCuatroTableModel extends AbstractTableModel {

    private final List<CuatroColumnasModel> datasource;
    private String[] columnNames = {"Cedula", "Nombre", "Calificación promedio"};

    public ListadoEstudianteCuatroTableModel(List<CuatroColumnasModel> datasource, String extra) {
        this.datasource = datasource;

        String[] newColumnNames = new String[columnNames.length + 1];
        int extraIndex = 2; // Índice donde deseas insertar el valor extra
        for (int i = 0; i < newColumnNames.length; i++) {
            if (i < extraIndex) {
                newColumnNames[i] = columnNames[i];
            } else if (i == extraIndex) {
                newColumnNames[i] = extra;
            } else {
                newColumnNames[i] = columnNames[i - 1];
            }
        }
        columnNames = newColumnNames;
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
        CuatroColumnasModel data = datasource.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                data.getCedula();
            case 1 ->
                data.getNombre();
            case 2 ->
                data.getExtra();
            case 3 ->
                data.getPromedio();
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
            default ->
                null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }
}
