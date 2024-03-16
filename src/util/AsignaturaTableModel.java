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

public class AsignaturaTableModel extends AbstractTableModel {

  private final List<Asignatura> asignaturas;
  private static final String[] columnNames = {"Materia", "Carga Academica", "Inclusion", "Seccion"};

  public AsignaturaTableModel(List<Asignatura> asignaturas) {
    this.asignaturas = asignaturas;
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
          case 0 -> asignatura.getNombre();
          case 1 -> asignatura.getCreditos();
          case 2 -> asignatura.isInclusion();
          case 3 -> asignatura.getSeccion();
          default -> null;
      };
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
      return switch (columnIndex) {
          case 0 -> String.class;
          case 1 -> Integer.class;
          case 2 -> Boolean.class;
          case 3 -> String.class;
          default -> null;
      };
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex == 2 || columnIndex == 3; // Editable checkboxes and toggle lists
  }

  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    Asignatura subject = asignaturas.get(rowIndex);
    switch (columnIndex) {
      case 2 -> {
          subject.setInclusion((boolean) value);
          fireTableCellUpdated(rowIndex, columnIndex); // Update table
          }
      case 3 -> {
          subject.setSeccion((String) value);
          fireTableCellUpdated(rowIndex, columnIndex); // Update table
          }
    }
  }

  public void addSubject(Asignatura subject) {
    asignaturas.add(subject);
    fireTableRowsInserted(asignaturas.size() - 1, asignaturas.size() - 1); // Update table
  }
}