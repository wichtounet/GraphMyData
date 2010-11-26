package ch.eiafr.gmd;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public final class TextView extends JPanel implements StatsListener {
    private final Stats stats;

    private final JLabel bestLabel;
    private final JLabel averageLabel1;
    private final JLabel averageLabel2;
    private final JLabel minLabel1;
    private final JLabel minLabel2;
    private final JLabel maxLabel1;
    private final JLabel maxLabel2;

    private final ComputedStats compute1 = new ComputedStats();
    private final ComputedStats compute2 = new ComputedStats();

    protected TextView(Stats stats) {
        this.stats = stats;

        ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();

        layout.addRow("t......t");
        layout.addRow("....7...");
        layout.addRow("z~~zs~~s");
        layout.addRow("....5...");
        layout.addRow("a<.ab<.b");
        layout.addRow("c<.cd<.d");
        layout.addRow("e<.ef<.f");

        setLayout(layout);

        bestLabel = new JLabel();
        add(bestLabel, "t");

        Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>(1);
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        Component firstLabelTitle = new JLabel("Premier test");
        firstLabelTitle.setFont(firstLabelTitle.getFont().deriveFont(fontAttributes));
        add(firstLabelTitle, "z");

        Component secondLabelTitle = new JLabel("Second test");
        secondLabelTitle.setFont(secondLabelTitle.getFont().deriveFont(fontAttributes));
        add(secondLabelTitle, "s");

        averageLabel1 = new JLabel();
        add(averageLabel1, "a");

        averageLabel2 = new JLabel();
        add(averageLabel2, "b");

        minLabel1 = new JLabel();
        add(minLabel1, "c");

        minLabel2 = new JLabel();
        add(minLabel2, "d");

        maxLabel1 = new JLabel();
        add(maxLabel1, "e");

        maxLabel2 = new JLabel();
        add(maxLabel2, "f");

        computeStats();
        refreshView();
    }

    private void computeStats() {
        double average1 = 0;
        double average2 = 0;

        for(Result result : stats.getResults()){
            average1 += result.getValues().get(0);
            average2 += result.getValues().get(1);

            compute1.min = Math.min(compute1.min, result.getValues().get(0));
            compute2.min = Math.min(compute2.min, result.getValues().get(1));

            compute1.max = Math.max(compute1.max, result.getValues().get(0));
            compute2.max = Math.max(compute2.max, result.getValues().get(1));
        }

        compute1.average = average1 / stats.getResults().size();
        compute2.average = average2 / stats.getResults().size();
        
        //Ecart-type
        //Variance
        //Médiane
        //Minimax
    }

    private void refreshView() {
        int best = compute1.average < compute2.average ? 1 : 2;

        bestLabel.setText("Meilleur test : " + best);

        averageLabel1.setText(String.format("Moyenne : %.2fs", compute1.average));
        averageLabel2.setText(String.format("Moyenne : %.2fs", compute2.average));

        minLabel1.setText(String.format("Min : %.2fs", compute1.min));
        minLabel2.setText(String.format("Min : %.2fs", compute2.min));

        maxLabel1.setText(String.format("Max : %.2fs", compute1.max));
        maxLabel2.setText(String.format("Max : %.2fs", compute2.max));
    }

    @Override
    public void fireStatsModified() {
        computeStats();
        refreshView();
    }

    private class ComputedStats {
        private double average;
        private double min = Double.MAX_VALUE;
        private double max = Double.MIN_VALUE;
    }
}
