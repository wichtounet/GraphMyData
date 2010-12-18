package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a group of bars in an histogram graph
 */
public class HistogramResults implements Drawable {
    
    // Constants
    public static final int     PADDING = 10;
    public static final Color[] COLORS  = {
                                              new Color(0, 69, 134),    // A blue
                                              new Color(255, 56, 14),   // A red
                                              new Color(255, 211, 32)   // A yellow
                                          };

    private List<HistogramBar> bars;
    private int index;

    /**
     * Constructor
     */
    public HistogramResults() { 
        bars = new ArrayList<HistogramBar>();
        index = 0;
    }
    
    /**
     * Add a bar to this group of bars
     * 
     * @param value the value of this bar
     */
    public void addBar(int value) {
        bars.add(new HistogramBar(COLORS[index++ % COLORS.length], PADDING, value));
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        
        for(HistogramBar bar : bars)
            bar.draw(g2d);
        
        g2d.translate(PADDING, 0);
    }
}
