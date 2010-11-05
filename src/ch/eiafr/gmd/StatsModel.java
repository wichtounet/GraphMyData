package ch.eiafr.gmd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: wichtounet Date: Nov 5, 2010 Time: 11:40:58 AM To change this template use File |
 * Settings | File Templates.
 */
public class StatsModel implements Stats {
    private final Collection<StatsListener> listeners = new ArrayList<StatsListener>(2);
    
    @Override
    public List<Result> getResults() {

        //asdfasdfadsf
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addStatsListener(StatsListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeStatsListener(StatsListener listener) {
        listeners.remove(listener);
    }

    private void fireStatsModified(){
        for(StatsListener listener : listeners){
            listener.fireStatsModified();
        }
    }
}