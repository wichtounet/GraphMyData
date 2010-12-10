package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represent a bar in an histogram graph
 */
public class HistogramBar implements Drawable {
    
    public static final int PADDING = 3;
    public static final int WIDTH   = 25;
    
    private Color color;
    private int value;
    
    public HistogramBar(Color color, int position, int value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        g2d.setColor(color);
        g2d.fillRect(0, 0, WIDTH, value);
        g2d.setColor(contextColor);
        g2d.translate(PADDING + HistogramBar.WIDTH, 0);
    }
}
