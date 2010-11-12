package ch.eiafr.gmd;

import javax.swing.table.AbstractTableModel;

import ch.eiafr.gmd.helpers.I18nHelper;

public class DataTableModel extends AbstractTableModel {
    private final Stats stats;

    private final String[] headers = {
            I18nHelper.getString("table.header.first"),
            I18nHelper.getString("table.header.second")
    };

    public DataTableModel(Stats stats) {
        super();

        this.stats = stats;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Result r = stats.getResults().get(row);

        if (column == 0) {
            return r.getValues().get(1);
        } else if (column == 1) {
            return r.getValues().get(1);
        }

        throw new IllegalStateException("System cannot be in this state");
    }

    @Override
    public int getRowCount() {
        return stats.getResults().size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }
}