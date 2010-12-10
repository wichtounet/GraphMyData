package ch.eiafr.gmd;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import ch.eiafr.gmd.helpers.Config;
import ch.eiafr.gmd.helpers.SwingHelper;

public class DataView extends JPanel {
    private final Stats stats;

    public DataView(Stats stats, StatsController controller) {
        super(new GridBagLayout());

        this.stats = stats;

        build(controller);

        setPreferredSize(new Dimension(350, Config.getIntValue("frame.height")));
        setMinimumSize(new Dimension(350, Config.getIntValue("frame.height")));
    }

    private void build(StatsController controller) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;

        DataTableModel tableModel = new DataTableModel(stats);
        stats.addStatsListener(tableModel);

        JTable table = new JTable(tableModel);

        AddPanel addPanel = new AddPanel(controller);

        AddAction addAction = new AddAction(addPanel);
        DeleteAction deleteAction = new DeleteAction(controller, table, tableModel);

        SwingHelper.bind(table, deleteAction, KeyEvent.VK_DELETE);
        SwingHelper.bind(this, addAction, KeyEvent.VK_A);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, constraints);

        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;

        add(addPanel, constraints);

        constraints.gridy = 2;

        Container buttonPanel = new JPanel();

        buttonPanel.add(new JButton(addAction));
        buttonPanel.add(new JButton(deleteAction));

        add(buttonPanel, constraints);
    }

}