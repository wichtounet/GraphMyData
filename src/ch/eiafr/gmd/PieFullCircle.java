package ch.eiafr.gmd;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

/**
 * Represent a full circle with different parts in pie chart
 * 
 * @author ButtyX
 */
public class PieFullCircle implements Drawable{
    
    private int[] parts;
    private int   sum;
    private int   width;
    private int   height;
    private int   x;
    private int   y;
    
    public PieFullCircle(int[] parts,  int x, int y, int w, int h){
        this.parts  = parts;
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
        Arc2D.Double tmpArc;
        int startAngle = 0;
        int endAngle   = 0;
        
        if(sum!=0){
            // Create & draw each part
            for(int value:parts)
            {
                if(value==0)continue;
                endAngle = (int) (startAngle+((double)360*((double)value/(double)sum))); 
                System.out.println("value: "+value);
                System.out.println("Start angle: "+startAngle);
                System.out.println("End angle: "+endAngle);
                tmpArc   = new Arc2D.Double(x, y, width, height, startAngle, endAngle, Arc2D.PIE);
                startAngle = endAngle;
                g2d.draw(tmpArc);
            }
        }
        
    }

}
