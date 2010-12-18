package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Represent a bar in an histogram graph
 */
public class HistogramBar implements Drawable {
    
    public static final int PADDING = 0;
    public static final int WIDTH   = 25;
    
    public static final int BAR_ARC_X = 4;
    public static final int BAR_ARC_Y = 1;
    
    private Color color;
    private int value;

    public HistogramBar(Color color, int position, int value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        
        RoundRectangle2D bar = new RoundRectangle2D.Double(0, 0, WIDTH, value, BAR_ARC_X, BAR_ARC_Y);

        g2d.setColor(color);
        g2d.fill(bar);
        
        g2d.setColor(contextColor);
        g2d.translate(PADDING + HistogramBar.WIDTH, 0);
    }
}
