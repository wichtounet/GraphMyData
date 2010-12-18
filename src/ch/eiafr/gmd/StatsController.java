package ch.eiafr.gmd;

public class StatsController {
    private final Stats stats;

    public StatsController(Stats stats) {
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