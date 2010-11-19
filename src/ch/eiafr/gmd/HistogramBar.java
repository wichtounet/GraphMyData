package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represent a bar in an histogram graph
 */
public class HistogramBar implements Drawable {

    Color color;
    int position;
    int height;
    
    public HistogramBar(Color color, int position, int height) {
        this.color = color;
        this.position = position;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        
        g2d.setColor(color);
        g2d.fillRect(position, 10, 20, height);
        g2d.setColor(contextColor);
    }
}
