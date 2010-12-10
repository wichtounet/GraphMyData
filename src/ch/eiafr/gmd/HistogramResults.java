package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/*
 * Represnet a group of bars in an histogram graph
 */
public class HistogramResults implements Drawable {
    
    public static final int     PADDING = 5;
    public static final Color[] COLORS  = {Color.BLUE, Color.RED, Color.YELLOW};

    private List<HistogramBar> bars;
    private int index;

    public HistogramResults() { 
        bars = new ArrayList<HistogramBar>();
        index = 0;
    }
    
    public void addBar(int value) {
        bars.add(new HistogramBar(COLORS[index++ % COLORS.length], PADDING, value));
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        for(HistogramBar bar : bars) {
            bar.draw(g2d);
            g2d.translate(PADDING + HistogramBar.WIDTH, 0);
        }
    }
}
