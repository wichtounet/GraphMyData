package ch.eiafr.gmd;

import javax.swing.BorderFactory;

public class PieChartView extends GraphView {
    protected PieChartView(Stats stats) {
        super(stats);

        setBorder(BorderFactory.createBevelBorder(1));
    }

    @Override
    public void fireStatsModified() {
        //TODO
    }
}
