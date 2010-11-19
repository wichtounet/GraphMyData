package ch.eiafr.gmd;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;

import java.awt.event.ActionEvent;

import ch.eiafr.gmd.helpers.I18nHelper;

public class DeleteAction extends AbstractAction {
    private final StatsController controller;
    private final JTable table;
    private final DataTableModel tableModel;

    public DeleteAction(StatsController controller, JTable table, DataTableModel tableModel) {
        super();

        this.controller = controller;
        this.table = table;
        this.tableModel = tableModel;

        putValue(Action.NAME, I18nHelper.getString("actions.delete"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(table.getSelectedRow() > -1){
            int row = table.getSelectedRow();
            Result result = tableModel.getResult(row);

            controller.removeResult(result);
        }
    }
}
