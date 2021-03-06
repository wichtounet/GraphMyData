package ch.eiafr.gmd;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;

import ch.eiafr.gmd.helpers.I18nHelper;

public class DataTableModel extends AbstractTableModel implements StatsListener {
    private final Stats stats;
    private final List<Result> results;

    private final String[] headers = {
            I18nHelper.getString("table.header.first"),
            I18nHelper.getString("table.header.second")
    };

    public DataTableModel(Stats stats) {
        super();

        this.stats = stats;

        results = new ArrayList<Result>(stats.getResults());
    }

    @Override
    public Object getValueAt(int row, int column) {
        Result r = stats.getResults().get(row);

        return r.getValues().get(column);
    }

    @Override
    public int getRowCount() {
        return stats.getResults().size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public void fireStatsModified() {
        results.clear();
        results.addAll(stats.getResults());

        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        stats.setValue(rowIndex, columnIndex, (Integer) aValue);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }

    public Result getResult(int row) {
        return stats.getResults().get(row);
    }
}