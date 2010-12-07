package ch.eiafr.gmd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import ch.eiafr.gmd.helpers.GraphicsUtils;

/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {
    
    private static final int PADDING_BOTTOM = 10;

    private List<Drawable> drawableObjs;
    private double maxValue;
    private int width;
    
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
        width = 0;
        
        for(Result result : results) {
            HistogramResults histResult = new HistogramResults();
            
            for(int value : result.getValues()) {
                histResult.addBar(value);
                maxValue = value > maxValue ? value : maxValue;
                width += HistogramBar.WIDTH + HistogramBar.PADDING;
            }
            
            drawableObjs.add(histResult);
            width += HistogramResults.PADDING;
        }
        
        drawableObjs.add(new HistogramAxes());
        
        // TODO: Adapt size of the component (for scrolling)
        //setPreferredSize(new Dimension(width, getHeight()));
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        GraphicsUtils.transformCartesianCoordinates(g2d, getHeight());;
        
        g2d.translate(0, PADDING_BOTTOM);
        g2d.scale(1, (getHeight() - PADDING_BOTTOM) / (double)maxValue);
        
        // Draw all objects
        for(Drawable object : drawableObjs) {
            object.draw(g2d);
            g2d.translate(30, 0);
        }
    }
}
