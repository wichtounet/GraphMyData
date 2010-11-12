package ch.eiafr.gmd;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class TextView extends JPanel implements StatsListener {
    private final Stats stats;

    protected TextView(Stats stats) {
        this.stats = stats;

        setBorder(BorderFactory.createBevelBorder(1));

        add(new JLabel("Text view !"));
    }

    protected Stats getStats() {
        return stats;
    }

    @Override
    public void fireStatsModified() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
