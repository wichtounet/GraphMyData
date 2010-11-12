package ch.eiafr.gmd;

import javax.swing.JComponent;

/**
 * Created by IntelliJ IDEA. User: wichtounet Date: Nov 5, 2010 Time: 11:36:27 AM To change this template use File |
 * Settings | File Templates.
 */
public abstract class GraphView extends JComponent implements StatsListener {
    private final Stats stats;

    protected GraphView(Stats stats) {
        this.stats = stats;
    }

    protected Stats getStats() {
        return stats;
    }
}