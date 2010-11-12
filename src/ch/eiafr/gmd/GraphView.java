package ch.eiafr.gmd;

import javax.swing.JComponent;

public abstract class GraphView extends JComponent implements StatsListener {
    private final Stats stats;

    protected GraphView(Stats stats) {
        this.stats = stats;
    }

    protected Stats getStats() {
        return stats;
    }
}