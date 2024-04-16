
package util;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RetirarMateriaSelectionListener implements ListSelectionListener {

    private JTable table;

    public RetirarMateriaSelectionListener(JTable table) {
        this.table = table;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedColumn = table.getSelectedColumn();
            int selectedRow = table.getSelectedRow();

            if (selectedColumn != -1 && selectedRow != -1) {
                for (int row = 0; row < table.getRowCount(); row++) {
                    if (row != selectedRow) {
                        table.setValueAt(false, row, selectedColumn);
                    }
                }
            }
        }
    }
}
