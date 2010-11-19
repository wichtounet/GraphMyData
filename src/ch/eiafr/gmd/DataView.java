package ch.eiafr.gmd;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import ch.eiafr.gmd.helpers.I18nHelper;

public class DataView extends JPanel {
    private final Stats stats;

    public DataView(Stats stats, StatsController controller) {
        super(new GridBagLayout());

        this.stats = stats;

        setBorder(BorderFactory.createBevelBorder(1));

        build(controller);
    }

    private void build(StatsController controller) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = GridBagConstraints.REMAINDER;
        constraints.gridy = 1;

        add(new JLabel(I18nHelper.getString("label.data")), constraints);

        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weighty = 1.0;

        DataTableModel tableModel = new DataTableModel(stats);
        stats.addStatsListener(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(new JTable(tableModel));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, constraints);

        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weighty = 0.0;

        add(new ButtonPanel(controller), constraints);
    }
}