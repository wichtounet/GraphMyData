package ch.eiafr.gmd;

import java.awt.Graphics2D;


public class HistogramAxis implements Drawable {

    public static final int NUMBER_INDICATORS = 5;
    private int componentHeight;
    private int maxValue;
    
    public HistogramAxis(int maxVal) {
        //componentHeight = height;
        maxValue = maxVal;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        //System.out.println("height: " + componentHeight);
        g2d.drawLine(0, 0, 0, componentHeight);
        
        for(int i = 0; i < NUMBER_INDICATORS; i++) {
            int indicatorHeight = (int)(componentHeight - i * componentHeight / (double)NUMBER_INDICATORS);
            int indicatorValue  = (int)(i * maxValue / (double)NUMBER_INDICATORS);
            
            drawIndicator(g2d, indicatorHeight, indicatorValue);
        }
        
        //System.out.println("bla: " + (componentHeight - 1 * NUMBER_INDICATORS / (double)componentHeight));
        System.out.println("height: " + componentHeight);
    }
    
    /*public void draw(Graphics2D g2d, int height) {
        
        
        
    }*/
    
    public void setHeight(int height) {
        componentHeight = height;
    }
    
    private void drawIndicator(Graphics2D g2d, int y, int value) {
        //System.out.println("test " + y);
        //g2d.fillRect(2, y, 5, 5);
        g2d.drawLine(0, y, 4, y);
        g2d.drawString("" + value, 10, y);
    }
}
