package ch.eiafr.gmd;

import javax.swing.BorderFactory;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class HistogramView extends GraphView {
    
    Stats stats;
    
    protected HistogramView(Stats stats) {
        super(stats);

        this.stats = stats;
        setBorder(BorderFactory.createBevelBorder(1));
    }

    @Override
    public void fireStatsModified() {

        //if(stats.getResults().size() < 2)
            //throw new IllegalStateException("There must be min 2 results in ");
        
        // Repaint the chart with new values
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        List<Result> results = stats.getResults();
        
        int i = 1;
        
        for(Result result : results) {
            
            List<Integer> values = result.getValues();
            
            System.out.println("n: " + results.size() + " i: " + i);
            
            g2d.drawString(values.get(0).toString(), 10.f, 10.f * i);
            g2d.drawString(values.get(1).toString(), 60.f, 10.f * i);
            
            i++;
        }
    }
}
