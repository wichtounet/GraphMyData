package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class HistogramResults implements Drawable {

    List<HistogramBar> bars;

    //    public HistogramResults(/*List<HistogramBar> bars*/) {
    //        //this.bars = bars; 
    //        bars = new ArrayList<HistogramBar>();
    //    }

    public HistogramResults(/*List<Integer> values*/) {
        //this.bars = bars; 
        bars = new ArrayList<HistogramBar>();

        /*for(int value : values) {
            bars.add(new HistogramBar(Color.BLUE, 20, value));
        }*/
    }
    
    public void addBar(int value) {
        bars.add(new HistogramBar(Color.BLUE, 20, value));
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        for(HistogramBar bar : bars) {
            //System.out.println("ouaha");
            //g2d.translate(20, 0);
            bar.draw(g2d);
            g2d.translate(25, 0);
        }
    }
}
