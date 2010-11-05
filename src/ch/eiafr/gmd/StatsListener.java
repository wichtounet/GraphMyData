package ch.eiafr.gmd;

import java.util.EventListener;

/**
 * Created by IntelliJ IDEA. User: wichtounet Date: Nov 5, 2010 Time: 11:33:49 AM To change this template use File |
 * Settings | File Templates.
 */
public interface StatsListener extends EventListener {
    void fireStatsModified();
}