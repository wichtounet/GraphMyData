package ch.eiafr.gmd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import ch.eiafr.gmd.helpers.GraphicsUtils;

/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {
    
    // Constants
    public static final int PADDING_TOP    = 5;
    public static final int PADDING_BOTTOM = 5;
    public static final int BAR_START      = 30;
    private static final double HEIGHT_FACTOR = 0.9;
    
    private HistogramAxis axis;
    private List<Drawable> drawableResults;
    private int maxValue;
    private int width;

    /**
     * Constructor
     * 
     * @param stats the stats to use as the first values to plot
     */
    protected HistogramView(Stats stats) {
        super(stats);
        update();
    }

    @Override
    public void fireStatsModified() {
        // Update the objects and repaint the chart with new values
        update();
    }
    
    /**
     * Get the height of the graph, taking in count a factor avoiding the
     * problem with scrollbars that take places to draw
     */
    public int getRealHeight() {
        return (int)(getHeight() * HEIGHT_FACTOR);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw the y axis
        axis.setHeight(getRealHeight() - PADDING_TOP - PADDING_BOTTOM);
        axis.draw(g2d);
        
        // Adapt the height of the graph
        GraphicsUtils.transformCartesianCoordinates(g2d, getRealHeight());
        g2d.translate(BAR_START, PADDING_BOTTOM);
        g2d.scale(1, (getRealHeight() - PADDING_TOP - PADDING_BOTTOM) / (double)maxValue);
        
        // Draw all results
        for(Drawable object : drawableResults) {
            object.draw(g2d);
        }
    }
    
    private void update() {
        drawableResults = new ArrayList<Drawable>();
        List<Result> results = getStats().getResults();
        maxValue = 0;
        
        width = 0;

        for (Result result : results) {
            HistogramResults histResult = new HistogramResults();

            for (int value : result.getValues()) {
                histResult.addBar(value);
                maxValue = value > maxValue ? value : maxValue;
                width += HistogramBar.WIDTH + HistogramBar.PADDING;
            }
            
            drawableResults.add(histResult);
            width += HistogramResults.PADDING;
        }
        
        //drawableResults.add(new HistogramAxes(maxValue));
        axis = new HistogramAxis(maxValue);
        
        // Adapt size of the component (for scrolling)
        setPreferredSize(new Dimension(width, getRealHeight()));
        
        repaint();
    }
}
