package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {

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
            for(int value : result.getValues())
                maxValue = value > maxValue ? value : maxValue;*/
        
        // TODO: handle this in a better way...
        int posX = 2;

        for(Result result : results) {
            for(int value : result.getValues()) {
                //int barHeight = (int)(value / maxValue * getHeight());
                //System.out.println("val: " + value + " max: " + maxValue + "height: " + getHeight());
                
                drawableObjs.add(new HistogramBar(Color.BLUE, posX, value));
                
                posX += 22;
                
                maxValue = value > maxValue ? value : maxValue;
            }
        }
        
        // TODO: adapt size
        //setPreferredSize(new Dimension(500, getHeight()));
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        //g2d.setTransform(getCartesianCoordinateTransform(100, new Insets(0, 0, 0, 0)));
        AffineTransform transform = getCartesianCoordinateTransform(200, new Insets(0, 0, 0, 0));
        //g2d.setTransform(transform);
        
        g2d.scale(1, getHeight() / (double)maxValue);
        
        g2d.drawString("Hello", 15, 15);
        
        // Draw all objects
        for(Drawable object : drawableObjs)
            object.draw(g2d);
    }
    
    private static AffineTransform getCartesianCoordinateTransform(int h, Insets insets) {
        int insetsTop = insets.top;

        AffineTransform reposition = new AffineTransform();
        reposition.translate(0, h + insetsTop);
        reposition.scale(1, -1);
        
        return reposition;
    }
}
