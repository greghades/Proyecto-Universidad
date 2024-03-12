/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.awt.Component;
import java.util.EventObject;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SeccionCellEditor implements TableCellEditor {

  private final JComboBox<String> comboBox;

  public SeccionCellEditor() {
    comboBox = new JComboBox<>(new String[]{"S1", "S2", "S3"});
    comboBox.addActionListener(e -> fireEditingStopped()); // Handle selection change
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
    comboBox.setSelectedItem(value == null ? "" : value.toString()); // Set initial selection
    return comboBox;
  }

  @Override
  public Object getCellEditorValue() {
    return comboBox.getSelectedItem();
  }

  @Override
  public boolean stopCellEditing() {
    return true;
  }

  @Override
  public boolean isCellEditable(EventObject anEvent) {
    return true; // Allow editing for all cells
  }

  @Override
  public void cancelCellEditing() {
    // Handle potential cancellation (optional)
  }

  private ChangeListener listener;

  public void addCellEditorListener(ChangeListener l) {
    listener = l;
  }

  public void removeCellEditorListener(ChangeListener l) {
    listener = null;
  }

  private void fireEditingStopped() {
    if (listener != null) {
      listener.stateChanged(new ChangeEvent(this));
      System.out.println("This sentence will work!");
    }
  }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
