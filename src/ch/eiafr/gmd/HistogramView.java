package ch.eiafr.gmd;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.eiafr.gmd.helpers.GraphicsUtils;


/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {
    
    private static final int PADDING_BOTTOM = 10;

    private List<Drawable> drawableObjs;
    private double maxValue;

    protected HistogramView(Stats stats) {
        super(stats);
        update();
    }

    @Override
    public void fireStatsModified() {
        // Update the objects and repaint the chart with new values
        update();
    }

    public void update() {
        drawableObjs = new ArrayList<Drawable>();
        List<Result> results = getStats().getResults();
        maxValue = 0;
        
        // Get the max value to handle max bar height
        /*double maxValue = 0;
        for(Result result : results)
            for(int value : result.getValues())new 
                maxValue = value > maxValue ? value : maxValue;*/
        
        // TODO: handle this in a better way...
        int posX = 2;

        for(Result result : results) {
            
            HistogramResults histResult = new HistogramResults();
            
            for(int value : result.getValues()) {
                histResult.addBar(value);
                
                maxValue = value > maxValue ? value : maxValue;
            }
            
            drawableObjs.add(histResult);
            
            //drawableObjs.add(new HistogramResults(result.getValues()));
            
            /*for(int value : result.getValues()) {
                //int barHeight = (int)(value / maxValue * getHeight());
                //System.out.println("val: " + value + " max: " + maxValue + "height: " + getHeight());
                
                //drawableObjs.add(new HistogramBar(Color.BLUE, posX, value));
                //posX += 22;
                
                //bars.ad
                histResults.addBar(new HistogramBar(value));
                
                maxValue = value > maxValue ? value : maxValue;
            }*/
        }
        
        // TODO: adapt size
        //setPreferredSize(new Dimension(500, getHeight()));
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        //g2d.drawString("Hello", 15, 15);
        GraphicsUtils.transformCartesianCoordinates(g2d, getHeight());;
        
        g2d.translate(0, PADDING_BOTTOM);
        g2d.scale(1, (getHeight() - PADDING_BOTTOM) / (double)maxValue);
        
        // Draw all objects
        for(Drawable object : drawableObjs) {
            object.draw(g2d);
            g2d.translate(30, 0);
        }
    }
    
    /*private void drawBars(Graphics2D g2d) {
        
    }
    
    private void drawAxe(Graphics2D g2d) {
        
    }*/
}
