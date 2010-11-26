package ch.eiafr.gmd;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class to display a pie chart 
 * 
 * @author ButtyX
 *
 */
public class PieChartView extends GraphView {
    private final Stats stats;
    
    protected PieChartView(Stats stats) {
        super(stats);

        this.stats = stats;
    }

    @Override
    public void fireStatsModified() {        
        
        // Repaint the pie chart with the new value
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        int[][] values = new int[stats.getResults().size()][3];
        int i = 0;
        for(Result r:stats.getResults())
        {
            for(int value:r.getValues())
            {
                if(value<10)values[i][0]++;
                else if(value<25)values[i][1]++;
                else values[i][2]++;
            }
        }
        
        new PieFullCircle(values[0],10,10,200,200).draw(g2d);
        
    }
    
}
