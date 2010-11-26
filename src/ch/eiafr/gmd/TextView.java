package ch.eiafr.gmd;

import javax.swing.JLabel;
import javax.swing.JPanel;

public final class TextView extends JPanel implements StatsListener {
    private final Stats stats;

    private final JLabel averageLabel;

    private final ComputedStats compute1 = new ComputedStats();
    private final ComputedStats compute2 = new ComputedStats();

    protected TextView(Stats stats) {
        this.stats = stats;

        averageLabel = new JLabel();

        add(averageLabel);

        computeStats();
        refreshView();
    }

    private void computeStats() {
        double average1 = 0;
        double average2 = 0;

        for(Result result : stats.getResults()){
            average1 += result.getValues().get(0);
            average2 += result.getValues().get(1);
        }

        compute1.average = average1 / stats.getResults().size();
        compute2.average = average2 / stats.getResults().size();

        //Compute moyenne
        //Ecart-type
        //Variance
        //Médiane
        //Minimax
    }

    private void refreshView() {
        int best = compute1.average < compute2.average ? 1 : 2;

        averageLabel.setText("Meilleur test : " + best);
    }

    @Override
    public void fireStatsModified() {
        computeStats();
        refreshView();
    }

    private class ComputedStats {
        private double average;
    }
}
