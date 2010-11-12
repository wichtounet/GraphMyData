package ch.eiafr.gmd;

import java.util.EventListener;

public interface StatsListener extends EventListener {
    void fireStatsModified();
}