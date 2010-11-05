package ch.eiafr.gmd;

import java.util.List;

public interface Stats  {
    //Stats

    List<Result> getResults();

    void addStatsListener(StatsListener listener);
    void removeStatsListener(StatsListener listener);
}