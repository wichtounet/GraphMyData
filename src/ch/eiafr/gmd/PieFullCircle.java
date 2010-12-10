package ch.eiafr.gmd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

/**
 * Represent a full circle with different parts in pie chart
 * 
 * @author ButtyX
 */
public class PieFullCircle implements Drawable{
    
    private static int SIZE_REC = 8;
    private static int MARGIN  = 12;
    private static final Color[] COLORS = new Color[]{Color.YELLOW,Color.BLUE,Color.GREEN,
                                                      Color.CYAN,Color.ORANGE,Color.RED,
                                                      Color.WHITE,Color.GRAY,Color.DARK_GRAY,
                                                      Color.LIGHT_GRAY, Color.PINK};
      
    private int[]    parts;
    private String[] titles;
    private int   sum;
    private int   width;
    private int   height;
    private int   x;
    private int   y;
    
    
    public PieFullCircle(String[] titles, int[] parts,  int x, int y, int w, int h){
        this.parts  = parts;
        this.titles = titles;
        this.width  = w;
        this.height = h;
        this.x      = x;
        this.y      = y;
        
        // Compute the sum of all the parts
        for(int i:parts)sum+=i;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        
        // Antialiasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);     
        
        Arc2D.Double            tmpArc;
        Rectangle2D.Double      tmpRec;
        
        int startAngle = 0;
        int endAngle   = 0;
        
        int pos= MARGIN;
        
        // If there is something to draw
        if(sum!=0){
            int i=0;
            
            // Create & draw each part
            for(int value:parts)
            {
                // If no results for this case, we continue with the next one
                if(value==0)continue;
                
                // Computing the angle
                endAngle = (int) (((double)360*((double)value/(double)sum))); 
                
                // Creation of the shapes
                tmpArc   = new Arc2D.Double(x, y, width, height, startAngle, endAngle, Arc2D.PIE);
                tmpRec   = new Rectangle2D.Double(width+MARGIN,pos-MARGIN,SIZE_REC,SIZE_REC);
                
                // Fill the shapes with the good color
                g2d.setPaint(COLORS[i%COLORS.length]);
                g2d.fill(tmpArc);
                g2d.fill(tmpRec);
                
                // Drawing
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(1));
                g2d.draw(tmpArc);
                g2d.draw(tmpRec);
                g2d.drawString(titles[i], width+2*MARGIN, pos);
                
                startAngle = endAngle+startAngle;
                pos       += 20;
                i++;
            }
        }
        
    }

}
