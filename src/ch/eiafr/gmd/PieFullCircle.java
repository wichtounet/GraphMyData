package ch.eiafr.gmd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

/**
 * Represent a full circle with different parts in pie chart
 * 
 * @author ButtyX
 */
public class PieFullCircle implements Drawable {


    public static final Color[] COLORS = new Color[]{Color.YELLOW,Color.BLUE,Color.GREEN,
        Color.CYAN,Color.ORANGE,Color.RED,
        Color.WHITE,Color.GRAY,Color.DARK_GRAY,
        Color.LIGHT_GRAY, Color.PINK};

    private int[] parts;
    private int   sum;
    private int   width;
    private int   height;
    private int   x;
    private int   y;


    public PieFullCircle(int[] parts,  int x, int y, int w, int h) {
        this.parts  = parts;
        this.width  = w;
        this.height = h;
        this.x      = x;
        this.y      = y;

        // Compute the sum of all the parts
        for(int i : parts)
            sum+=i;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Arc2D.Double tmpArc;

        int startAngle = 0;
        int endAngle   = 0;

        // If there is something to draw
        if(sum != 0) {
            int i=0;

            // Create & draw each part
            for(int value:parts) {
                // If no results for this case, we continue with the next one
                if(value == 0)
                    continue;

                // Computing the angle
                endAngle = (int)Math.round(((double)360*((double)value/(double)sum))); 

                // Creation of the shape
                tmpArc   = new Arc2D.Double(x, y, width, height, startAngle, endAngle, Arc2D.PIE);

                // Fill the shape 
                g2d.setPaint(COLORS[i%COLORS.length]);
                g2d.fill(tmpArc);

                // Drawing
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(1));
                g2d.draw(tmpArc);

                startAngle = endAngle+startAngle;
                i++;
            }
        }

    }

}
