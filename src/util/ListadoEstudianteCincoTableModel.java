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
import models.CincoColumnasModel;

public class ListadoEstudianteCincoTableModel extends AbstractTableModel {

    private final List<CincoColumnasModel> datasource;
    private final String[] columnNames = {"Num", "Cedula", "Nombre", "Género", "Carrera", "Decanato"};

    public ListadoEstudianteCincoTableModel(List<CincoColumnasModel> datasource) {
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
        CincoColumnasModel data = datasource.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                rowIndex + 1;
            case 1 ->
                data.getCedula();
            case 2 ->
                data.getNombre();
            case 3 ->
                data.getGenero();
            case 4 ->
                data.getCarrera();
            case 5 ->
                data.getDecanato();
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
