package ch.eiafr.gmd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

/**
 * Represent a full circle with different parts in pie chart
 * 
 * @author ButtyX
 */
public class PieFullCircle implements Drawable{
    
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
        
        System.out.println("Sum full circle: "+sum);
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        Arc2D.Double tmpArc;
        int startAngle = 0;
        int endAngle   = 0;
        Color[] colors = new Color[]{Color.YELLOW,Color.BLUE,Color.GREEN,
                                     Color.CYAN,Color.ORANGE,Color.RED,
                                     Color.WHITE,Color.GRAY,Color.DARK_GRAY,
                                     Color.LIGHT_GRAY, Color.PINK};
        
        int pos=10;
        if(sum!=0){
            int i=0;
            // Create & draw each part
            for(int value:parts)
            {
                if(value==0)continue;
                endAngle = (int) (((double)360*((double)value/(double)sum))); 
                tmpArc   = new Arc2D.Double(x, y, width, height, startAngle, endAngle, Arc2D.PIE);
                g2d.setPaint(colors[i%colors.length]);
                g2d.fill(tmpArc);
                g2d.drawString(titles[i], width+6, pos);
                pos+=20;
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(1));
                startAngle = endAngle+startAngle;
                i++;
                g2d.draw(tmpArc);
            }
        }
        
    }

}
