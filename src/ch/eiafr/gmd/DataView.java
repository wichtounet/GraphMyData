package ch.eiafr.gmd;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

public class DataView extends JPanel {
    private final Stats stats;

    public DataView(Stats stats, StatsController controller) {
        super(new GridBagLayout());

        this.stats = stats;

        build(controller);

        setMinimumSize(getSize());
    }

    private void build(StatsController controller) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weighty = 1.0;

        DataTableModel tableModel = new DataTableModel(stats);
        stats.addStatsListener(tableModel);

        JTable table = new JTable(tableModel);

        AddAction addAction = new AddAction(controller);
        DeleteAction deleteAction = new DeleteAction(controller, table, tableModel);

        bind(table, deleteAction, KeyEvent.VK_DELETE);
        bind(table, addAction, KeyEvent.VK_A);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, constraints);

        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weighty = 0.0;

        Container buttonPanel = new JPanel();

        buttonPanel.add(new JButton(addAction));
        buttonPanel.add(new JButton(deleteAction));

        add(buttonPanel, constraints);
    }

    private static void bind(JComponent table, Action deleteAction, int key) {
        KeyStroke delete = KeyStroke.getKeyStroke(key, 0);
        table.getInputMap().put(KeyStroke.getKeyStroke(key, 0), delete);
        table.getActionMap().put(table.getInputMap().get(KeyStroke.getKeyStroke(key, 0)), deleteAction);
    }
}