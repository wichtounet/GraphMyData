package ch.eiafr.gmd;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public final class MainPanel extends JPanel {
    public MainPanel(Stats stats, StatsController controller) {
        super(new GridBagLayout());

        build(stats, controller);
    }

    private void build(Stats stats, StatsController controller) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;

        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.gridwidth = GridBagConstraints.RELATIVE;

        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(25,10,10,10);
        constraints.weighty = 1.0;
        constraints.weightx = 0.0;

        add(new DataView(stats, controller), constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(0,0,0,0);

        constraints.weighty = 0.0;
        constraints.weightx = 1.0;

        TextView textView = new TextView(stats);
        stats.addStatsListener(textView);
        add(textView, constraints);

        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridheight = 1;

        constraints.gridheight = GridBagConstraints.RELATIVE;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        constraints.weighty = 1.0;
        constraints.weightx = 1.0;

        PieChartView pieChartView = new PieChartView(stats);
        stats.addStatsListener(pieChartView);
        add(pieChartView, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;

        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        HistogramView histogramView = new HistogramView(stats);
        stats.addStatsListener(histogramView);
        
        JComponent scroll = new JScrollPane(histogramView);
        scroll.setBorder(null);
        add(scroll, constraints);
    }
}