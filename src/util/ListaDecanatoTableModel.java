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
import models.ListadoDecanatoModel;

public class ListaDecanatoTableModel extends AbstractTableModel{
    private final List<ComponenteUniversitario> listadoDecanato;
    private static final String[] columnNames = {"Id Decanato", "Nombre", "Direccion"};
    

    public ListaDecanatoTableModel(List<ComponenteUniversitario> listadoDecanato) {
        this.listadoDecanato = listadoDecanato;
        
    }

    public void removeRow(int row) {
        // remove a row from your internal data structure
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return listadoDecanato.size();
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
        ComponenteUniversitario lDecanato = listadoDecanato.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                lDecanato.getId();
            case 1 ->
                lDecanato.getNombre();
            case 2 ->
                lDecanato.getDireccion();
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
        return false;// Editable checkboxes and toggle lists
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
       
    }

   
}
