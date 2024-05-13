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

import compose.ComponenteUniversitario;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import models.ListadoCarreraModel;

public class ListaCarreraTableModel extends AbstractTableModel{
    private final List<ComponenteUniversitario> listadoCarrera;
    private static final String[] columnNames = {"Id", "Nombre", "Modalidad","Duración"};
    

    public ListaCarreraTableModel(List<ComponenteUniversitario> listadoCarrera) {
        this.listadoCarrera = listadoCarrera;
        
    }

    public void removeRow(int row) {
        // remove a row from your internal data structure
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return listadoCarrera.size();
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
        ComponenteUniversitario lCarrera = listadoCarrera.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                lCarrera.getId();
            case 1 ->
                lCarrera.getNombre();
            case 2 ->
                lCarrera.getModalidad();
            case 3 ->
                lCarrera.getDuracion();
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
        return false;// Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
       
    }

   
}
