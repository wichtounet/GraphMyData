package ch.eiafr.gmd;

import java.awt.Graphics2D;

/**
 * Axis object that can be drown on a graphic context
 */
public class HistogramAxis implements Drawable {

    // Constants
    public static final int NUMBER_INDICATORS  = 5;
    public static final int INDICATOR_POS_X    = 10;
    public static final int INDICATOR_WIDTH    = 4;
    public static final int INDICATOR_TEXT_GAP = 4;
    
    private int componentHeight;
    private int maxValue;
    
    /**
     * Constructor
     * 
     * @param maxVal the maximum value in the data
     */
    public HistogramAxis(int maxVal) {
        maxValue = maxVal;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.translate(0, HistogramView.PADDING_TOP);
        
        // Draw the axis
        g2d.drawLine(0, 0, 0, componentHeight);
        
        // Draw the markers on the axis
        for(int i = 0; i <= NUMBER_INDICATORS; i++) {
            int indicatorHeight = (int)(componentHeight - i * componentHeight / (double)NUMBER_INDICATORS);
            int indicatorValue  = (int)(i * maxValue / (double)NUMBER_INDICATORS);
            
            drawIndicator(g2d, indicatorHeight, indicatorValue);
        }
        
        g2d.translate(0, -HistogramView.PADDING_TOP);
    }
    
    /**
     * Defines the height of the axis
     * 
     * @param height the height of the axis
     */
    public void setHeight(int height) {
        componentHeight = height;
    }
    
    private void drawIndicator(Graphics2D g2d, int y, int value) {
        g2d.drawLine(0, y, INDICATOR_WIDTH, y);
        g2d.drawString(String.valueOf(value), INDICATOR_POS_X, y + INDICATOR_TEXT_GAP);
    }
}
