package ch.eiafr.gmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public final class StatsModel implements Stats {
    private static final int INITIAL_CAPACITY = 25;

    private final Collection<StatsListener> listeners = new ArrayList<StatsListener>(2);
    private final List<Result> results = new ArrayList<Result>(INITIAL_CAPACITY);

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

    @Override
    public void addRandomDatas() {
        Random random = new Random();

        for(int i = 0; i < 10; i++){
            results.add(new SimpleResult(Arrays.asList(random.nextInt(50), random.nextInt(50))));
        }

        fireStatsModified();
    }

    @Override
    public void setValue(int rowIndex, int columnIndex, Integer value) {
        if(rowIndex >= results.size()){
            return;
        }

        results.get(rowIndex).getValues().set(columnIndex, value);

        fireStatsModified();
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