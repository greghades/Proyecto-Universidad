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
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Subject;

public class SubjectTableModel extends AbstractTableModel {

  private final List<Subject> subjects;
  private static final String[] columnNames = {"Materia", "Carga Academica", "Inclusion", "Seccion"};

  public SubjectTableModel(List<Subject> subjects) {
    this.subjects = subjects;
  }

  @Override
  public int getRowCount() {
    return subjects.size();
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
    Subject subject = subjects.get(rowIndex);
      return switch (columnIndex) {
          case 0 -> subject.getMateria();
          case 1 -> subject.getCargaAcademica();
          case 2 -> subject.isInclusion();
          case 3 -> subject.getSeccion();
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
    Subject subject = subjects.get(rowIndex);
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

  public void addSubject(Subject subject) {
    subjects.add(subject);
    fireTableRowsInserted(subjects.size() - 1, subjects.size() - 1); // Update table
  }
}