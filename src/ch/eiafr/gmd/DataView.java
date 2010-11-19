package ch.eiafr.gmd;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

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

        JTable table = new JTable(tableModel);

        AddAction addAction = new AddAction(controller);
        DeleteAction deleteAction = new DeleteAction(controller, table, tableModel);

        KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), delete);
        table.getActionMap().put(table.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)), deleteAction);

        KeyStroke add = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0);
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), add);
        table.getActionMap().put(table.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0)), addAction);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, constraints);

        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weighty = 0.0;

        Container buttonPanel = new JPanel();

        buttonPanel.add(new JButton(addAction));
        buttonPanel.add(new JButton(deleteAction));

        add(buttonPanel, constraints);
    }
}