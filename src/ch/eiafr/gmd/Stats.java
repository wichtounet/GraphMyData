package ch.eiafr.gmd;

import java.util.List;

public interface Stats {
    List<Result> getResults();

    void addStatsListener(StatsListener listener);

    void removeStatsListener(StatsListener listener);

    void addRandomDatas();

    void setValue(int rowIndex, int columnIndex, Integer value);

    void addResult(Integer[] result);

    void removeResult(Result result);
}