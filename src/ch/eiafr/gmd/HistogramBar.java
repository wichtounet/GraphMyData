package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represent a bar in an histogram graph
 */
public class HistogramBar implements Drawable {
    
    //private static final int PADDING_BOTTOM = 10;
    private static final int BAR_WIDTH      = 20;
    
    private Color color;
    private int position;
    private int value;
    
    public HistogramBar(Color color, int position, int value) {
        this.color = color;
        this.position = position;
        this.value = value;
    }

    @Override
    public void draw(Graphics2D g2d) {
        //System.out.println("value: " + value + " width: " + BAR_WIDTH + " position: " + position);
        Color contextColor = g2d.getColor();
        
        g2d.setColor(color);
        g2d.fillRect(position, 0, BAR_WIDTH, value);
        g2d.setColor(contextColor);
    }
}
