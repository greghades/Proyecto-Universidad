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

import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.TresColumnasModel;

public class ListadoEstudianteTresTableModel extends AbstractTableModel {

    private final List<TresColumnasModel> datasource;
    private String[] columnNames = {"Cedula", "Nombre"};

    public ListadoEstudianteTresTableModel(List<TresColumnasModel> datasource, String extra) {
        this.datasource = datasource;
        columnNames = Arrays.copyOf(columnNames, columnNames.length + 1);
        columnNames[columnNames.length - 1] = extra;
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
        TresColumnasModel data = datasource.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                data.getCedula();
            case 1 ->
                data.getNombre();
            case 2 ->
                data.getExtra();
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
