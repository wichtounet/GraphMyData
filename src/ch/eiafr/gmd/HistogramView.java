package ch.eiafr.gmd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import ch.eiafr.gmd.helpers.GraphicsUtils;

/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {
    
    public static final int PADDING_TOP    = 5;
    public static final int PADDING_BOTTOM = 5;
    public static final int BAR_START      = 30;
    //private static final int PADDING = 20;
    
    private HistogramAxis axis;
    private List<Drawable> drawableResults;
    private int maxValue;
    private int width;

    protected HistogramView(Stats stats) {
        super(stats);
        update();
        //setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));
    }

    @Override
    public void fireStatsModified() {
        // Update the objects and repaint the chart with new values
        update();
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
        //setPreferredSize(new Dimension(width, getHeight()));
        
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        // Draw the y axis
        axis.setHeight(getHeight() - PADDING_TOP - PADDING_BOTTOM);
        axis.draw(g2d);
        
        // Adapt the height of the graph
        GraphicsUtils.transformCartesianCoordinates(g2d, getHeight());
        g2d.translate(BAR_START, PADDING_BOTTOM);
        g2d.scale(1, (getHeight() - PADDING_TOP - PADDING_BOTTOM) / (double)maxValue);
        
        // Draw all results
        for(Drawable object : drawableResults) {
            object.draw(g2d);
        }
    }
}
