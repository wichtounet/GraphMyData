package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;


/**
 * View to draw an histogram graph
 */
public class HistogramView extends GraphView {

    Stats stats;
    List<Drawable> drawableObjs;

    protected HistogramView(Stats stats) {
        super(stats);

        this.stats = stats;
        drawableObjs = new ArrayList<Drawable>();
        
        update();
    }

    @Override
    public void fireStatsModified() {
        // Update the objects and repaint the chart with new values
        update();
    }

    public void update() {
        drawableObjs = new ArrayList<Drawable>();
        
        // TODO: handle this in a better way...
        int posX = 2;

        for(Result result : stats.getResults()) {
            for(int value : result.getValues()) {
                drawableObjs.add(new HistogramBar(Color.BLUE, posX, value));
                
                posX += 22;
            }
        }
        
        // TODO: adapt size
        //setPreferredSize(new Dimension(500, getHeight()));
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        // Draw all objects
        for(Drawable object : drawableObjs)
            object.draw(g2d);
    }
    
    private AffineTransform getCartesianCoordinateTransform(int h, Insets insets) {
        int insetsTop = insets.top;

        AffineTransform reposition = new AffineTransform();
        reposition.translate(0, h + insetsTop);
        reposition.scale(1, -1);
        
        return reposition;
    }
}
