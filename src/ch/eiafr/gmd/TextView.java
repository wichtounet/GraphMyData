package ch.eiafr.gmd;

import javax.swing.JPanel;

public class TextView extends JPanel implements StatsListener{
    private final Stats stats;

    protected TextView(Stats stats) {
        this.stats = stats;
    }

    protected Stats getStats() {
        return stats;
    }

    @Override
    public void fireStatsModified() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
