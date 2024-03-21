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
import models.Asignatura;

public class RetiroTableModel extends AbstractTableModel {

    private final List<Asignatura> asignaturas;
    private static String[] columnNames = {"ID", "Asignatura", "Carga academica", "Seccion", "Retirar"};
    private final CheckableCellEventListener listener;

    public RetiroTableModel(List<Asignatura> asignaturas, CheckableCellEventListener listener) {
        this.asignaturas = asignaturas;
        this.listener = listener;
    }

    public void removeRow(int row) {
        // remove a row from your internal data structure
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return asignaturas.size();
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
        Asignatura asignatura = asignaturas.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                asignatura.getId();
            case 1 ->
                asignatura.getNombre();
            case 2 ->
                asignatura.getCargaAcademica();
            case 3 ->
                String.format("Seccion %s", asignatura.getSeccion());
            case 4 ->
                asignatura.esRetirada();
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
                Integer.class;
            case 3 ->
                String.class;
            case 4 ->
                Boolean.class;
            default ->
                null;
        };

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4; // Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Asignatura subject = asignaturas.get(rowIndex);
        switch (columnIndex) {
            case 4 -> {
                subject.setInclusion((boolean) value);
                fireTableCellUpdated(rowIndex, columnIndex); // Update table
                listener.onCheckboxValueChanged(rowIndex, (boolean) value);
            }
        }
    }

    public void addSubject(Asignatura subject) {

    }
}
