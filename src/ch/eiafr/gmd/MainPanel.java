package ch.eiafr.gmd;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public final class MainPanel extends JPanel {
    public MainPanel(Stats stats) {
        super(new GridBagLayout());

        build(stats);
    }

    private void build(Stats stats) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;

        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.gridwidth = GridBagConstraints.RELATIVE;

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;

        add(new DataView(stats), constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        add(new TextView(stats), constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridheight = 1;

        constraints.gridheight = GridBagConstraints.RELATIVE;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        add(new PieChartView(stats), constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;

        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        add(new HistogramView(stats), constraints);
    }
}