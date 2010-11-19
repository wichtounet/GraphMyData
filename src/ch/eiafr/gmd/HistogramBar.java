package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represent a bar in an histogram graph
 */
public class HistogramBar implements Drawable {

    Color color;
    
    public HistogramBar(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // TODO Auto-generated method stub
        
    }
}
