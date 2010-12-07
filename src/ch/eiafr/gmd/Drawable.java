package ch.eiafr.gmd;
import java.awt.Graphics2D;

/**
 * Defines an object that can be drawn on a graphics 2D context
 */
public interface Drawable {

    /**
     * Draw this object on a graphics 2D context
     * 
     * @param g2d the context on which to draw this object
     */
    void draw(Graphics2D g2d);
    
}
