package ch.eiafr.gmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class StatsModel implements Stats {
    private static final int INITIAL_CAPACITY = 25;

    private final Collection<StatsListener> listeners = new ArrayList<StatsListener>(2);
    private final List<Result> results = new ArrayList<Result>(INITIAL_CAPACITY);

    public StatsModel() {
        super();

        results.add(new SimpleResult(Arrays.asList(2, 5)));
        results.add(new SimpleResult(Arrays.asList(10, 15)));
        results.add(new SimpleResult(Arrays.asList(22, 25)));
    }

    @Override
    public List<Result> getResults() {
        return results;
    }

    @Override
    public void addStatsListener(StatsListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeStatsListener(StatsListener listener) {
        listeners.remove(listener);
    }

    private void fireStatsModified() {
        for (StatsListener listener : listeners) {
            listener.fireStatsModified();
        }
    }

    public void addResult(Integer[] values) {
        results.add(new SimpleResult(Arrays.asList(values)));

        fireStatsModified();
    }

    public void removeResult(Result result) {
        results.remove(result);

        fireStatsModified();
    }

    private static class SimpleResult implements Result {
        private final List<Integer> integers;

        private SimpleResult(List<Integer> values) {
            super();

            integers = new ArrayList<Integer>(values);
        }

        @Override
        public List<Integer> getValues() {
            return integers;
        }
    }
}