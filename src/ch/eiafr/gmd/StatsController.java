package ch.eiafr.gmd;

public class StatsController {
    private final StatsModel stats;

    public StatsController(StatsModel stats) {
        super();

        this.stats = stats;
    }

    public void addResult(Integer[] result) {
        stats.addResult(result);
    }

    public void removeResult(Result result) {
        stats.removeResult(result);
    }
}