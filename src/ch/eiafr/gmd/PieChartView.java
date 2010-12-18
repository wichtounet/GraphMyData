package ch.eiafr.gmd;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Class to display a pie chart 
 * 
 * @author ButtyX
 *
 */
public class PieChartView extends GraphView {
    private static final int MARGIN   = 10;
    private static final int SIZE_REC = 8;
    
    protected PieChartView(Stats stats) {
        super(stats);
    }

    @Override
    public void fireStatsModified() {        
        
        // Repaint the pie chart with the new value
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int[][] results = getValues();

        if(results.length > 0){
            Graphics2D g2d = (Graphics2D) g;

            // Draw the legend of the pie charts
            String[] titles = {"< 10", "< 25", "> 25"};
            drawLegend(titles, g2d);

            int y = MARGIN;
            int x = 60;

            // Compute the maxsize of a pie chart
            int size;
            int maxWidth = (getWidth() - MARGIN) / results[0].length;
            if (maxWidth < getHeight() - 2 * MARGIN)
                size = maxWidth;
            else
                size = getHeight() - 2 * MARGIN;

            // Draw the pie chart for all the application
            for (int[] r : results) {
                new PieFullCircle(r, x, y, size, size).draw(g2d);
                x += size + 3 * MARGIN;
            }
        }
    }
    
    /**
     * Get the values for the pie chart from the results
     * @return the values for each application
     */
    private int[][] getValues()
    {
        if(getStats().getResults().isEmpty()){
            return new int[0][0];
        }

        int[][] values = new int[getStats().getResults().get(0).getValues().size()][3];
        int i = 0;
        for(Result r:getStats().getResults())
        {
            i = 0;
            for(int value:r.getValues())
            {
                if(value<10) {
                    values[i][0]++;
                } else if(value<25) {
                    values[i][1]++;
                } else {
                    values[i][2]++;
                }

                i++;
            }
        }
        
        return values;
    }
    
    /**
     * Draw the legend with the given titles
     * @param titles
     * @param g2d
     */
    private void drawLegend(String[] titles, Graphics2D g2d)
    {
            Rectangle2D.Double      tmpRec;
            int pos   = MARGIN;
            for(int i=0;i<titles.length;i++){
                tmpRec   = new Rectangle2D.Double(MARGIN,pos-MARGIN,SIZE_REC,SIZE_REC);
                g2d.setPaint(PieFullCircle.COLORS[i%PieFullCircle.COLORS.length]);
                g2d.fill(tmpRec);
                
                // Drawing
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(1));
                g2d.draw(tmpRec);
                g2d.drawString(titles[i], 2*MARGIN, pos);
                pos       += 20;
        }
    }
    
}
