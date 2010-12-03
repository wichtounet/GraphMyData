package ch.eiafr.gmd.helpers;

import java.awt.Graphics2D;

public class GraphicsUtils {
    
    public static void transformCartesianCoordinates(Graphics2D g2d, int height) {
        g2d.translate(0, height);
        g2d.scale(1, -1);
    }
}
